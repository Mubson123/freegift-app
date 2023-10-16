package com.cedricmube.freegiftapp.repositories;

import com.cedricmube.freegiftapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}