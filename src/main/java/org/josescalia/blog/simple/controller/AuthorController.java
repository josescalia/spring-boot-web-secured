package org.josescalia.blog.simple.controller;

import org.apache.log4j.Logger;
import org.josescalia.blog.simple.model.Author;
import org.josescalia.blog.simple.repository.AuthorRepository;
import org.josescalia.blog.simple.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by josescalia on 03/02/16.
 */
@Controller
public class AuthorController {

    static Logger logger = Logger.getLogger(AuthorController.class.getName());

    @Autowired
    public AuthorRepository authorRepository;

    @RequestMapping(value = "/service/json/author/list", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Author> getList() {
        return (List<Author>) authorRepository.findAll();
    }


    @RequestMapping(value = "/author/list", method = RequestMethod.GET)
    public String getList(Map<String, Object> objectMap, @RequestParam(required = false) String searchText) {
        if(searchText == null){
            searchText = "";
        }
        objectMap.put("authorList", (List<Author>) authorRepository.findFiltered(searchText));
        objectMap.put("model", new Author());
        objectMap.put("searchText", searchText);
        return "author/list";
    }




    @RequestMapping(value = "/service/json/author/save", method = RequestMethod.POST)
    public @ResponseBody String saveAuthor(Author author) {
        try {
            authorRepository.save(author);
            return "Save Succeed";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "Save Failed : " + e.getMessage();
        }
    }

    @RequestMapping(value = "/author/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Map<String, Object> objectMap) {
        Author author = authorRepository.findOne(id);
        objectMap.put("model", author);
        return "/author/edit";
    }

    @RequestMapping(value = "/author/delete", method = RequestMethod.POST)
    public @ResponseBody String delete(@RequestParam Long id) {
        try{
            authorRepository.delete(id);
            return "Delete Succeed";
        }catch (Exception e){
            e.printStackTrace();
            return "Delete Failed :" + e.getMessage();
        }
    }


    @RequestMapping(value = "/author/paginated_list", method = RequestMethod.GET)
    public String getPaginatedList(Map<String, Object> objectMap, @RequestParam(required = false) String searchText, @RequestParam(required = false) Integer page) {
        int start = 0;
        int displayLength = 3;

        if(searchText == null){
            searchText = "";
        }
        if(page == null || page == 1){
            start = 0;
            page =1;
        }else if(page > 1){
            start = (page - 1 ) * displayLength;
        }

        int startRow =  Pagination.getStartRowFromStartAndLength(start,displayLength);

        Page<Author> authorPage = authorRepository.getPaginatedList(searchText, new PageRequest(startRow,displayLength));


        Pagination pagination = new Pagination();
        List<Author> authorList = new ArrayList<Author>();

        for (Iterator<Author> iterator = authorPage.iterator(); iterator.hasNext();){
            authorList.add(iterator.next());
        }

        pagination.setPage(page);
        pagination.setTotalPage(authorPage.getTotalPages());
        pagination.setTotalDisplay(displayLength);
        pagination.setTotalRow((int) authorPage.getTotalElements());

        objectMap.put("authorList", authorList);
        objectMap.put("model", new Author());
        objectMap.put("pagination", pagination);
        objectMap.put("searchText", searchText);
        return "author/paginatedList";
    }




}
