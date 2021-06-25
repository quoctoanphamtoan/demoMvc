package com.quoctoanphamtoan.demomvc.model;


public class CardModel {
    private  int id;
    private String number;
    private String type;


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

    public CardModel(int id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }
    public CardModel() {
    }

    public CardModel(String number, String type) {
        this.number = number;
        this.type = type;
    }
}
