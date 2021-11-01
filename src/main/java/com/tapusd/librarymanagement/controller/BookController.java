package com.tapusd.librarymanagement.controller;

import com.tapusd.librarymanagement.facility.BookFacility;
import com.tapusd.librarymanagement.model.ActionResponse;
import com.tapusd.librarymanagement.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.tapusd.librarymanagement.config.SiteConstant.ERROR_MESSAGE_HEADER_KEY;

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
    public ResponseEntity<ActionResponse> createBook(@Valid @RequestBody BookDTO bookDTO) {
        try {
            bookFacility.save(bookDTO);
            return ResponseEntity.noContent()
                    .build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .header(ERROR_MESSAGE_HEADER_KEY, ex.getMessage())
                    .build();
        }
    }

    @PutMapping("/books/deactivate/{id}")
    public ResponseEntity<ActionResponse> deactivateBook(@PathVariable Long id) {
        try {
            bookFacility.deactivateBookById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .header(ERROR_MESSAGE_HEADER_KEY, ex.getMessage())
                    .build();
        }
    }
}
