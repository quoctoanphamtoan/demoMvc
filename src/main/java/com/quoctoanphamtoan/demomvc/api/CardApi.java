package com.quoctoanphamtoan.demomvc.api;


import com.quoctoanphamtoan.demomvc.entity.Card;
import com.quoctoanphamtoan.demomvc.model.CardModel;
import com.quoctoanphamtoan.demomvc.model.PersonModel;
import com.quoctoanphamtoan.demomvc.repository.ICardRepository;
import com.quoctoanphamtoan.demomvc.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardApi {
    @Autowired
    private ICardRepository cardRepository;
    @Autowired
    private IPersonRepository personRepository;
    @PostMapping("/by-person/{personId}")
    public Object saveCardByPersonId(@PathVariable("personId") int personId, @RequestBody Card card){
        try {
            card.setPerson(personRepository.getById(personId));
           cardRepository.save(card);
            return new ResponseEntity<String>("Thanh cong", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<String>("server error", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/by-person/{personId}")
    public Object getCardByPersonId(@PathVariable("personId") int personId){
        try {

            List<CardModel> result = new ArrayList<>();
            cardRepository.findAll().forEach(x->{
                if(x.getPerson().getId()==personId)
                    result.add(new CardModel(x.getId(),x.getNumber(),x.getType()));
            });
            return new ResponseEntity<List<CardModel>>(result, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<String>("server error", HttpStatus.BAD_REQUEST);
        }
    }
}
