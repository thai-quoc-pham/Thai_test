package com.myC.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.myC.thymeleaf.entity.contact;
import com.myC.thymeleaf.service.myCService;


@Controller
public class myController {

	@Autowired
    private myCService contactService;

    @GetMapping("/contact")
    public String list(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "index";
    }
    
    @GetMapping("/contact/add")
    public String add(Model model) {
        model.addAttribute("contact", new contact());
        return "addContact";
    }
    
    @PostMapping("/contact/save")
    public String save(contact contact, Model model) {
    	contactService.save(contact);
    	model.addAttribute("contacts", contactService.findAll());      
        return "index";
    }
    
    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.findById(id) );
        return "addContact";
    }
    
    @RequestMapping("/contact/{id}/delete")
    public String delete(@PathVariable("id") Integer id, Model model) {
        contactService.delete(id);
        model.addAttribute("contacts", contactService.findAll());
        return "index";
    }
}
