package com.tapusd.librarymanagement.facility;

import com.tapusd.librarymanagement.domain.Author;
import com.tapusd.librarymanagement.domain.Book;
import com.tapusd.librarymanagement.model.BookDTO;
import com.tapusd.librarymanagement.repository.AuthorRepository;
import com.tapusd.librarymanagement.repository.BookCategoryRepository;
import com.tapusd.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookFacility {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookCategoryRepository categoryRepository;

    @Autowired
    public BookFacility(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository categoryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Book save(BookDTO bookDTO) {
        Set<Author> authors = bookDTO.getAuthorIds().stream()
                .map(authorRepository::getById)
                .collect(Collectors.toSet());
        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setCategory(categoryRepository.getById(bookDTO.getCategoryId()));
        book.setAuthors(authors);

        return bookRepository.save(book);
    }

    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Transactional
    public void deactivateBookById(Long id) {
        bookRepository.findById(id)
                .ifPresentOrElse(book -> book.setActive(false), () -> {throw new IllegalArgumentException("Book not found!");});
    }
}
