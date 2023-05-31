package com.david.drxtransportsolution.repositories;

import com.david.drxtransportsolution.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
    List<Transport> findByLocationId(long locationId);
    List<Transport> findByDriverId(long driverId);
}
