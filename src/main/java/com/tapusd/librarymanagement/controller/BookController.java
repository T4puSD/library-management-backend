package com.tapusd.librarymanagement.controller;

import com.tapusd.librarymanagement.facility.BookFacility;
import com.tapusd.librarymanagement.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/custom")
public class BookController {

    private final BookFacility bookFacility;

    @Autowired
    public BookController(BookFacility bookFacility) {
        this.bookFacility = bookFacility;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@Valid @RequestBody BookDTO bookDTO) {
       bookFacility.save(bookDTO);
    }
}
