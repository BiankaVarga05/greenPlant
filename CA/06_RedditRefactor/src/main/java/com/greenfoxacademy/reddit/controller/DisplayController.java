package com.greenfoxacademy.reddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/reddit")
public class DisplayController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getPostList() {
        return "post-list";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String getPostCreate() {
        return "create-post";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String getPostEdit() {
        return "edit-post";
    }
}
