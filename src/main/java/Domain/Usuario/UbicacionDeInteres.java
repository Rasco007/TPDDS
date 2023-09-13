package Domain.Usuario;
import Domain.GeoRef.Entidades.Municipio;
import Domain.GeoRef.Entidades.Provincia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UbicacionDeInteres {

    private Localidad localidadDeInteres;
    private Departamento departamentoDeInteres;
    private Provincia provinciaDeInteres;
    private Municipio municipioDeInteres;


}
