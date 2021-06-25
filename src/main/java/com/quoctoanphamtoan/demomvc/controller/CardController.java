package com.quoctoanphamtoan.demomvc.controller;

import com.quoctoanphamtoan.demomvc.model.CardModel;
import com.quoctoanphamtoan.demomvc.service.CardService;
import com.quoctoanphamtoan.demomvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/card")
public class CardController {
    @Autowired
    private PersonService personService;
    @Autowired
    private CardService cardService;

    @GetMapping("/{personId}")
    public String showViewCard(@PathVariable("personId") int personId, ModelMap modelMap){
        modelMap.addAttribute("list",cardService.getAll(personId));
        modelMap.addAttribute("personId",personId);
        return "card";
    }
    @GetMapping("/showformadd/{personId}")
    public String showFromAddCard(@PathVariable("personId") int personId, ModelMap modelMap){
        modelMap.addAttribute("personId",personId);
        return "addCard";
    }
    //add
    @PostMapping("/add/{personId}")
    public String addCard(@PathVariable("personId") int personId, ModelMap modelMap, @ModelAttribute("card")CardModel card){

        cardService.addCard(personId,card);
        return "redirect:/view/card/"+personId;
    }
}
