/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.edu.arsw.LibraryAPI.LibraryAPI.Model;

import java.util.Map;

/**
 *
 * @author Alejandra Gomez
 */
public class Librarie {
    
    private Map<Integer, Book> booksMap;
    
    private int ID;
    private String name;
    private String address;
    private String telephone;

    public Librarie(int ID, String name, String address, String telephone) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public Map<Integer, Book> getBooksMap() {
        return booksMap;
    }

    public void setBooksMap(Map<Integer, Book> booksMap) {
        this.booksMap = booksMap;
    }

    public void addBook(int p, Book b) {
        if (!booksMap.containsKey(p)) {
            booksMap.put(p, b);
        } else {
            booksMap.put(p+1,b);
        }
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
   
    
    
}
