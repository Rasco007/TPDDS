package ar.edu.utn.frba.dds.Clasificador;

import ar.edu.utn.frba.dds.Comunidad.Comunidad;
import ar.edu.utn.frba.dds.Usuario.Usuario;

import java.util.List;

public class ClasificadorDeComunidad {

    public void clasificarComunidad(Comunidad comunidad){
        float calificacion=0;
        int usuariosNoConfiables=0;
        List<Usuario> usuarios=comunidad.getMiembros();
        for (int i=0; i<usuarios.size();i++){
            calificacion+=usuarios.get(i).getPerfil().getPuntosDeConfianza();
            if(usuarios.get(i).getPerfil().getPuntosDeConfianza()<=3){
                usuariosNoConfiables++;
            }
        }
        comunidad.setPuntosDeConfianza(calificacion/(usuarios.size()));
        comunidad.cambiarConfianza((float) (0.2*usuariosNoConfiables));
    }

    public ClasificadorDeComunidad() {
    }
}
