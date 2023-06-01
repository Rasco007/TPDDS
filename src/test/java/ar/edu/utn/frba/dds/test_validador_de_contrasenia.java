package ar.edu.utn.frba.dds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test_validador_de_contrasenia {
  @Test
  public class testear_passwords(){
    String password = "Pepe1234";
    String nombre = "Roberto";
    String apellido = "Carlos";
    validador_de_contrasenia validador = new validador_de_contrasenia();
    Assertions.assertEquals(true, validador_de_contrasenia.validar(nombre, apellido, password));
  }
}
