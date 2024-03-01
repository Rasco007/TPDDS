package ar.edu.utn.frba.dds.Domain.validador;

import ar.edu.utn.frba.dds.Domain.Personas.Usuario;
import java.util.ArrayList;

public class validador_de_contrasenia {
  private static ArrayList validaciones = new ArrayList();

  public void agragar_validacion(validacion a_agregar){
    validaciones.add(a_agregar);
  }

  public void eliminar_validacion(validacion a_eliminar){
    validaciones.remove(a_eliminar);
  }

  public static boolean validar(Usuario usuario){
    int contadora = 0;
    boolean password_valida = true;
    while(contadora < validaciones.size() && password_valida){
      validacion siguiente_validacion = (validacion) validaciones.get(contadora);
      password_valida = siguiente_validacion.validar(usuario);
      contadora += 1;
    }
    return password_valida;
  }
}
