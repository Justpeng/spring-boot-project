package com.just.dubbo.server.controller;

import com.just.service.WrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WrapController {

    @Autowired
    private WrapService wrapService;

    @RequestMapping("/word/{param}")
    public String someHandler(@PathVariable("param") String word) {
        return wrapService.wrap(word);
    }

}
