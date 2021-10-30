package com.tapusd.librarymanagement.repository;

import com.tapusd.librarymanagement.domain.BorrowLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "borrow-logs", path = "borrow-logs")
public interface BorrowLogRepository extends JpaRepository<BorrowLog, Long> {
}
