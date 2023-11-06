package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Long id;
    private String nombre;
    private String Tipo_Servicio;
    private Integer precio;
    public Servicio()
    {;}

    public Servicio(Long id, String nombre, String Tipo_Servicio, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.Tipo_Servicio= Tipo_Servicio;
        this.precio= precio;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
