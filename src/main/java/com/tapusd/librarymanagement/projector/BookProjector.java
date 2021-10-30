package com.tapusd.librarymanagement.projector;

import com.tapusd.librarymanagement.domain.Author;
import com.tapusd.librarymanagement.domain.Book;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "bookProjector", types = {Book.class})
public interface BookProjector {
    Long getId();
    Long getIsbn();
    String getTitle();
    BookCategoryProjector getCategory();
    Set<Author> getAuthors();
}
