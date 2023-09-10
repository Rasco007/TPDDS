package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.validador.validador_de_contrasenia;
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
// notificaciones por mail y wpp https://www.twilio.com/es-mx/docs/whatsapp https://es.mailpro.com/api/
// Hacer Unit test para probar importación y API Rest.