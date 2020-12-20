package com.fylong.web.controller;


import com.fylong.web.entity.User;
import com.fylong.web.service.RestTemplateService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RestTemplateController {


    @Resource
    private RestTemplateService restTemplate;

    @RequestMapping("/get")
    public Object getTest(User user){

        return user;
    }

    @RequestMapping("/test")
    public Object exchange(){

        String url = "http://localhost:8080/get";
        MultiValueMap<String,Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("name","test");
        paramMap.add("age","20");

        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(paramMap);
        ResponseEntity<User> responseEntity =
                restTemplate.restTemplate().exchange(url, HttpMethod.POST, requestEntity ,User.class);

        return responseEntity.getBody();
    }

}
