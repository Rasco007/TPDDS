package WebApp;

import Domain.Incidente.Incidente;

import Domain.ApplicationContextProvider;

import Domain.Incidente.Incidente;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListaIncidentes {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListaIncidentes.class);

    @GetMapping("/incidentes")
    public String incidentes(@RequestParam(value = "nombre", defaultValue = "") String nombre,
            @RequestParam(value = "estado", required = false) String estado,
            @RequestParam(value = "comunidadId", required = false) String comunidadId,
            @RequestParam(value = "localizacionId", required = false) String localizacionId,
            @RequestParam(value = "entidadId", required = false) String entidadId,
            @RequestParam(value = "establecimientoId", required = false) String establecimientoId,
            @RequestParam(value = "miembroAltaId", required = false) String miembroAltaId,
            @RequestParam(value = "miembroBajaId", required = false) String miembroBajaId,
            Model model,
                             IncidentesController incidentesController)
            throws Exception {



        List<Incidente> incidentes = incidentesController.buscarTodos();





        model.addAttribute("incidentes", incidentes);

        return "incidentes";

    }


}
