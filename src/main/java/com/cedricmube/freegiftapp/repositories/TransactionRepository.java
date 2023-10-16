package com.cedricmube.freegiftapp.repositories;

import com.cedricmube.freegiftapp.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}