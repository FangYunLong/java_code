package com.fylong.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface RestTemplateService {

    RestTemplate restTemplate();

}
