package Domain.Comunidad;

import Domain.Incidente.Incidente;
import Domain.Usuario.Usuario;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
