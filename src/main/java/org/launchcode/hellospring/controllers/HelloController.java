package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {



//    @GetMapping("hello") //handles request at path /hello
//    //@GetMapping //this method handles get requests
//    @ResponseBody //tells spring boot that this method is going to return a plain text response
//    public String hello() {
//        return "Hello, Spring!";
//    }

//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }

    //handles requests of the form /hello?name=LaunchCode (dynamic handler, means accepts data)
    @RequestMapping(value="hello", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

//Handles request of the form /hello/LaunchCode (the piece of the data is part of the path and not the query
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
}
