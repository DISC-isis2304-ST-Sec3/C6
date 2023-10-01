package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;


@Entity
public class Restaurante extends Servicio{
    private Integer capacidad;
    private String estilo;

    public Restaurante()
    {;}

    public Restaurante(Integer capacidad, String estilo) {
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    
}
