package org.josescalia.blog.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by josescalia on 17/02/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String getIndex(Map<String, Object> objectMap){
        objectMap.put("model", new Date());
        objectMap.put("modelName", "josescalia");
        return "index";
    }


    @RequestMapping(value = "/security/info")
    public @ResponseBody Authentication getSecurityInfo(){
        return SecurityContextHolder.getContext().getAuthentication();
    }



}
