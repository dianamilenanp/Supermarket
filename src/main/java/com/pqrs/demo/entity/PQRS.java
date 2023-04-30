package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "pqrs")
public class PQRS {
    public PQRS(String string) {
    }

    public PQRS() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPqrs;

    @Column(name = "numero_radicado", nullable = false)
    private String numeroRadicado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_radicado")
    private Date fechaRadicado;

    @Column(name = "comentarios", nullable = false)
    private String comentariosRadicado;

    @Column(name = "anexo_pqrs", nullable = false)
    private String anexosRadicado;

    @Column(name = "justificacion_estado_pqrs", nullable = false)
    private String justificacionRadicado;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_radicado", nullable = false)
    private TipoRadicado idTipoRadicado;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado_pqrs", nullable = false)
    private EstadoPQRS idEstadoPqrs;
/* 
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario; */
    
}
