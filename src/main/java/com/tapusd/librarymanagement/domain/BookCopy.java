package com.tapusd.librarymanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "book_copy")
public class BookCopy implements Serializable {
    private Long id;
    private Book book;
    private Boolean borrowed;
    private BorrowLog borrowLog;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @NotNull
    @Column(name = "borrowed", nullable = false)
    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    @NotNull
    @OneToOne(mappedBy = "bookCopy")
    public BorrowLog getBorrowLog() {
        return borrowLog;
    }

    public void setBorrowLog(BorrowLog borrowLog) {
        this.borrowLog = borrowLog;
    }
}
