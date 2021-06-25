package com.quoctoanphamtoan.demomvc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String number;
    private String type;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Card(int id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }
    public Card() {
    }

    public Card(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public Card(String number, String type, Person person) {
        this.number = number;
        this.type = type;
        this.person = person;
    }
}
