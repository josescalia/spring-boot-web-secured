package org.josescalia.blog.simple.controller;

import org.apache.log4j.Logger;
import org.josescalia.blog.simple.model.Publisher;
import org.josescalia.blog.simple.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
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
 * Created by josescalia on 06/02/16.
 */
@Controller
public class PublisherController {

    static Logger logger = Logger.getLogger(PublisherController.class.getName());

    @Autowired
    @Qualifier("publisherRepository")
    private PublisherRepository publisherRepository;

    @RequestMapping(value = "/publisher/list")
    public String getPublisherList(Map<String, Object> objectMap, @RequestParam(required = false) String searchText) {
        if(searchText == null){
            searchText = "";
        }
        objectMap.put("searchText", searchText);
        objectMap.put("publisherList", publisherRepository.getList(searchText));
        objectMap.put("model", new Publisher());
        return "/publisher/list";
    }


    @RequestMapping(value = "/publisher/paginatedList")
    public String getPaginatedPublisherList(Map<String, Object> objectMap, @RequestParam(required = false) String searchText, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer offset) {


        if(searchText == null){
            searchText = "";
        }
        if(page == null){
            page = 0;
        }

        if(offset == null){
            offset = 5;
        }
        Pageable pageable = new PageRequest(page,offset);

        List<Publisher> publisherList = null;
        Page<Publisher> dataList = publisherRepository.getPaginatedList(searchText,pageable);

        if(dataList .getSize() > 0){
            publisherList = new ArrayList<Publisher>();
            for(Iterator<Publisher> iterator = dataList.iterator(); iterator.hasNext();){
                    publisherList.add(iterator.next());
            }
        }


        objectMap.put("searchText", searchText);
        objectMap.put("publisherList", publisherList);
        objectMap.put("model", new Publisher());
        return "/publisher/list";
    }


    @Secured("ADMIN")
    @RequestMapping(value = "/publisher/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Map<String, Object> objectMap) {
        Publisher publisher = publisherRepository.findOne(id);
        objectMap.put("model", publisher);
        return "/publisher/edit";
    }

    @RequestMapping(value = "/service/json/publisher/save", method = RequestMethod.POST)
    public @ResponseBody String savePublisher(Publisher publisher) {
        try {
            publisherRepository.save(publisher);
            return "Save Succeed";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "Save Failed : " + e.getMessage();
        }
    }
}
