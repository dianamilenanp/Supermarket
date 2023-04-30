package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tipo_radicado")
public class TipoRadicado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoRadicado;

    @Column(name = "nombre_tipo_radicado", nullable = false)
    private String nombreRadicado;    
}
