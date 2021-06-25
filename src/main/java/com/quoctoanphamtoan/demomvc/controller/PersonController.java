package com.quoctoanphamtoan.demomvc.controller;

import com.quoctoanphamtoan.demomvc.entity.Person;
import com.quoctoanphamtoan.demomvc.model.PersonModel;
import com.quoctoanphamtoan.demomvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("")
    public String showViewPerson(ModelMap modelMap){
        modelMap.addAttribute("list",personService.getAllPerson());
        return "person";
    }
    @PostMapping("/add")
    public String addPerson(@ModelAttribute("person")PersonModel personModel){
         personService.addPerson(personModel);
        return "redirect:/view/person";
    }

}
