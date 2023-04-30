package com.pqrs.demo.repository;
import org.springframework.data.jpa.repository.*;
import com.pqrs.demo.entity.TipoRadicado;

public interface tipoRadicadoRepository extends JpaRepository<TipoRadicado, Long> {
    
}
