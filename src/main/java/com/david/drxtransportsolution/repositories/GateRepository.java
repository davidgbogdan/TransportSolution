package com.david.drxtransportsolution.repositories;

import com.david.drxtransportsolution.entities.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {
}
