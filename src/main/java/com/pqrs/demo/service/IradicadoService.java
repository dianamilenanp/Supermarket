package com.pqrs.demo.service;
import java.util.List;
import com.pqrs.demo.entity.PQRS;

public interface IradicadoService {

    List<PQRS> getAllPqrs();
    List<PQRS> getAllByOrderByNumeroRadicadoDesc();
    List<PQRS> getfilterByTipoRadicado(int idTipoRadicado);
    List<PQRS> getfilterByEstadoPQRS(int idEstadoPqrs);
    List<PQRS> getfilterByTipoRadicadoAndEstadoPQRS(int idTipoRadicado, int idEstadoPqrs);
}
    