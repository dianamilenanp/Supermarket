package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "identificacion_usuario", nullable = false)
    private String identificacionUsuario;

    @Column(name = "correo_usuario", nullable = false)
    private String correoUsuario;

    @Column(name = "telefono_usuario", nullable = false)
    private String telefonoUsuario;

    @Column(name = "estado_usuario", nullable = false)
    private String estadoUsuario;

    @Column(name = "contrasena_usuario", nullable = false)
    private String contrasenaUsuario;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_identificacion", nullable = false)
    private TipoIdentificacion idTipoIdentificacion;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol idRol;
    /* 
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<PQRS> pqrs; */
}
