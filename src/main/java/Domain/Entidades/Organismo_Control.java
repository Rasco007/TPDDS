package Domain.Entidades;

import Domain.Servicio.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Organismo_Control {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "varchar2(100)")
    private String nombre;
    @ManyToMany
    @JoinTable(name = "organismo_entidad",joinColumns = @JoinColumn(name = "organismo_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "entidad_id",referencedColumnName = "id"))
    private List<Entidad> entidades;
    @Transient
    private List<Servicio> servicios;


    public void setServicios(){
        for(int i=0;i<entidades.size();i++) {
            for (int j=0;i<entidades.get(i).getSucursales().size();j++) {
                for (int k=0;i<entidades.get(i).getSucursales().get(j).getServicios().size();k++) {
                    servicios.add(entidades.get(i).getSucursales().get(j).getServicios().get(k));
                }
            }
        }
    }

}
