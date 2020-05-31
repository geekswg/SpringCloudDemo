package org.demo.SpringCloud.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springCloud")
public class TestAppController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${user.name}")
    private String userName;
    @Value("${user.email}")
    private String userEmail;

    @RequestMapping("/hello")
    public String hello() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append("Wellcomem SpringBoot , SpringCloud Test Demo");
        tempStr.append("<br/> name is " + userName);
        tempStr.append("<br/> email is " + userEmail);
        return tempStr.toString();
    }

}
