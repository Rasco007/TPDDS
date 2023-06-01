package ar.edu.utn.frba.dds;
import java.util.ArrayList;

public class validador_de_contrasenia {
  static ArrayList validaciones = new ArrayList();

  private static void cargar_validaciones(String nombre, String apelldio){
    if (validaciones.isEmpty()){
      no_es_igual_al_nombre v1 = new no_es_igual_al_nombre(nombre);
      no_es_igual_al_nombre v2 = new no_es_igual_al_nombre(apelldio);
      cumple_longitud_minima v3 = new cumple_longitud_minima();
      no_es_insegura v4 = new no_es_insegura();
      no_es_repeticion_de_caracteres v5 = new no_es_repeticion_de_caracteres();
      validar_caracteres v6 = new validar_caracteres();
      validaciones.add(v1);
      validaciones.add(v2);
      validaciones.add(v3);
      validaciones.add(v4);
      validaciones.add(v5);
      validaciones.add(v6);
    }
  }

  public static boolean validar(String nombre, String apellido, String password){
    cargar_validaciones(nombre, apellido);
    int contadora = 0;
    boolean password_valida = true;
    while(contadora < validaciones.size() && password_valida){
      validacion siguiente_validacion = (validacion) validaciones.get(contadora);
      password_valida = siguiente_validacion.validar(password);
      contadora += 1;
    }
    return password_valida;
  }
}
