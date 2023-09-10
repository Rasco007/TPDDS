package Domain.GeoRef;

import ar.edu.utn.frba.dds.GeoRef.Entidades.Listado_Municipios;
import ar.edu.utn.frba.dds.GeoRef.Entidades.Listado_Provincias;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Servicio {
  @GET("provincias")
  Call<Listado_Provincias> provincias();

  @GET("provincias")
  Call<Listado_Provincias> provincias(@Query("campos") String campos);

  @GET("municipios")
  Call<Listado_Municipios> municipios(@Query("provincia") int idProvincia);

  @GET("municipios")
  Call<Listado_Municipios> municipios(@Query("provincia") int idProvincia, @Query("campos") String campos);

  @GET("municipios")
  Call<Listado_Municipios> municipios(@Query("provincia") int idProvincia, @Query("campos") String campos, @Query("max") int max);
}