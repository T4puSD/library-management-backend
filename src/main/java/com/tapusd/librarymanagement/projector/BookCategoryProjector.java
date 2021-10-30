package com.tapusd.librarymanagement.projector;

import com.tapusd.librarymanagement.domain.BookCategory;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "bookCategoryProjector", types = {BookCategory.class})
public interface BookCategoryProjector {
    Long getId();
    String getName();
}
