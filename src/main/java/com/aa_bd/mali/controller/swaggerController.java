package com.aa_bd.mali.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class swaggerController {

    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUi() {

        return "redirect:/swagger-ui.html";
    }
}
