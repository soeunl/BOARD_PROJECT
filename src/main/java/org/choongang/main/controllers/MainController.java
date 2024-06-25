package org.choongang.main.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller // controller 객체로 관리되는 객체이다
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index() {

        return  "main/index";
    }
}
