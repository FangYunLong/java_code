package com.fylong.web.service.impl;

import com.fylong.web.service.RestTemplateService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateServiceImpl implements RestTemplateService {

    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

}
