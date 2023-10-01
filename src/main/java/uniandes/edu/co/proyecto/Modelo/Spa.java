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
public class Spa extends Servicio{
    private Integer capacidad;
    
    public Spa()
    {;}

    public Spa( Integer capacidad) {
        this.capacidad = capacidad;
    }


    public Integer getTCapacidad() {
        return capacidad;
    }

    public void setTipo(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
