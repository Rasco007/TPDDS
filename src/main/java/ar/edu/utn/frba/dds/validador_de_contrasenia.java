package ar.edu.utn.frba.dds;
import java.util.ArrayList;

public class validador_de_contrasenia {
  ArrayList validaciones = new ArrayList();

  private void cargar_validaciones(String nombre, String apelldio){
    if (validaciones.isEmpty()){
      validaciones.add(new no_es_igual_al_nombre(nombre));
      validaciones.add(new no_es_igual_al_nombre(apelldio));
      validaciones.add(new cumple_longitud_minima());
      validaciones.add(new no_es_insegura());
      validaciones.add(new no_es_repeticion_de_caracteres());
      validaciones.add(new validar_caracteres());
    }
  }

  public boolean validar(String nombre, String apellido, String password){
    cargar_validaciones(nombre, apellido);
    int contadora = 0;
    boolean password_valida = true;
    while(contadora < validaciones.size() && password_valida){
      validacion siguiente_validacion = (validacion) validaciones.get(contadora);
      password_valida = siguiente_validacion.validar(password);
    }
    return password_valida;
  }
}
