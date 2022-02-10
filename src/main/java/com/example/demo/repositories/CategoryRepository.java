package com.example.demo.repositories;

import com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Instant findByMoment(Instant moment);
    }
