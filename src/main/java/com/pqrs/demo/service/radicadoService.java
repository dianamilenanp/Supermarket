package com.pqrs.demo.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.pqrs.demo.entity.PQRS;
import com.pqrs.demo.repository.radicadoRepository;

@Service
public class radicadoService  implements IradicadoService{
    private radicadoRepository radicadoRepository;

    public radicadoService(radicadoRepository radicadoRepository) {
        this.radicadoRepository = radicadoRepository;
    }

    @Override
    public List<PQRS> getAllPqrs(){
        return radicadoRepository.findAll();
    };

    @Override
    public List<PQRS> getAllByOrderByNumeroRadicadoDesc(){
        return radicadoRepository.findAllByOrderByNumeroRadicadoDesc();
    };

    @Override
    public List<PQRS> getfilterByEstadoPQRS(int idEstadoRadicado){
        List<PQRS> radicadosFiltrados;
        radicadosFiltrados= radicadoRepository.findByEstadoRadicado(idEstadoRadicado);   
        return radicadosFiltrados;
    }

    @Override
    public List<PQRS> getfilterByTipoRadicado(int idTipoRadicado) {
        List<PQRS> radicadosFiltrados;
        radicadosFiltrados= radicadoRepository.findByTipoRadicado(idTipoRadicado);
        return radicadosFiltrados;
    }

     @Override
    public List<PQRS> getfilterByTipoRadicadoAndEstadoPQRS(int idTipoRadicado, int idEstadoRadicado){
        List<PQRS> radicadosFiltrados;
        System.out.println("Filtrando por ambos criterios en el servicio");
        radicadosFiltrados= radicadoRepository.findByTipoAndEstadoRadicado(idTipoRadicado,idEstadoRadicado);   
        return radicadosFiltrados;
    } 
}