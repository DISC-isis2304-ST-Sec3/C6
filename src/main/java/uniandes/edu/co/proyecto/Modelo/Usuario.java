package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table (name="Usuarios")
public class Usuario {

    @Id
    private String login;
    private String contrasena;
    private String nombre;
    private Integer no_documento;

    public Usuario()
    {;}

    public Usuario(String login, String contrasena, String nombre, Integer no_documento) {
        this.login = login;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.no_documento = no_documento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNo_documento() {
        return no_documento;
    }

    public void setNo_documento(Integer no_documento) {
        this.no_documento = no_documento;
    }
    
}
