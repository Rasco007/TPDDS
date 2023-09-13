package Domain.Personas;

import Domain.GeoRef.Entidades.Departamento;
import Domain.GeoRef.Entidades.Localidad;
import Domain.GeoRef.Entidades.Municipio;
import Domain.GeoRef.Entidades.Provincia;
import Domain.Notificaciones.Metodo_Notificacion;
import Domain.Notificaciones.TipoDeSincronizacion.Metodo_Sincronizacion;
import Domain.Personas.Comunidad;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter

public class Perfil {
  private String nombre;
  private String apellido;
  private String correo;
  private Set<Comunidad> comunidades;
  private Localidad localidad_interes;
  private Departamento departamento_interes;
  private Provincia provincia_interes;
  private Municipio municipio_interes;
  private Metodo_Notificacion metodo_notificacion;
  private Metodo_Sincronizacion metodo_sincronizacion
}
