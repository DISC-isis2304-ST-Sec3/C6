package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;


@Entity
public class Wifi extends Servicio {
    private Integer capacidad;
    private Integer costo_por_dia;

    public Wifi()
    {;}

    public Wifi(Integer capacidad, Integer costo_por_dia) {
        this.capacidad = capacidad;
        this.costo_por_dia = costo_por_dia;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCosto_por_dia() {
        return costo_por_dia;
    }

    public void setCosto_por_dia(Integer costo_por_dia) {
        this.costo_por_dia = costo_por_dia;
    }
    

    
}
