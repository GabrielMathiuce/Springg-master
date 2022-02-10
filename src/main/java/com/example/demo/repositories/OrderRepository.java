package com.example.demo.repositories;

import com.example.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Instant findByMoment(Instant moment);
    }
