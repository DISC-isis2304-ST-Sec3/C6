package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;


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
