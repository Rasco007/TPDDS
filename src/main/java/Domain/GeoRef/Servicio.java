package Domain.GeoRef;

import Domain.GeoRef.Entidades.Listado_Departamentos;
import Domain.GeoRef.Entidades.Listado_Localidades;
import Domain.GeoRef.Entidades.Listado_Municipios;
import Domain.GeoRef.Entidades.Listado_Provincias;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Servicio {
  @GET("provincias")
  Call<Listado_Provincias> provincias();

  @GET("provincias")
  Call<Listado_Provincias> provincias(@Query("campos") String campos);

  @GET("municipios")
  Call<Listado_Municipios> municipios();

  @GET("municipios")
  Call<Listado_Municipios> municipios(@Query("provincia") int idProvincia);

  @GET("municipios")
  Call<Listado_Municipios> municipios(@Query("provincia") int idProvincia, @Query("campos") String campos);

  @GET("municipios")
  Call<Listado_Municipios> municipios(@Query("provincia") int idProvincia, @Query("campos") String campos, @Query("max") int max);

  @GET("departamentos")
  Call<Listado_Departamentos> departamentos();

  @GET("departamentos")
  Call<Listado_Departamentos> departamentos(@Query("id") int idDepartamento);

  @GET("departamentos")
  Call<Listado_Departamentos> departamentos(@Query("provincia") int idProvincia, @Query("campos") String campos);

  @GET("departamentos")
  Call<Listado_Departamentos> departamentos(@Query("provincia") int idProvincia, @Query("campos") String campos, @Query("max") int max);
  @GET("localidades")
  Call<Listado_Localidades> localidades();

  @GET("localidades")
  Call<Listado_Localidades> localidades(@Query("id") int idLocalidad);

  @GET("localidades")
  Call<Listado_Localidades> localidades(@Query("provincia") int idProvincia, @Query("campos") String campos);

  @GET("localidades")
  Call<Listado_Localidades> localidades(@Query("provincia") int idProvincia, @Query("campos") String campos, @Query("max") int max);

}