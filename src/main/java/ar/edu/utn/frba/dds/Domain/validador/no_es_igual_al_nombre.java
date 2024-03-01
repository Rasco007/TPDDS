package ar.edu.utn.frba.dds.Domain.validador;

import ar.edu.utn.frba.dds.Domain.Personas.Usuario;

public class no_es_igual_al_nombre extends validacion {

  public boolean validar(Usuario usuario){
    return (!usuario.getPassword().toUpperCase().contains(usuario.getPerfil().getNombre().toUpperCase())
    || !usuario.getPassword().toUpperCase().contains(usuario.getPerfil().getApellido().toUpperCase()));
  }
}