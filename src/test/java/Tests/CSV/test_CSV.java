package Tests.CSV;


import Domain.CSV.CSV;
import Domain.Entidades.Entidad;
import Domain.Entidades.Organismo_Control;

public class test_CSV {
  public static void main(String[] args) {
    CSV carga_entidades_prestadoras = new CSV();
    carga_entidades_prestadoras.cargarCSV("src/main/java/Domain/CSV/ArchivoCSV.csv");



      while(!carga_entidades_prestadoras.getEntidades_prestadoras().isEmpty()){
        Entidad entidad = carga_entidades_prestadoras.getEntidades_prestadoras().get(0);
        System.out.println(entidad.getNombre()+ ", "+ entidad.getClass().getSimpleName());

        carga_entidades_prestadoras.getEntidades_prestadoras().remove(0);
    }

      while(!carga_entidades_prestadoras.getOrganismos_control().isEmpty()){
       Organismo_Control organismoDeControl = carga_entidades_prestadoras.getOrganismos_control().get(0);
        System.out.println(organismoDeControl.getNombre() + ", " + organismoDeControl.getClass().getSimpleName());
        carga_entidades_prestadoras.getOrganismos_control().remove(0);
    }
  }
}
