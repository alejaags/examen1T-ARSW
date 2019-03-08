/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.edu.arsw.LibraryAPI.LibraryAPI.Controller;

import com.eci.edu.arsw.LibraryAPI.LibraryAPI.Model.Book;
import com.eci.edu.arsw.LibraryAPI.LibraryAPI.Model.Librarie;
import com.eci.edu.arsw.LibraryAPI.LibraryAPI.Services.LibrariesServiceException;
import com.eci.edu.arsw.LibraryAPI.LibraryAPI.Services.dataService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController()
@RequestMapping(value = "/libraries")
public class dataController {


    @Autowired
    dataService ds;

    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> getResourceHandler() {
        //obtener datos que se enviarán a través del API

        List<Librarie> libs = new ArrayList<>();
        for (Integer id : ds.getLibrariesWithBooks()) {
            libs.add(ds.getLibrarie(id));
        }

        return new ResponseEntity<List>(libs, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/{idlibrarie}")
    public ResponseEntity<Librarie> getLibrarie(@PathVariable Long idlibrarie) {
        Librarie lib = ds.getLibrarie(idlibrarie.intValue());

        HttpStatus status = HttpStatus.ACCEPTED;

        if (lib == null) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Librarie>(lib, status);
    }
    
    @GetMapping("/{idlibrarie}/books")
    public ResponseEntity<List> getSpecificBook(@PathVariable Long idlibrarie) {
        List<Book> bs = new ArrayList<>();
        for (Book b : ds.getBooksOfLibrarie(idlibrarie.intValue())) {
            int idbook = b.getID();
            bs.add(ds.getSpecificBook(idlibrarie.intValue(),idbook));
        }
        return new ResponseEntity<List>(bs, HttpStatus.ACCEPTED);
    }
    
    
    @GetMapping("/{idlibrarie}/books/{idbook}")
    public ResponseEntity<Book> getSpecificBook(@PathVariable Long idlibrarie,@PathVariable Long idbook ) {
        Book b = ds.getSpecificBook(idlibrarie.intValue(),idbook.intValue());

        HttpStatus status = HttpStatus.ACCEPTED;

        if (b == null) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Book>(b, status);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postCreateNewLibrarie(@RequestBody Librarie input) {
        try {
            ds.addNewLibrarie(input);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (LibrariesServiceException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>("Error: " + ex, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idlibrarie}")
    public ResponseEntity<?> deleteProductOrder(@PathVariable Long idlibrarie) {
        try {
            ds.releaseLibrarie(idlibrarie.intValue());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (LibrariesServiceException ex) {
            return new ResponseEntity<>("librarie " + idlibrarie + " doesn't have books", HttpStatus.BAD_REQUEST);
        }
    }
    
}