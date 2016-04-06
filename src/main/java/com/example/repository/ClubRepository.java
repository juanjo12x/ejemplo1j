package com.example.repository;

/**
 * Created by Juan Tenorio on 5/4/2016.
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}