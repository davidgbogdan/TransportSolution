package com.david.drxtransportsolution.services;

import com.david.drxtransportsolution.entities.Transport;
import com.david.drxtransportsolution.repositories.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransportService {

    private final TransportRepository transportRepository;

    public List<Transport> getAllTransports(){
        return transportRepository.findAll();
    }

    public Optional<Transport> getTransportById(long id){
        Optional<Transport> optionalTransport = transportRepository.findById(id);
        if(optionalTransport.isPresent()){
            return transportRepository.findById(id);
        }else{
            throw new IllegalArgumentException("Location with id " + id + " not found");
        }
    }

    public void addNewTransport(int idDriver, int idLocation, String status, java.util.Date dispatchDate, java.util.Date deliveryDate){
        Transport transport = new Transport();
        transport.setIdDriver(idDriver);
        transport.setIdLocation(idLocation);
        transport.setStatus(status);
        transport.setDispatchDate(dispatchDate);
        transport.setDeliveryDate(deliveryDate);

        transportRepository.save(transport);
    }

    public void updateTransport(long id, int idDriver, int idLocation, String status, java.util.Date dispatchDate, java.util.Date deliveryDate){
        Optional<Transport> optionalTransport = transportRepository.findById(id);
        if(optionalTransport.isPresent()){
            Transport transport = optionalTransport.get();
            transport.setIdDriver(idDriver);
            transport.setIdLocation(idLocation);
            transport.setStatus(status);
            transport.setDispatchDate(dispatchDate);
            transport.setDeliveryDate(deliveryDate);

            transportRepository.save(transport);
        }else {
            throw new IllegalArgumentException("Transport with id " + id + " not found");
        }
    }

    public void deleteTransport(long id){
        Optional<Transport> optionalTransport = transportRepository.findById(id);
        if(optionalTransport.isPresent()){
            transportRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Transport with id " + id + " not found");
        }
    }
}
