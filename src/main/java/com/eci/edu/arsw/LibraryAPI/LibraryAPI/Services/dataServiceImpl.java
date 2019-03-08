/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.edu.arsw.LibraryAPI.LibraryAPI.Services;

import com.eci.edu.arsw.LibraryAPI.LibraryAPI.Model.Book;
import com.eci.edu.arsw.LibraryAPI.LibraryAPI.Model.Librarie;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandra Gómez
 */
@Service
public class dataServiceImpl implements dataService{
    
   

    @Override
    public void addNewLibrarie(Librarie li) throws LibrariesServiceException {
        if (l.containsKey(li.getID())) {
            throw new LibrariesServiceException("La libreria ua fue creada "
                     + li.getID() + li.getName() + li.getAddress());
        } else {
            l.put(li.getID(), li);
        }
    }

    @Override
    public void addNewBook(Librarie l, Book b) throws LibrariesServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getLibraries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> getLibrariesWithBooks() {
        return l.keySet();
    }
    
    @Override
    public Librarie getLibrarie(int id) {
        if (!l.containsKey(id)) {
            return null;
        } else {
            return l.get(id);
        }
    }
    
    @Override
    public Set<Book> getBooksOfLibrarie(int id) {
        if (!l.containsKey(id)) {
            return null;
        } else {
            return (Set<Book>) l.get(id).getBooksMap();
        }
    }
    
    @Override
    public Book getSpecificBook(int idlib, int idbook) {
        if (!l.containsKey(idlib)) {
            return null;
        } else {
            if (!l.get(idlib).getBooksMap().containsKey(idbook)) {
                return null;
            } else {
                return l.get(idlib).getBooksMap().get(idbook);
            }
        }
    }
    
    @Override
    public void releaseLibrarie(int idlib) throws LibrariesServiceException {
        if (!l.containsKey(idlib)) {
            throw new LibrariesServiceException("Libreria inexistente o ya liberada:" + idlib);
        } else {
            if(!l.get(idlib).getBooksMap().isEmpty()){
                throw new LibrariesServiceException("Libreria contiene libros:" + idlib);
            }
            else{
                l.remove(idlib);
            }
        }
    }
    
    
    private static final Map<Integer, Book> booksMap;
    private static final Map<Integer, Librarie> l;
     
    static{
        l = new ConcurrentHashMap<>();
        booksMap = new ConcurrentHashMap<>();
        
        Book book1 = new Book(1, "un mundo feliz", "Aldous Huxley", "esta bueno");
        Book book2 = new Book(2, "la carretera", "Cormac McCartie", "es re bueno");
        Book book3 = new Book(3, "el club de la pelea", "Chuck Palaniuk", "no se como se escribe Palaniuk");
        booksMap.put(1, book1);
        booksMap.put(2, book2);
        booksMap.put(3, book3);
        
        Librarie lib = new Librarie(1, "eci", "calle", "1234456789-falso");
        lib.addBook(1, book1);
        lib.addBook(3, book3);
        lib.addBook(2, book2);
        
        l.put(1, lib);
        
        Librarie lib2 = new Librarie(2, "lib2", "eci", "12345678900987654321");
        lib2.addBook(3, book3);
        lib2.addBook(2, book2);
        
        l.put(1, lib2);
    }

    

    
    
}
