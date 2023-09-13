package ar.edu.utn.frba.dds.Comunidad;

import ar.edu.utn.frba.dds.Incidente.Incidente;
import ar.edu.utn.frba.dds.Usuario.Usuario;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Comunidad {

    private String nombre;
    private List<Usuario> miembros;
    private List<Usuario> administradores;
    private List<Incidente> listadoDeIncidentes;
    private List<Usuario> miembrosObservadores;
    private List<Usuario> miembrosAfectados;



    //Para manejo de confianza
    private float puntosDeConfianza;
    public void cambiarConfianza(float cambio){
        puntosDeConfianza+=cambio;
    }
    public String getGradoDeConfianza(){
        if(this.puntosDeConfianza<2){
            return "No confiable.";
        } else if (this.puntosDeConfianza<=3) {
            return "Con reservas.";
        } else if (this.puntosDeConfianza<=5) {
            return "Confiable de nivel 1";
        }else{
            return "Confiable de nivel 2";
        }
    }


}
