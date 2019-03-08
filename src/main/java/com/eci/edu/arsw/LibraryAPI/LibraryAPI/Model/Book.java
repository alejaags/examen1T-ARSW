/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.edu.arsw.LibraryAPI.LibraryAPI.Model;

/**
 *
 * @author Alejandra Gomez
 */
public class Book {
    
    private int ID;
    private String name;
    private String writer;
    private String synopsis;

    public Book(int ID, String name, String writer, String synopsis) {
        this.ID = ID;
        this.name = name;
        this.writer = writer;
        this.synopsis = synopsis;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    
}
