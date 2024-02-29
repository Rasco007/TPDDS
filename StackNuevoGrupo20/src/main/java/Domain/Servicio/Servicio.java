package Domain.Servicio;

import Domain.Entidades.Establecimiento;
import Domain.Personas.Usuario;
import Domain.Servicio.Estados.Estado_Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Servicio {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)//esto me lo rito chatgpt
  private int id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "estado",referencedColumnName = "id")
  private Estado_Servicio estado_servicio;
  @Column(columnDefinition = "varchar(100)")
  private String descripcion;
  @ManyToMany
  @JoinTable(name = "usuario_servicio",joinColumns = @JoinColumn(name = "servicio",referencedColumnName = "id")
                    ,inverseJoinColumns = @JoinColumn(name = "usuario",referencedColumnName = "id"))
  private List<Usuario> usuarios_asociados;
  @ManyToOne
  @JoinColumn(name = "establecimiento_id",referencedColumnName = "id")
  private Establecimiento establecimiento;

  //persistencia
  @ManyToOne
  @JoinColumn(name="pertenece_a",referencedColumnName = "id")
  private Servicio_Compuesto pertenece_a;
}
