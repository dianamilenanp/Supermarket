package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "nombre_rol", nullable = false)
    private String nombreRol;
}
