package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Table (name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Long id;
    private String login;
    private String contrasena;
    private String nombre;
    private Integer no_documento;
    private String tipo_usuario;

    @ManyToOne
    @JoinColumn(name = "hoteles_id", referencedColumnName = "id")
    private Hotel hoteles_id;
    public Usuario()
    {;}

    public Usuario(String login, String contrasena, String nombre,
     Integer no_documento, String tipo_usuario, Hotel hoteles_id) {
        this.login = login;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.no_documento = no_documento;
        this.tipo_usuario=tipo_usuario;
        this.hoteles_id = hoteles_id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

 

    public Hotel getHoteles_id() {
        return hoteles_id;
    }

    public void setHoteles_id(Hotel hoteles_id) {
        this.hoteles_id = hoteles_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
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
