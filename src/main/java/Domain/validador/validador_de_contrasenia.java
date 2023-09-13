package Domain.validador;

import Domain.Personas.Usuario;
import java.util.ArrayList;

public class validador_de_contrasenia {
  private static ArrayList validaciones = new ArrayList();

  private static void cargar_validaciones(Usuario usuario){
    if (validaciones.isEmpty()){
      no_es_igual_al_nombre v1 = new no_es_igual_al_nombre(usuario.getPerfil().get);
      no_es_igual_al_nombre v2 = new no_es_igual_al_nombre(usuario.getApellido());
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

  public static boolean validar(Usuario usuario){
    cargar_validaciones(usuario);
    int contadora = 0;
    boolean password_valida = true;
    while(contadora < validaciones.size() && password_valida){
      validacion siguiente_validacion = (validacion) validaciones.get(contadora);
      password_valida = siguiente_validacion.validar(usuario.getPassword());
      contadora += 1;
    }
    return password_valida;
  }
}
