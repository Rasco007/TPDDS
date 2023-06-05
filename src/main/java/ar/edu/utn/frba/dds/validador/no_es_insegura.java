package ar.edu.utn.frba.dds.validador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class no_es_insegura extends validacion {
  Set<String> contraseniasInseguras = new HashSet<String>();
  String path = "../2023-tpa-mi-no-grupo-20/src/main/java/ar/edu/utn/frba/dds/10k-contrasenias.txt";
  boolean cargadasContraseniasInseguras = false;

  public boolean validar(String password) {
    if(!cargadasContraseniasInseguras) {
      this.cargarContraseniasInseguras();
    }
    return !(contraseniasInseguras.contains(password));
  }

  private void cargarContraseniasInseguras() {
    File file = new File(path);

    try{
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        contraseniasInseguras.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    cargadasContraseniasInseguras = true;
  }
}
