package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.API_REST.Entidades.*;
import ar.edu.utn.frba.dds.API_REST.ServicioGeoref;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;


public class test_API_REST {
  public static void main(String[] args) throws IOException {
    ServicioGeoref servicioGeoref = ServicioGeoref.instancia();
    System.out.println("Seleccione una de las siguientes provincias, ingresando su id:");

    Listado_Provincias listadoDeProvinciasArgentinas = servicioGeoref.listadoDeProvincias();

    listadoDeProvinciasArgentinas.provincias.sort((p1, p2) -> p1.id >= p2.id? 1 : -1);

    for(Provincia unaProvincia:listadoDeProvinciasArgentinas.provincias){
      System.out.println(unaProvincia.id + ") " + unaProvincia.nombre);
    }

    Scanner entradaEscaner = new Scanner(System.in);
    int idProvinciaElegida = Integer.parseInt(entradaEscaner.nextLine());

    Optional<Provincia> posibleProvincia = listadoDeProvinciasArgentinas.provinciaDeId(idProvinciaElegida);

    if(posibleProvincia.isPresent()){
      Provincia provinciaSeleccionada = posibleProvincia.get();
      Listado_Municipios municipiosDeLaProvincia = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);
      System.out.println("Los municipios de la provincia "+ provinciaSeleccionada.nombre +" son:");
      for(Municipio unMunicipio: municipiosDeLaProvincia.municipios){
        System.out.println(unMunicipio.nombre);
      }
    }
    else{
      System.out.println("No existe la provincia seleccionada");
    }
  }
}