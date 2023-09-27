package Domain.Incidente;
import Domain.GeneradorDeRankings.Generador_Rankings;
import Domain.Personas.Comunidad;
import Domain.Personas.Perfil;
import Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table
public class Incidente {
    public Incidente() {
        fecha_hora_de_inicio= new Timestamp(System.currentTimeMillis());
        resuelto=false;
    }

    @Id
    @GeneratedValue
    private int id;
    @OneToOne //todo, no seria many to one asi el servicio puede tener mas de un incidente?
                //aunque pueda tener uno solo no resuelto, el resto los tenes q guardar igual
    @JoinColumn(name = "servicioAfectado_id",referencedColumnName = "id")
    private Servicio servicio_afectado;
    @Column
    private Timestamp fecha_hora_de_inicio;
    @Column
    private Timestamp Fecha_Hora_de_cierre;
    @Column(columnDefinition = "varchar2(100)")
    private String observaciones;
    @Column
    private Boolean resuelto;
    @ManyToOne
    @JoinColumn(name = "comunidadAfectada_id",referencedColumnName = "id")
    private Comunidad comunidad_afectada;

    @ManyToOne
    @JoinColumn(name = "usuario_iniciador",referencedColumnName = "id")
    private Perfil usuario_iniciador;
    @ManyToOne
    @JoinColumn(name = "usuario_finalizador",referencedColumnName = "id")
    private Perfil usuario_finalizador;


    //persistencia
    @ManyToOne
    @JoinColumn(name = "generador_semanal",referencedColumnName = "id")
    private Generador_Rankings generadorSemanal;
}

