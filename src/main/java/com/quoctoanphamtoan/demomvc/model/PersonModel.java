package com.quoctoanphamtoan.demomvc.model;

import com.quoctoanphamtoan.demomvc.entity.Card;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class PersonModel {
    private int id;
    private String name;
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonModel(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public PersonModel(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public PersonModel() {
    }
}
