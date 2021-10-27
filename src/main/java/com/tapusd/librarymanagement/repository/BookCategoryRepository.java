package com.tapusd.librarymanagement.repository;

import com.tapusd.librarymanagement.domain.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "book-categories", path = "book-categories")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
