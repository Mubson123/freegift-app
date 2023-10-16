package com.cedricmube.freegiftapp.repositories;

import com.cedricmube.freegiftapp.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}