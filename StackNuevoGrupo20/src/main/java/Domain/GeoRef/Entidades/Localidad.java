package Domain.GeoRef.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Localidad {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "nombre")
    public String nombre;
    @OneToOne
    @JoinColumn(name = "centroide",referencedColumnName = "id")
    public Centroide centroide;
    //persistencia
    @ManyToOne
    @JoinColumn(name = "departamento",referencedColumnName = "id")
    private Departamento departamento;
}
