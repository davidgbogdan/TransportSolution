package com.david.drxtransportsolution.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private long driverId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
