package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/hello")
public class HelloController {

    private final String[] names = {"Omar", "Mateo", "Liam", "Emma", "Reem", "Sofia", "James", "Agustin", "Antonella", "Youssef", "Abigail", "Zahra"};

    @GetMapping("/random")
    @ResponseBody
    public String randomGreeting() {
        int rnd = new Random().nextInt(names.length);
        return "Hello " + names[rnd] + "!";
    }

    @GetMapping()
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/{name1}/{name2}")
    @ResponseBody
    public String greet2(@PathVariable String name1, @PathVariable String name2) {
        return "Hello " + name1 + " and " + name2 + "!";
    }

    @GetMapping("/{name1}/to/{name2}")
    @ResponseBody
    public String onePersonGreetsAnother(@PathVariable String name1, @PathVariable String name2) {
        return name1 + " says hello to " + name2 + "!";
    }


    @GetMapping("/test")
    public  String viewTest() {
        return "views-lecture/test";
    }


}



//@Controller
//public class HelloController {
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello World";
//    }
//
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }
//


//}
