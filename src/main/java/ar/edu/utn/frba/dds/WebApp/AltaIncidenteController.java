package ar.edu.utn.frba.dds.WebApp;

import java.util.*;

import ar.edu.utn.frba.dds.DBControllers.IncidenteController;
import ar.edu.utn.frba.dds.Domain.Entidades.Establecimiento;

import ar.edu.utn.frba.dds.Domain.Incidente.Incidente;
import ar.edu.utn.frba.dds.Domain.Personas.Comunidad;
import ar.edu.utn.frba.dds.Domain.Servicio.Servicio;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;


import javax.persistence.EntityTransaction;

public class AltaIncidenteController implements Handler, WithSimplePersistenceUnit {


    public AltaIncidenteController() {
        super();
    }

    @Override
    public void handle(Context ctx) throws Exception {

        List<Map<String, Object>> result = new IncidenteController().listarComunidades(ctx);
        //List<Map<String, Object>> resultSer = new IncidenteController().listarServicios(ctx);

        Map<String, Object> context = new HashMap<>();
        context.put("opcionesComunidades", result);
        //context.put("opcionesServicios", resultSer);
        ctx.render("aperturaIncidentes.hbs", context);
    }


    public void opcionesSucursales (Context ctx) throws  Exception{

        int comid = (int) Long.parseLong(Objects.requireNonNull(ctx.pathParam("opcion")));

        Comunidad comunidad= entityManager().find(Comunidad.class,comid);

        List<Establecimiento> sucursales = comunidad.getEntidad().getSucursales();

        List<String> nombresSucursales = new ArrayList<>();
        Map<String, Integer> opciones = new HashMap<>();

        if (sucursales != null) {
            for (Establecimiento sucursal : sucursales) {
                nombresSucursales.add(sucursal.getNombre());
                opciones.put(sucursal.getNombre(), sucursal.getId());
            }
        } else {
            ctx.render("aperturaIncidentes.hbs", Map.of("errorMensaje", "La lista de sucursales es nula"));
        }


        ctx.json(opciones);

    }

    public void opcionesServicios (Context ctx) throws  Exception{

        int suc_id = (int) Long.parseLong(Objects.requireNonNull(ctx.pathParam("opcion")));

        Establecimiento establecimiento= entityManager().find(Establecimiento.class,suc_id);

        List<Servicio> servicios = establecimiento.getServicios();

        List<String> nombresServicios= new ArrayList<>();
        Map<String, Integer> opciones = new HashMap<>();

        if (servicios != null) {
            for (Servicio servicio : servicios) {
                nombresServicios.add(servicio.getDescripcion());
                opciones.put(servicio.getDescripcion(), servicio.getId());
            }
        } else {
            ctx.render("aperturaIncidentes.hbs", Map.of("errorMensaje", "La lista de servicios es nula"));
        }


        ctx.json(opciones);

    }


    public void altaIncidente (Context ctx) throws  Exception{

        int servicio_id = (int) Long.parseLong(Objects.requireNonNull(ctx.formParam("dropdown_servicio")));
        int suc_id = (int) Long.parseLong(Objects.requireNonNull(ctx.formParam("dropdown_sucursal")));
        int com_id = (int) Long.parseLong(Objects.requireNonNull(ctx.formParam("dropdown")));
        String descrip = ctx.formParam("descripcion");

        Servicio servicio= entityManager().find(Servicio.class,servicio_id);
        Establecimiento establecimiento= entityManager().find(Establecimiento.class,suc_id);
        Comunidad comunidad= entityManager().find(Comunidad.class,com_id);

        Incidente incidente=new Incidente();


        incidente.setObservaciones(descrip);
        incidente.setServicio_afectado(servicio);
        incidente.setComunidad_afectada(comunidad);
        incidente.setEstablecimiento(establecimiento);


        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(incidente);

        tx.commit();

        HttpStatus codigoRespuesta = ctx.status();

        if(codigoRespuesta == HttpStatus.OK){
            ctx.render("aperturaIncidentes.hbs", Map.of("exitoMensaje", "El incidente se ha creado exitosamente."));

        }else{
            ctx.render("aperturaIncidentes.hbs", Map.of("errorMensaje", "El incidente NO se ha podido crear."));

        }
    }

}
