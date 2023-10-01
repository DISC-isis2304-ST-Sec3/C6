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

@Table (name="Habitaciones")
public class Habitacion {
    @Id
    private Integer numero_habitacion;
    private String tipo_habitacion;
    private Integer costo_noche;

    public Habitacion()
    {;}

    public Habitacion(Integer numero_habitacion, String tipo_habitacion, Integer costo_noche) {
        this.numero_habitacion = numero_habitacion;
        this.tipo_habitacion = tipo_habitacion;
        this.costo_noche = costo_noche;
    }

    public Integer getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(Integer numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
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
