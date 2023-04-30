package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoIdentificacion;

    @Column(name = "nombre_tipo_identificacion", nullable = false)
    private String nombreTipoIdentificacion;
}
