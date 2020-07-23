package com.myC.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.myC.thymeleaf.entity.contact;
import com.myC.thymeleaf.service.myService;

@Controller
public class myController {

	@Autowired
    private myService contactService;

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
    public String save(contact contact) {
        
        contactService.save(contact);
        return "index";
    }
    
    @GetMapping("/contact/{name}/edit")
    public String edit(@PathVariable("name") contact name, Model model) {
        model.addAttribute("contact", contactService.findById(name));
        return "addContact";
    }
    
    @GetMapping("/contact/{name}/delete")
    public String delete(@PathVariable("name") contact name) {
        contactService.delete(name);
        return "contact";
    }
}
