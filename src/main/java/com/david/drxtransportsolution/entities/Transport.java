package com.david.drxtransportsolution.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Table(name = "transport")
@Getter
@Setter
@Accessors(chain = true)
public class Transport {
    public enum Status {
        NEEXPEDIAT, EXPEDIAT, LIVRAT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_id")
    private long transportId;

    @Column(name = "driver_id")
    private long driverId;

    @Column(name = "location_id")
    private long locationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('NEEXPEDIAT', 'EXPEDIAT', 'LIVRAT')")
    private Status status;

    @Column(name = "dispatch_date")
    private LocalDate dispatchDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

}
