package com.tapusd.librarymanagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
