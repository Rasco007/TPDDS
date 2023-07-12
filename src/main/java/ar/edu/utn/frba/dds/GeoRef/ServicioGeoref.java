package ar.edu.utn.frba.dds.GeoRef;

import ar.edu.utn.frba.dds.GeoRef.Entidades.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioGeoref {
  private static ServicioGeoref instancia = null;
  private static int maximaCantidadRegistrosDefault = 200;
  private static final String urlApi = "https://apis.datos.gob.ar/georef/api/";
  private Retrofit retrofit;

  private ServicioGeoref() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(urlApi)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static ServicioGeoref instancia(){
    if(instancia== null){
      instancia = new ServicioGeoref();
    }
    return instancia;
  }

  public Listado_Provincias listadoDeProvincias() throws IOException {
    Servicio georefService = this.retrofit.create(Servicio.class);
    Call<Listado_Provincias> requestProvinciasArgentinas = georefService.provincias();
    Response<Listado_Provincias> responseProvinciasArgentinas = requestProvinciasArgentinas.execute();
    return responseProvinciasArgentinas.body();
  }

  public Listado_Municipios listadoDeMunicipiosDeProvincia(Provincia provincia) throws IOException {
    Servicio georefService = this.retrofit.create(Servicio.class);
    Call<Listado_Municipios> requestListadoDeMunicipios = georefService.municipios(provincia.id, "id, nombre", maximaCantidadRegistrosDefault);
    Response<Listado_Municipios> responseListadoDeMunicipios = requestListadoDeMunicipios.execute();
    return responseListadoDeMunicipios.body();
  }
}