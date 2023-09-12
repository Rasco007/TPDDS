package ar.edu.utn.frba.dds.Usuario;
import ar.edu.utn.frba.dds.Establecimiento.Establecimiento;
import ar.edu.utn.frba.dds.GeoRef.Entidades.Municipio;
import ar.edu.utn.frba.dds.GeoRef.Entidades.Provincia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class UbicacionDeInteres {

    private Localidad localidadDeInteres;
    private Departamento departamentoDeInteres;
    private Provincia provinciaDeInteres;
    private Municipio municipioDeInteres;


}
