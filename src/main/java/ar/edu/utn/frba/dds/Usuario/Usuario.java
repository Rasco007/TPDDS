package ar.edu.utn.frba.dds.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class Usuario {
    private String login;
    private String password;
    private Perfil perfil;
    private List<Rol> roles;

}
