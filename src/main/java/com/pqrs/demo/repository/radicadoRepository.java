package com.pqrs.demo.repository;
import java.util.List;
import javax.persistence.OrderBy;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.pqrs.demo.entity.PQRS;

//solo se utiliza para filtros ya trae por defecto los del crud
@Repository
public interface radicadoRepository extends JpaRepository<PQRS, Integer> {
  
    @OrderBy("numeroRadicado ASC")
    List<PQRS> findAllByOrderByNumeroRadicadoDesc();

    @Query("SELECT p FROM PQRS p WHERE p.idTipoRadicado.idTipoRadicado = :idTipoRadicado")
    List<PQRS> findByTipoRadicado(int idTipoRadicado);

    @Query("SELECT p FROM PQRS p WHERE p.idEstadoPqrs.idEstadoPqrs = :idEstadoPqrs")
    List<PQRS> findByEstadoRadicado(int idEstadoPqrs);

    @Query("SELECT p FROM PQRS p WHERE p.idTipoRadicado.idTipoRadicado = :idTipoRadicado and p.idEstadoPqrs.idEstadoPqrs = :idEstadoPqrs")
    List<PQRS> findByTipoAndEstadoRadicado(int idTipoRadicado, int idEstadoPqrs); 
}