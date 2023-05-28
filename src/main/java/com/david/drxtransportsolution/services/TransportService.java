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

    public long addNewTransport(TransportDTO transportDTO){
        Transport newTransport = new Transport().setDriverId(transportDTO.getDriverId())
                .setLocationId(transportDTO.getLocationId())
                .setStatus(transportDTO.getStatus())
                .setDispatchDate(transportDTO.getDispatchDate())
                .setDeliveryDate(transportDTO.getDeliveryDate());
        Transport savedTransport = transportRepository.save(newTransport);
        return savedTransport.getTransportId(); //Return the newly created transport
    }

    public void updateTransport(long transportId, TransportDTO transportDTO){
        Transport existingTransport = transportRepository.findById(transportId).orElseThrow(() -> new EntityNotFoundException("Transport not found"));
        existingTransport.setDriverId(transportDTO.getDriverId())
                .setLocationId(transportDTO.getLocationId())
                .setStatus(transportDTO.getStatus())
                .setDispatchDate(transportDTO.getDispatchDate())
                .setDeliveryDate(transportDTO.getDeliveryDate());
        transportRepository.save(existingTransport);
    }

    public void deleteTransport(long transportId){
        Transport existingTransport = transportRepository.findById(transportId).orElseThrow(() -> new EntityNotFoundException("Transport not found"));
        transportRepository.delete(existingTransport);
    }
}
