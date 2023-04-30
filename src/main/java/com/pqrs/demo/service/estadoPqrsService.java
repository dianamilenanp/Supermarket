package com.pqrs.demo.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.pqrs.demo.entity.EstadoPQRS;
import com.pqrs.demo.repository.estadoPqrsRepository;

@Service
public class estadoPqrsService  implements IestadoPqrsService{
    private estadoPqrsRepository estadoPqrsRepository;

    public estadoPqrsService(estadoPqrsRepository estadoPqrsRepository) {
        this.estadoPqrsRepository = estadoPqrsRepository;
    }

    @Override
    public List<EstadoPQRS> getAllEstadoPQRSs() {
        return estadoPqrsRepository.findAll();
    };
}