package ar.edu.utn.frba.dds.Domain.Entidades;

import ar.edu.utn.frba.dds.Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "organismo_control")
public class Organismo_Control {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "varchar(100)")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "entidad_id")
    private Entidad entidad;
    @Transient
    private List<Servicio> servicios;


    /*public void setServicios(){
        for(int i=0;i<entidades.size();i++) {
            for (int j=0;i<entidades.get(i).getSucursales().size();j++) {
                for (int k=0;i<entidades.get(i).getSucursales().get(j).getServicios().size();k++) {
                    servicios.add(entidades.get(i).getSucursales().get(j).getServicios().get(k));
                }
            }
        }
    }*/

}
