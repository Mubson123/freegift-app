package com.cedricmube.freegiftapp.repositories;

import com.cedricmube.freegiftapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}