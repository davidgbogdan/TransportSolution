package com.david.drxtransportsolution.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "driver")
@Setter
@Accessors(fluent = true)
@Getter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private long driverId;

    @Column(name = "first_name", columnDefinition = "varchar(100)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(100)")
    private String lastName;

    @Column(name = "phone_number", columnDefinition = "varchar(45)")
    private String phoneNumber;

    @Column(name = "email", columnDefinition = "varchar(100)")
    private String email;

}
