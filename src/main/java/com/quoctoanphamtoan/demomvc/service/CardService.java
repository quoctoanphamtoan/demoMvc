package com.quoctoanphamtoan.demomvc.service;

import com.quoctoanphamtoan.demomvc.model.CardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private RestTemplate restTemplate;

    public List<CardModel> getAll(int id){
        ResponseEntity<List<CardModel>> responseEntity = restTemplate.exchange("http://localhost:8080/api/card/by-person/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<List<CardModel>>() {
        });
        return responseEntity.getBody();
    }
    public void addCard(int id,CardModel cardModel){
       restTemplate.postForEntity("http://localhost:8080/api/card/by-person/"+id,cardModel,null);
    }



}
