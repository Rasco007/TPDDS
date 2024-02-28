package Tests.Rankings;

import Domain.Entidades.Entidad;
import Domain.Entidades.Establecimiento;
import Domain.GeneradorDeRankings.Mas_Incidentes;
import Domain.GeneradorDeRankings.Mayor_Grado_Impacto;
import Domain.GeneradorDeRankings.Mayor_Tiempo_Cierre;
import Domain.Incidente.Incidente;
import Domain.Personas.Comunidad;
import Domain.Personas.Usuario;
import Domain.Servicio.Servicio;
import Domain.Servicio.Servicio_Base;
import Domain.Servicio.Servicio_Compuesto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_ranking_Impacto {

    private List<Entidad> entidades= new ArrayList<Entidad>();
    private List<Establecimiento> establecimientos=new ArrayList<Establecimiento>();
    private List<Servicio> servicios=new ArrayList<Servicio>();
    private List<Incidente> incidentes=new ArrayList<Incidente>();

    public void inicializar(){

        //LINEA A


        Entidad lineaA=new Entidad();
        lineaA.setNombre("linea A");
        entidades.add(lineaA);

        Establecimiento miserere=new Establecimiento();
        miserere.setNombre("plaza miserere");
        miserere.setEntidad(lineaA);
        establecimientos.add(miserere);

        Servicio_Base banioHombresMiserere= new Servicio_Base();
        servicios.add(banioHombresMiserere);

        Servicio_Base banioMujeresMiserere= new Servicio_Base();
        servicios.add(banioMujeresMiserere);

        Servicio_Compuesto baniosMiserere=new Servicio_Compuesto();
        baniosMiserere.agregar(banioHombresMiserere);
        baniosMiserere.agregar(banioMujeresMiserere);
        servicios.add(baniosMiserere);

        Servicio_Base escalerasMiserere=new Servicio_Base();
        servicios.add(escalerasMiserere);

        Establecimiento loria=new Establecimiento();
        loria.setNombre("plaza miserere");
        loria.setEntidad(lineaA);
        establecimientos.add(loria);

        Servicio_Base banioHombresLoria= new Servicio_Base();
        servicios.add(banioHombresLoria);

        Servicio_Base banioMujeresLoria= new Servicio_Base();
        servicios.add(banioMujeresLoria);

        Servicio_Compuesto baniosLoria=new Servicio_Compuesto();
        baniosLoria.agregar(banioHombresLoria);
        baniosLoria.agregar(banioMujeresLoria);
        servicios.add(baniosLoria);

        Servicio_Base escalerasLoria=new Servicio_Base();
        servicios.add(escalerasLoria);



        //LINEA E


        Entidad lineaE=new Entidad();
        lineaE.setNombre("linea E");
        entidades.add(lineaE);

        Establecimiento jujuy=new Establecimiento();
        jujuy.setNombre("jujuy");
        jujuy.setEntidad(lineaE);
        establecimientos.add(jujuy);

        Servicio_Base banioHombresJujuy= new Servicio_Base();
        servicios.add(banioHombresJujuy);

        Servicio_Base banioMujeresJujuy= new Servicio_Base();
        servicios.add(banioMujeresJujuy);

        Servicio_Compuesto baniosJujuy=new Servicio_Compuesto();
        baniosJujuy.agregar(banioHombresJujuy);
        baniosJujuy.agregar(banioMujeresJujuy);
        servicios.add(baniosJujuy);

        Servicio_Base escalerasJujuy=new Servicio_Base();
        servicios.add(escalerasJujuy);

        Establecimiento bolivar=new Establecimiento();
        bolivar.setNombre("plaza miserere");
        bolivar.setEntidad(lineaE);
        establecimientos.add(bolivar);

        Servicio_Base banioHombresBolivar= new Servicio_Base();
        servicios.add(banioHombresBolivar);

        Servicio_Base banioMujeresBolivar= new Servicio_Base();
        servicios.add(banioMujeresBolivar);

        Servicio_Compuesto baniosBolivar=new Servicio_Compuesto();
        baniosBolivar.agregar(banioHombresBolivar);
        baniosBolivar.agregar(banioMujeresBolivar);
        servicios.add(baniosBolivar);

        Servicio_Base escalerasBolivar=new Servicio_Base();
        servicios.add(escalerasBolivar);




        //BANCO CIUDAD

        Entidad bancoCiudad=new Entidad();
        bancoCiudad.setNombre("Banco ciudad");
        entidades.add(bancoCiudad);

        Establecimiento bancoCiudadBoedo=new Establecimiento();
        bancoCiudadBoedo.setNombre("banco ciudad sede boedo");
        bancoCiudadBoedo.setEntidad(bancoCiudad);
        establecimientos.add(bancoCiudadBoedo);

        Servicio_Base banioHombresBancoCiudadBoedo= new Servicio_Base();
        servicios.add(banioHombresBancoCiudadBoedo);

        Servicio_Base banioMujeresBancoCiudadBoedo= new Servicio_Base();
        servicios.add(banioMujeresBancoCiudadBoedo);

        Servicio_Compuesto baniosBancoCiudadBoedo=new Servicio_Compuesto();
        baniosBancoCiudadBoedo.agregar(banioHombresBancoCiudadBoedo);
        baniosBancoCiudadBoedo.agregar(banioMujeresBancoCiudadBoedo);
        servicios.add(baniosBancoCiudadBoedo);

        Servicio_Base ascensorBancoCiudadBoedo=new Servicio_Base();
        servicios.add(ascensorBancoCiudadBoedo);

        //USUARIOS

        Usuario usuario1 = new Usuario();
        usuario1.setLogin("Emiliano");
        Usuario usuario2 = new Usuario();
        usuario2.setLogin("Nicolas");
        Usuario usuario3 = new Usuario();
        usuario3.setLogin("Cristian");
        Usuario usuario4 = new Usuario();
        usuario4.setLogin("Nicolas");
        Usuario usuario5 = new Usuario();
        usuario5.setLogin("Nahuel");
        Usuario usuario6 = new Usuario();
        usuario6.setLogin("Alexis");
        Usuario usuario7 = new Usuario();
        usuario7.setLogin("Enzo");
        Usuario usuario8 = new Usuario();
        usuario8.setLogin("Rodrigo");
        Usuario usuario9 = new Usuario();
        usuario9.setLogin("Lionel");
        Usuario usuario10= new Usuario();
        usuario10.setLogin("Julian");
        Usuario usuario11 = new Usuario();
        usuario11.setLogin("Angel");
        Usuario usuario12 = new Usuario();
        usuario12.setLogin("Leonel");


        //COMUNIDADES
        /*
        comunidad.getMiembros_afectados().add();
        comunidad.getAdministradores().add();
        comunidad.getMiembros_observadores().add();
         */
        Comunidad comunidad1 =new Comunidad();
        comunidad1.getMiembros().add(usuario3);
        comunidad1.getMiembros().add(usuario4);
        comunidad1.getMiembros().add(usuario1);
        comunidad1.getAdministradores().add(usuario3);
        comunidad1.getMiembros().add(usuario7);

        Comunidad comunidad2 =new Comunidad();
        comunidad2.getMiembros().add(usuario3);
        comunidad2.getMiembros().add(usuario2);
        comunidad2.getMiembros().add(usuario6);
        comunidad2.getMiembros().add(usuario7);
        comunidad2.getAdministradores().add(usuario5);
        comunidad2.getMiembros().add(usuario5);
        comunidad2.getMiembros().add(usuario8);

        Comunidad comunidad3 =new Comunidad();
        comunidad3.getMiembros().add(usuario9);
        comunidad3.getAdministradores().add(usuario9);
        comunidad3.getMiembros().add(usuario10);

        Comunidad comunidad4 =new Comunidad();
        comunidad4.getMiembros().add(usuario11);
        comunidad4.getMiembros().add(usuario4);
        comunidad4.getAdministradores().add(usuario12);
        comunidad4.getMiembros().add(usuario12);


       // 3 4 1 2

        //INCIDENTES
        //linea E afectafos:13
        Incidente incidente1=new Incidente();
        incidente1.setServicio_afectado(escalerasBolivar);
        incidente1.setResuelto(true);
        incidente1.setComunidad_afectada(comunidad1);

        Incidente incidente2=new Incidente();
        incidente2.setServicio_afectado(escalerasBolivar);
        incidente2.setResuelto(true);
        incidente2.setComunidad_afectada(comunidad2);

        Incidente incidente3=new Incidente();
        incidente3.setServicio_afectado(baniosBolivar);
        incidente3.setComunidad_afectada(comunidad3);

        Incidente incidente4=new Incidente();
        incidente4.setServicio_afectado(escalerasJujuy);
        incidente4.setResuelto(true);
        incidente4.setComunidad_afectada(comunidad4);

        Incidente incidente5=new Incidente();
        incidente5.setServicio_afectado(banioMujeresJujuy);
        incidente5.setComunidad_afectada(comunidad1);

        //Linea A afectados: 10
        Incidente incidente6=new Incidente();
        incidente6.setServicio_afectado(banioHombresLoria);
        incidente6.setResuelto(true);
        incidente6.setComunidad_afectada(comunidad2);


        Incidente incidente7=new Incidente();
        incidente7.setServicio_afectado(escalerasLoria);
        incidente7.setComunidad_afectada(comunidad3);

        Incidente incidente8=new Incidente();
        incidente8.setServicio_afectado(escalerasMiserere);
        incidente8.setComunidad_afectada(comunidad4);

        Incidente incidente9=new Incidente();
        incidente9.setServicio_afectado(banioHombresMiserere);
        incidente9.setComunidad_afectada(comunidad1);

        //banco 5
        Incidente incidente10=new Incidente();
        incidente10.setServicio_afectado(ascensorBancoCiudadBoedo);
        incidente10.setResuelto(true);
        incidente10.setComunidad_afectada(comunidad2);

        Incidente incidente11=new Incidente();
        incidente11.setServicio_afectado(banioHombresBancoCiudadBoedo);
        incidente11.setComunidad_afectada(comunidad3);

        incidentes.add(incidente1);
        incidentes.add(incidente2);
        incidentes.add(incidente3);
        incidentes.add(incidente4);
        incidentes.add(incidente5);
        incidentes.add(incidente6);
        incidentes.add(incidente7);
        incidentes.add(incidente8);
        incidentes.add(incidente9);
        incidentes.add(incidente10);
        incidentes.add(incidente11);
    }


    private boolean rankingPorImpacto(){

        this.inicializar();

        //new Mayor_Grado_Impacto().generarRanking(incidentes);
        //LISTA:  A,E,BANCO
        //CANT    10 13 5
        //puestos 1 0 2
        boolean b = entidades.get(1).getRankingImpacto().getPosicion() < entidades.get(0).getRankingImpacto().getPosicion() &&
                entidades.get(0).getRankingImpacto().getPosicion() < entidades.get(2).getRankingImpacto().getPosicion() ;
        System.out.print(entidades.get(0).getNombre());
        System.out.print("\n");
        System.out.print(entidades.get(0).getRankingImpacto().getPosicion());
        System.out.print("\n");
        System.out.print(entidades.get(1).getNombre());
        System.out.print("\n");
        System.out.print(entidades.get(1).getRankingImpacto().getPosicion());
        System.out.print("\n");
        System.out.print(entidades.get(2).getNombre());
        System.out.print("\n");
        System.out.print(entidades.get(2).getRankingImpacto().getPosicion());

        return b;
    }


    @Test
    public void testear() {
        Assertions.assertTrue(this.rankingPorImpacto());
    }
}
