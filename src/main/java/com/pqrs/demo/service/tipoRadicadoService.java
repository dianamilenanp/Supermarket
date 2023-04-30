package com.pqrs.demo.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.pqrs.demo.entity.TipoRadicado;
import com.pqrs.demo.repository.tipoRadicadoRepository;

@Service
public class tipoRadicadoService  implements ItipoRadicadoService{
    private tipoRadicadoRepository tipoRadicadoRepository;

    public tipoRadicadoService(tipoRadicadoRepository tipoRadicadoRepository) {
        this.tipoRadicadoRepository = tipoRadicadoRepository;
    }

    @Override
    public List<TipoRadicado> getAllTipoRadicados() {
        return tipoRadicadoRepository.findAll();
    };
}