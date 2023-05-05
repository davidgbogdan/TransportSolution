package com.david.drxtransportsolution.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "gate")
@Getter
@Setter
@Accessors(chain = true)
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gate_id")
    private long gateId;

    @Column(name = "location_id")
    private long locationId;
}
