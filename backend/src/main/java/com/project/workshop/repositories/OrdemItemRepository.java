package com.project.workshop.repositories;

import com.project.workshop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemItemRepository extends JpaRepository<OrderItem, Long> {
}
