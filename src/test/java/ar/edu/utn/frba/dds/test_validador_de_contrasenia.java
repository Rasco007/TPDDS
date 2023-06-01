package ar.edu.utn.frba.dds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test_validador_de_contrasenia {
  @Test
  public void testear_passwords(){
    String password = "Pepe&1234";
    String nombre = "Roberto";
    String apellido = "Carlos";
    validador_de_contrasenia validador = new validador_de_contrasenia();
    Assertions.assertEquals(true, validador.validar(nombre, apellido, password));
  }
}
