package com.quoctoanphamtoan.demomvc.service;

import com.quoctoanphamtoan.demomvc.entity.Person;
import com.quoctoanphamtoan.demomvc.model.CardModel;
import com.quoctoanphamtoan.demomvc.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private RestTemplate restTemplate;
    public List<PersonModel> getAllPerson(){
        ResponseEntity<List<PersonModel>> responseEntity = restTemplate.exchange("http://localhost:8080/api/person", HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonModel>>() {
        });
        return responseEntity.getBody();
    }
    public void addPerson(PersonModel peroPersonModel){
        restTemplate.postForEntity("http://localhost:8080/api/person",peroPersonModel,null);
    }
}
