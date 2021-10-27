package com.tapusd.librarymanagement.repository;

import com.tapusd.librarymanagement.domain.BorrowLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowLogRepository extends JpaRepository<BorrowLog, Long> {
}
