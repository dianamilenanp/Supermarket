package com.pqrs.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pqrs.demo.entity.*;
import com.pqrs.demo.service.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RadicadoController {
    @Autowired
    private radicadoService radicadoService;
    private tipoRadicadoService tipoRadicadoService;
    private estadoPqrsService estadoPqrsService;

    public RadicadoController(radicadoService radicadoService, tipoRadicadoService tipoRadicadoService,
            estadoPqrsService estadoPqrsService) {
        this.radicadoService = radicadoService;
        this.tipoRadicadoService = tipoRadicadoService;
        this.estadoPqrsService = estadoPqrsService;
    }

    @GetMapping("/")
    public String mostrarRadicados(Model modelo) {
        List<PQRS> radicados = radicadoService.getAllByOrderByNumeroRadicadoDesc();
        List<TipoRadicado> tiposRadicado = tipoRadicadoService.getAllTipoRadicados();
        List<EstadoPQRS> estadoPqrs = estadoPqrsService.getAllEstadoPQRSs();
        modelo.addAttribute("radicados", radicados);
        modelo.addAttribute("tiposRadicado", tiposRadicado);
        modelo.addAttribute("estadoRadicado", estadoPqrs);
        return "consultar-radicados";
    }

    @PostMapping("/")
    public String manejarFiltro(@RequestParam(name = "filtroTipoRadicado", required = false) Integer tipoRadicadoId,
            @RequestParam(name = "filtroEstadoRadicado", required = false) Integer estadoRadicadoId,
            Model modelo, HttpServletRequest request) {
        List<PQRS> radicados = null;

        // Verificar si se aplicó un filtro
        if ((request.getParameter("filtrar") != null) && (tipoRadicadoId != null || estadoRadicadoId != null)) {
            if (tipoRadicadoId != null && estadoRadicadoId != null) {
                // Filtrar por tipo de radicado y estado de PQRS
                radicados = radicadoService.getfilterByTipoRadicadoAndEstadoPQRS(tipoRadicadoId, estadoRadicadoId);
            } else if (tipoRadicadoId != null) {
                // Filtrar por tipo de radicado
                radicados = radicadoService.getfilterByTipoRadicado(tipoRadicadoId);
            } else {
                // Filtrar por estado de PQRS
                radicados = radicadoService.getfilterByEstadoPQRS(estadoRadicadoId);
            }
        } else {
            // Obtener todos los radicados
            radicados = radicadoService.getAllByOrderByNumeroRadicadoDesc();
        }
        if (radicados.isEmpty()) {
            radicados.add(new PQRS("No se encontraron resultados"));
        } else {
            modelo.addAttribute("radicados", radicados);
        }

        List<TipoRadicado> tiposRadicado = tipoRadicadoService.getAllTipoRadicados();
        List<EstadoPQRS> estadosPQRS = estadoPqrsService.getAllEstadoPQRSs();
        modelo.addAttribute("tiposRadicado", tiposRadicado);
        modelo.addAttribute("estadoRadicado", estadosPQRS);
        return "consultar-radicados";

    }
}
