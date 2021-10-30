package com.tapusd.librarymanagement.repository;

import com.tapusd.librarymanagement.domain.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "book-copies", path = "book-copies")
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
}
