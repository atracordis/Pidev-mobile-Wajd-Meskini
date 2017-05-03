/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entities;



/**
 *
 * @author Admin
 */
public class Complaint {
    private String Type;
    private String Content;
    private String dateTime;
    private String idUser;

    public Complaint() {

    }

    
    

    @Override
    public String toString() {
        return "Complaint{" + "Type=" + Type + ", Content=" + Content + ", Date=" + dateTime + ", Status=" + idUser + '}';
    }

    public Complaint(String Name, String Author, String Category, String ISBN) {
        this.Type = Name;
        this.Content = Author;
        this.dateTime = Category;
        this.idUser = ISBN;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
}
