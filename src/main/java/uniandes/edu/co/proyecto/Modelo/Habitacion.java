package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity

@Table (name="Habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Long id;
    private String tipo_habitacion;
    private Integer costo_noche;

    @ManyToOne
    @JoinColumn(name = "hotel", referencedColumnName = "nombre")
    private Hotel hotel;
    
    public Habitacion()
    {;}

    public Habitacion(Long id, String tipo_habitacion, Integer costo_noche) {
        this.id = id;
        this.tipo_habitacion = tipo_habitacion;
        this.costo_noche = costo_noche;
    }

    public Long getIdn() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

    public Integer getCosto_noche() {
        return costo_noche;
    }

    public void setCosto_noche(Integer costo_noche) {
        this.costo_noche = costo_noche;
    }

}
