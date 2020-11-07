package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("")
public class TestController {



    @RequestMapping("main")
    public String main() {

        return "main";
    }
    @RequestMapping("login")
    public String login() {

        return "login";
    }
    @RequestMapping("rent")
    public String rent() {

        return "rent";
    }
    @RequestMapping("community")
    public String community() {

        return "community";
    }
    @RequestMapping("signup")
    public String signup() {

        return "signup";
    }
    @RequestMapping("createArticle")
    public String createArticle() {

        return "createArticle";
    }


}