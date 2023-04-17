package com.david.drxtransportsolution.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDTO {
    private long programId;
    private long gateId;
    private long transportId;
    private LocalTime deliveryHour;
}
