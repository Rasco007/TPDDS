package Domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Usuario {
    private String login;
    private String password;
    private Perfil perfil;
    private List<Rol> roles;

}
