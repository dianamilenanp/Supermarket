package com.pqrs.demo.repository;
import org.springframework.data.jpa.repository.*;
import com.pqrs.demo.entity.EstadoPQRS;

public interface estadoPqrsRepository extends JpaRepository<EstadoPQRS, Long> {
    
}
