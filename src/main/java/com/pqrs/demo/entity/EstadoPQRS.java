package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estado_pqrs")
public class EstadoPQRS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadoPqrs;

    @Column(name = "nombre_estado", nullable = false)
    private String nombreEstado;
}
