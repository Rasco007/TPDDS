package Domain.GeoRef;

import Domain.GeoRef.Entidades.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioGeoref {
  private static ServicioGeoref instancia = null;
  private static int maximaCantidadRegistrosDefault = 200;
  private Retrofit retrofit;

  private ServicioGeoref() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl("https://apis.datos.gob.ar/georef/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static ServicioGeoref instancia(){
    if(instancia== null){
      instancia = new ServicioGeoref();
    }
    return instancia;
  }

  public Listado_Provincias listado_Provincias() throws IOException {
    Servicio georefService = this.retrofit.create(Servicio.class);
    Call<Listado_Provincias> requestProvinciasArgentinas = georefService.provincias();
    Response<Listado_Provincias> responseProvinciasArgentinas = requestProvinciasArgentinas.execute();
    return responseProvinciasArgentinas.body();
  }

  public Listado_Municipios listado_MunicipiosDeProvincia(Provincia provincia) throws IOException {
    Servicio georefService = this.retrofit.create(Servicio.class);
    Call<Listado_Municipios> requestListado_Municipios = georefService.municipios(provincia.id, "id, nombre", maximaCantidadRegistrosDefault);
    Response<Listado_Municipios> responseListado_Municipios = requestListado_Municipios.execute();
    return responseListado_Municipios.body();
  }

  public Listado_Departamentos listado_DepartamentosPorId(Departamento departamento) throws IOException {
    Servicio georefService = this.retrofit.create(Servicio.class);
    Call<Listado_Departamentos> requestListado_Departamentos = georefService.departamentos(departamento.id);
    Response<Listado_Departamentos> responseListado_Departamentos = requestListado_Departamentos.execute();
    return responseListado_Departamentos.body();
  }
  public Listado_Localidades listado_Localidades(Localidad localidad) throws IOException {
    Servicio georefService = this.retrofit.create(Servicio.class);
    Call<Listado_Localidades> requestListado_Localidades = georefService.localidades(localidad.id);
    Response<Listado_Localidades> responseListado_Localidades = requestListado_Localidades.execute();
    return responseListado_Localidades.body();
  }

}