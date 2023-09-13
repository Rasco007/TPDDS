package Tests.CSV;


import Domain.CSV.CSV;
import Domain.Entidades.Entidad;
import Domain.Entidades.Organismo_Control;

public class test_CSV {
  public static void main(String[] args) {
    CSV cargaDeEntidadesPrestadoras = new CSV();
    cargaDeEntidadesPrestadoras.cargarCSV("src/main/java/Domain/Entidades/ArchivoCSV.csv");



      while(!cargaDeEntidadesPrestadoras.getEntidadesPrestadoras().isEmpty()){
        Entidad entidad = cargaDeEntidadesPrestadoras.getEntidadesPrestadoras().get(0);
        System.out.println(entidad.getNombre()+ ", "+ entidad.getClass().getSimpleName());

        cargaDeEntidadesPrestadoras.getEntidadesPrestadoras().remove(0);
    }

      while(!cargaDeEntidadesPrestadoras.getOrganismosDeControl().isEmpty()){
       Organismo_Control organismoDeControl = cargaDeEntidadesPrestadoras.getOrganismosDeControl().get(0);
        System.out.println(organismoDeControl.getNombre() + ", " + organismoDeControl.getClass().getSimpleName());
        cargaDeEntidadesPrestadoras.getOrganismosDeControl().remove(0);
    }
  }
}
