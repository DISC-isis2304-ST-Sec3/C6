package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;


@Entity
public class Sala extends Servicio{
    private Integer capacidad;
    private Integer costoPorHora;
    private String tipo;
    
    public Sala()
    {;}

    public Sala( Integer capacidad,Integer costoPorHora, String tipo) {
        this.capacidad = capacidad;
        this.costoPorHora = costoPorHora;
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(Integer costoPorHora) {
        this.costoPorHora = costoPorHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    
    
}
