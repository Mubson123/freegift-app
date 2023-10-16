package com.cedricmube.freegiftapp.repositories;

import com.cedricmube.freegiftapp.entities.Mediafile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediafileRepository extends JpaRepository<Mediafile, Long> {
}