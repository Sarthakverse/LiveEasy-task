package com.sarthak.liveeasytask.repository;

import com.sarthak.liveeasytask.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {
    List<Load> findAllByShipperId(UUID shipperId);
}
