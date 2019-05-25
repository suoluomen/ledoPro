package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/we")
public class ControllerTest {
    @RequestMapping(value="/we",method= RequestMethod.GET )
    public  String getString(){
        return "hello";
    }

}
