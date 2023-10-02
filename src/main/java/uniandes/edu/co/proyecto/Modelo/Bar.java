package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;


@Entity
public class Bar extends Servicio{
    private Integer capacidad;
    private String estilo;

    public Bar()
    {;}

    public Bar(Integer capacidad, String estilo) {
        super();
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
