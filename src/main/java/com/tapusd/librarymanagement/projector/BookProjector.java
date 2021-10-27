package com.tapusd.librarymanagement.projector;

import com.tapusd.librarymanagement.domain.Book;
import com.tapusd.librarymanagement.domain.BookCategory;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "bookProjector", types = {Book.class})
public interface BookProjector {
    Long getId();
    Long getIsbn();
    String getTitle();
    BookCategory getCategory();
}
