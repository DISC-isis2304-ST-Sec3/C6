package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="Servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer id;
    private String nombre;
    private String Tipo_Servicio;

    public Servicio()
    {;}

    public Servicio(Integer id, String nombre, String Tipo_Servicio) {
        this.id = id;
        this.nombre = nombre;
        this.Tipo_Servicio= Tipo_Servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipoServicio() {
        return Tipo_Servicio;
    }

    public void setTipoServicio(String Tipo_Servicio) {
        this.Tipo_Servicio = Tipo_Servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
