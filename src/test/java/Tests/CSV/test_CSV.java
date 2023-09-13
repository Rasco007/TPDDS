package Tests.CSV;


import Domain.CSV.CSV;
import Domain.Entidades.entidad;
import Domain.Entidades.organismoControl;

public class test_CSV {
  public static void main(String[] args) {
    CSV cargaDeEntidadesPrestadoras = new CSV();
    cargaDeEntidadesPrestadoras.cargarCSV("src/main/java/Domain/Entidades/ArchivoCSV.csv");



      while(!cargaDeEntidadesPrestadoras.getEntidadesPrestadoras().isEmpty()){
        entidad entidad = cargaDeEntidadesPrestadoras.getEntidadesPrestadoras().get(0);
        System.out.println(entidad.getNombre()+ ", "+ entidad.getClass().getSimpleName());

        cargaDeEntidadesPrestadoras.getEntidadesPrestadoras().remove(0);
    }

      while(!cargaDeEntidadesPrestadoras.getOrganismosDeControl().isEmpty()){
       organismoControl organismoDeControl = cargaDeEntidadesPrestadoras.getOrganismosDeControl().get(0);
        System.out.println(organismoDeControl.getNombre() + ", " + organismoDeControl.getClass().getSimpleName());
        cargaDeEntidadesPrestadoras.getOrganismosDeControl().remove(0);
    }
  }
}
