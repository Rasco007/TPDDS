package Domain.Clasificador;

import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;

import java.util.List;

public class Clasificador_Comunidad {

    public void clasificar_comunidad(Comunidad comunidad){
        float calificacion=0;
        int usuariosNoConfiables=0;
        List<Usuario> usuarios= (List<Usuario>) comunidad.getMiembros();
        for (int i=0; i<usuarios.size();i++){
            calificacion+=usuarios.get(i).getPerfil().getPuntosDeConfianza();
            if(usuarios.get(i).getPerfil().getPuntosDeConfianza()<=3){
                usuariosNoConfiables++;
            }
        }
        comunidad.setPuntos_confianza(calificacion/(usuarios.size()));
        comunidad.cambiar_confianza((float) (0.2*usuariosNoConfiables));
    }

    public Clasificador_Comunidad() {
    }
}
