package com.cedricmube.freegiftapp.repositories;

import com.cedricmube.freegiftapp.entities.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {
}