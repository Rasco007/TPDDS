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

        /*IncidenteFiltrosDTO filtros = new IncidenteFiltrosDTO(nombre,
                estado != null ? (estado.equals("abierto")) : null, comunidadId, localizacionId, entidadId,
                establecimientoId,
                miembroAltaId, miembroBajaId);
*/
        List<Incidente> incidentes = incidentesController.buscarTodos();
                /*.stream()
                .map(incidente -> new Incidente(incidente.getId(), incidente.getObservaciones(),
                        incidente.getFecha_hora_de_inicio(),
                        incidente.getFecha_Hora_de_cierre(), incidente.getResuelto()))
                .collect(Collectors.toList());*/


        /*List<ComboDTO> entidades = ComboController.getComboEntidades();
        List<ComboDTO> comunidades = ComboController.getComboComunidades();
        List<ComboDTO> localizaciones = ComboController.getComboLocalizaciones();
        List<ComboDTO> establecimientos = ComboController.getComboEstablecimientos();
        List<ComboDTO> miembros = ComboController.getComboMiembros();
        List<ComboDTO> servicios = ComboController.getComboServicios();*/

        model.addAttribute("incidentes", incidentes);
        /*model.addAttribute("entidades", entidades);
        model.addAttribute("comunidades", comunidades);
        model.addAttribute("localizaciones", localizaciones);
        model.addAttribute("establecimientos", establecimientos);
        model.addAttribute("miembros", miembros);
        model.addAttribute("servicios", servicios);*/
        return "incidentes";

    }

    /*@PostMapping("/incidentes/reportar")
    public String reportar(@RequestBody IncidenteForm incidenteForm) {

        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        // Obtén la sesión
        HttpSession session = request.getSession();

        // Establece un atributo en la sesión
        //session.setAttribute("nombreAtributo", valorAtributo);

        // Obtén el atributo de la sesión
        Long id = (Long) session.getAttribute("id_miembro");

        Servicio servicio = repoServicios.buscarPorId(Long.parseLong(incidenteForm.getServicioId()));

        Entidad entidad = repositorioDeEntidades.buscarPorId(Long.valueOf(incidenteForm.getEntidadId()));

        Establecimiento establecimiento = repositorioDeEstablecimientos
                .buscarPorId(Long.valueOf(incidenteForm.getEstablecimientoId()));

        //Long id = context. .sessionAttribute("id_miembro");
        Miembro miembro = RepositorioDeMiembros.getInstance().buscarPorId(id);

        List<Comunidad> comunidadesDelMiembro = repositorioDeMiembros
                .obtenerComunidadesPorMiembroId(Long.valueOf(id));

        comunidadesDelMiembro.forEach(comu -> {
            Incidente incidente = new Incidente(servicio, incidenteForm.getObservaciones(), miembro);
            IncidenteComunidad incidenteComunidad = new IncidenteComunidad(incidente,
                    comu);
            incidenteComunidad.setActivo(true);
            incidenteComunidad.setEntidad(entidad);
            incidenteComunidad.setEstablecimiento(establecimiento);
            incidenteComunidad.setServicio(servicio);
            repositorioDeIncidentes.agregar(incidenteComunidad);
            ;
        });
        return "incidentes";
    }

    @PostMapping("/incidentes/{id}/cerrar")
    @ResponseBody
    public String cerrar(@PathVariable String id) {
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        // Obtén la sesión
        HttpSession session = request.getSession();

        // Establece un atributo en la sesión
        //session.setAttribute("nombreAtributo", valorAtributo);

        // Obtén el atributo de la sesión
        Long idMiembro = (Long) session.getAttribute("id_miembro");

        //Long idMiembro = context.sessionAttribute("id_miembro");
        Miembro miembro = RepositorioDeMiembros.getInstance().buscarPorId(idMiembro);
        IncidenteComunidad aEliminar = repositorioDeIncidentes.buscarPorId(Long.valueOf(id));
        aEliminar.cerrarIncidente(miembro);
        repositorioDeIncidentes.modificar(aEliminar);
        return null;
    }*/
}
