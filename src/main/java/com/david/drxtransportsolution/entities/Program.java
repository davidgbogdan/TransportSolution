package com.david.drxtransportsolution.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Entity
@Table(name = "program")
@Getter
@Setter
@Accessors(chain = true)
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private long programId;

    @Column(name = "gate_id")
    private long gateId;

    @Column(name = "transport_id")
    private long transportId;

    @Column(name = "delivery_hour")
    private LocalTime deliveryHour;
}
