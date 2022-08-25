package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String l ){
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";

        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        return greeting + " " + name;

    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";

        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        return greeting + " " + n;
    }


    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello'>" + //submit a request to /hello
                "<input type = 'text' name='name'>" +
                "<select name= 'l'>" +
                "<option value='french'>French</option>" +
                "<option value= 'spanish'> Spanish</option>" +
                "<option value= 'english'>English</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
