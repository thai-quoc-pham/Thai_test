package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

	
	@RequestMapping("/view1")
    public String view1 (Model model) {
        return "view1";
    }
	
	  @RequestMapping("/view2")
	    public String view2() {
	        return "view2";
	    }
	  @RequestMapping(value = "/abc")
	  public String getAbc() {
		  return "abc";
	  }
}
