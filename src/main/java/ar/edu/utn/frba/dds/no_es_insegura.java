package ar.edu.utn.frba.dds;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class no_es_insegura {
  Set<String> contraseniasInseguras = new HashSet<String>();
  String path = "10k-contrasenias.txt";
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
