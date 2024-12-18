package com.example.Mvc_App.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerMVC {

    @GetMapping
    public String getHome(){
        return "home.jsp";
    }

}
