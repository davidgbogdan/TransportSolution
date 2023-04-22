package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.dtos.TransportDTO;
import com.david.drxtransportsolution.entities.Transport;
import com.david.drxtransportsolution.repositories.TransportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportService {

    private final TransportRepository transportRepository;

    public List<Transport> getAllTransports(){
        return transportRepository.findAll();
    }

    public Transport getTransportById(long transportId){
        return transportRepository.findById(transportId).orElseThrow(() -> new EntityNotFoundException("Transport not found"));
    }

    public void addNewTransport(TransportDTO transportDTO){
        Transport newTransport = new Transport().driverId(transportDTO.getDriverId())
                .locationId(transportDTO.getDriverId())
                .status(transportDTO.getStatus())
                .dispatchDate(transportDTO.getDispatchDate())
                .deliveryDate(transportDTO.getDispatchDate());
        transportRepository.save(newTransport);
    }

    public void updateTransport(long transportId, TransportDTO transportDTO){
        Transport existingTransport = transportRepository.findById(transportId).orElseThrow(() -> new EntityNotFoundException("Transport not found"));
        existingTransport.driverId(transportDTO.getDriverId())
                .locationId(transportDTO.getLocationId())
                .status(transportDTO.getStatus())
                .dispatchDate(transportDTO.getDispatchDate())
                .deliveryDate(transportDTO.getDeliveryHour());
        transportRepository.save(existingTransport);
    }

    public void deleteTransport(long transportId){
        Transport existingTransport = transportRepository.findById(transportId).orElseThrow(() -> new EntityNotFoundException("Transport not found"));
        transportRepository.save(existingTransport);
    }
}
