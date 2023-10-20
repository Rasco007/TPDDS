package Tests.Rankings;

import Domain.Entidades.Entidad;
import Domain.Entidades.Establecimiento;
import Domain.GeneradorDeRankings.Mas_Incidentes;
import Domain.Incidente.Incidente;
import Domain.Servicio.Servicio;
import Domain.Servicio.Servicio_Base;
import Domain.Servicio.Servicio_Compuesto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_ranking_cant {
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
        banioHombresMiserere.setEstablecimiento(miserere);
        servicios.add(banioHombresMiserere);

        Servicio_Base banioMujeresMiserere= new Servicio_Base();
        banioMujeresMiserere.setEstablecimiento(miserere);
        servicios.add(banioMujeresMiserere);

        Servicio_Compuesto baniosMiserere=new Servicio_Compuesto();
        baniosMiserere.setEstablecimiento(miserere);
        baniosMiserere.agregar(banioHombresMiserere);
        baniosMiserere.agregar(banioMujeresMiserere);
        servicios.add(baniosMiserere);

        Servicio_Base escalerasMiserere=new Servicio_Base();
        escalerasMiserere.setEstablecimiento(miserere);
        servicios.add(escalerasMiserere);

        Establecimiento loria=new Establecimiento();
        loria.setNombre("plaza miserere");
        loria.setEntidad(lineaA);
        establecimientos.add(loria);

        Servicio_Base banioHombresLoria= new Servicio_Base();
        banioHombresLoria.setEstablecimiento(loria);
        servicios.add(banioHombresLoria);

        Servicio_Base banioMujeresLoria= new Servicio_Base();
        banioMujeresLoria.setEstablecimiento(loria);
        servicios.add(banioMujeresLoria);

        Servicio_Compuesto baniosLoria=new Servicio_Compuesto();
        baniosLoria.setEstablecimiento(loria);
        baniosLoria.agregar(banioHombresLoria);
        baniosLoria.agregar(banioMujeresLoria);
        servicios.add(baniosLoria);

        Servicio_Base escalerasLoria=new Servicio_Base();
        escalerasLoria.setEstablecimiento(loria);
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
        banioHombresJujuy.setEstablecimiento(jujuy);
        servicios.add(banioHombresJujuy);

        Servicio_Base banioMujeresJujuy= new Servicio_Base();
        banioMujeresJujuy.setEstablecimiento(jujuy);
        servicios.add(banioMujeresJujuy);

        Servicio_Compuesto baniosJujuy=new Servicio_Compuesto();
        baniosJujuy.setEstablecimiento(jujuy);
        baniosJujuy.agregar(banioHombresJujuy);
        baniosJujuy.agregar(banioMujeresJujuy);
        servicios.add(baniosJujuy);

        Servicio_Base escalerasJujuy=new Servicio_Base();
        escalerasJujuy.setEstablecimiento(jujuy);
        servicios.add(escalerasJujuy);

        Establecimiento bolivar=new Establecimiento();
        bolivar.setNombre("plaza miserere");
        bolivar.setEntidad(lineaE);
        establecimientos.add(bolivar);

        Servicio_Base banioHombresBolivar= new Servicio_Base();
        banioHombresBolivar.setEstablecimiento(bolivar);
        servicios.add(banioHombresBolivar);

        Servicio_Base banioMujeresBolivar= new Servicio_Base();
        banioMujeresBolivar.setEstablecimiento(bolivar);
        servicios.add(banioMujeresBolivar);

        Servicio_Compuesto baniosBolivar=new Servicio_Compuesto();
        baniosBolivar.setEstablecimiento(bolivar);
        baniosBolivar.agregar(banioHombresBolivar);
        baniosBolivar.agregar(banioMujeresBolivar);
        servicios.add(baniosBolivar);

        Servicio_Base escalerasBolivar=new Servicio_Base();
        escalerasBolivar.setEstablecimiento(bolivar);
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
        banioHombresBancoCiudadBoedo.setEstablecimiento(bancoCiudadBoedo);
        servicios.add(banioHombresBancoCiudadBoedo);

        Servicio_Base banioMujeresBancoCiudadBoedo= new Servicio_Base();
        banioMujeresBancoCiudadBoedo.setEstablecimiento(bancoCiudadBoedo);
        servicios.add(banioMujeresBancoCiudadBoedo);

        Servicio_Compuesto baniosBancoCiudadBoedo=new Servicio_Compuesto();
        baniosBancoCiudadBoedo.setEstablecimiento(bancoCiudadBoedo);
        baniosBancoCiudadBoedo.agregar(banioHombresBancoCiudadBoedo);
        baniosBancoCiudadBoedo.agregar(banioMujeresBancoCiudadBoedo);
        servicios.add(baniosBancoCiudadBoedo);

        Servicio_Base ascensorBancoCiudadBoedo=new Servicio_Base();
        ascensorBancoCiudadBoedo.setEstablecimiento(bancoCiudadBoedo);
        servicios.add(ascensorBancoCiudadBoedo);



        //INCIDENTES
        //Linea A
        Incidente incidente6=new Incidente();
        incidente6.setServicio_afectado(banioHombresLoria);
        Incidente incidente7=new Incidente();
        incidente7.setServicio_afectado(escalerasLoria);
        Incidente incidente8=new Incidente();
        incidente8.setServicio_afectado(escalerasMiserere);
        Incidente incidente9=new Incidente();
        incidente9.setServicio_afectado(banioHombresMiserere);
        //linea E
        Incidente incidente1=new Incidente();
        incidente1.setServicio_afectado(escalerasBolivar);
        incidente1.setResuelto(true);
        Incidente incidente2=new Incidente();
        incidente2.setServicio_afectado(escalerasBolivar);
        Incidente incidente3=new Incidente();
        incidente3.setServicio_afectado(baniosBolivar);
        Incidente incidente4=new Incidente();
        incidente4.setServicio_afectado(escalerasJujuy);
        incidente4.setResuelto(true);
        Incidente incidente5=new Incidente();
        incidente5.setServicio_afectado(banioMujeresJujuy);

        //banco
        Incidente incidente10=new Incidente();
        incidente10.setServicio_afectado(ascensorBancoCiudadBoedo);
        Incidente incidente11=new Incidente();
        incidente11.setServicio_afectado(banioHombresBancoCiudadBoedo);


        incidentes.add(incidente6);
        incidentes.add(incidente7);
        incidentes.add(incidente8);
        incidentes.add(incidente9);
        incidentes.add(incidente1);
        incidentes.add(incidente2);
        incidentes.add(incidente3);
        incidentes.add(incidente4);
        incidentes.add(incidente5);

        incidentes.add(incidente10);
        incidentes.add(incidente11);
    }


    private boolean rankingPorCantidad(){

        this.inicializar();

        new Mas_Incidentes().generarRanking(incidentes);
        //LISTA: A,E,BANCO
        //CANT A:4  E:5  BANCO:2
        //puestos 2 1 3
        boolean b = entidades.get(1).getRankingCantIncidentes().getPosicion() < entidades.get(0).getRankingCantIncidentes().getPosicion() &&
                    entidades.get(0).getRankingCantIncidentes().getPosicion() < entidades.get(2).getRankingCantIncidentes().getPosicion() ;
       /* System.out.print(entidades.get(0).getNombre());
        System.out.print("\n");
        System.out.print(entidades.get(0).getRankingCantIncidentes().getPosicion());
        System.out.print("\n");
        System.out.print(entidades.get(0).getRankingCantIncidentes().getSemana());
        System.out.print("\n");
        System.out.print(entidades.get(0).getRankingCantIncidentes().getTipoDeRanking());
        System.out.print("\n");
        System.out.print(entidades.get(1).getNombre());
        System.out.print("\n");
        System.out.print(entidades.get(1).getRankingCantIncidentes().getPosicion());
        System.out.print("\n");
        System.out.print(entidades.get(2).getNombre());
        System.out.print("\n");
        System.out.print(entidades.get(2).getRankingCantIncidentes().getPosicion());
*/
        return b;
    }

    @Test
    public void testear() {
        Assertions.assertTrue(this.rankingPorCantidad());
    }



}