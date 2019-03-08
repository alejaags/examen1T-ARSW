/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.edu.arsw.LibraryAPI.LibraryAPI.Services;

import com.eci.edu.arsw.LibraryAPI.LibraryAPI.Model.*;
import java.util.Set;

/**
 *
 * @author Alejandra Gomez
 */
public interface dataService {
    
    void addNewLibrarie(Librarie l) throws LibrariesServiceException;
    
    void addNewBook(Librarie l, Book b) throws LibrariesServiceException;
    
    Set<String> getLibraries();

    //RestaurantProduct getProductByName(String product) throws OrderServicesException;

    Set<Book> getBooksOfLibrarie(int id);

    Set<Integer> getLibrariesWithBooks();

    Librarie getLibrarie(int id);
    
    Book getSpecificBook(int idlib, int idbook);

    void releaseLibrarie(int idlib) throws LibrariesServiceException;
}
