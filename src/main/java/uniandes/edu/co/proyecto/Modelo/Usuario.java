package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table (name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Long id;
    private String login;
    private String contraseña;
    private String nombre;
    private Integer no_documento;
    private String tipo_usuario;


    
    public Usuario()
    {;}

    public Usuario(String login, String contraseña, String nombre, Integer no_documento, String tipo_usuario) {
        this.login = login;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.no_documento = no_documento;
        this.tipo_usuario=tipo_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getcontraseña() {
        return contraseña;
    }

    public void setcontraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    
}
