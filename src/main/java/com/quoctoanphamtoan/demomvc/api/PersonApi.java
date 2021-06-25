package com.quoctoanphamtoan.demomvc.api;

import com.quoctoanphamtoan.demomvc.entity.Card;
import com.quoctoanphamtoan.demomvc.entity.Person;
import com.quoctoanphamtoan.demomvc.model.PersonModel;
import com.quoctoanphamtoan.demomvc.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonApi {
    @Autowired
    private IPersonRepository personRepository;
    @GetMapping("")
    public Object getAllPerson(){
        try {
            List<Person> list = personRepository.findAll();
            List<PersonModel> result = new ArrayList<>();
            list.forEach(x->result.add(new PersonModel(x.getId(),x.getName(),x.getAddress())));
            return new ResponseEntity<List<PersonModel>>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Server error", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("")
    public Object addPerson(@RequestBody Person person){
        try {
            personRepository.save(person);
            return new ResponseEntity<String>("Them thanh cong", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Server error", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public Object deletePerson(@PathVariable("id") int id){
        try {
            personRepository.deleteById(id);
            return new ResponseEntity<String>("xoa thanh cong", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Server error", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public Object updatePerson(@PathVariable("id") int id,@RequestBody Person person){
        try {
            Person personEdit = personRepository.getById(id);
            personEdit.setAddress(person.getAddress());
            personEdit.setName(person.getName());
            personRepository.save(personEdit);
            return new ResponseEntity<String>("update thanh cong", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Server error", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public Object getPersonBy(@PathVariable("id") int id){
        try {
            Person person = personRepository.findById(id).orElse(null);
            return new ResponseEntity<PersonModel>(new PersonModel(person.getId(),person.getName(),person.getAddress()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Server error", HttpStatus.BAD_REQUEST);
        }
    }
}
