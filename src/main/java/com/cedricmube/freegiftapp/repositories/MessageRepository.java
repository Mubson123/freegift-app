package com.cedricmube.freegiftapp.repositories;

import com.cedricmube.freegiftapp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}