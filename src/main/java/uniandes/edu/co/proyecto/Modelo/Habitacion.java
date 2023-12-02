package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Habitacion")
public class Habitacion {
    @Id
    private String id;
    private Integer costo_noche;
    private Integer cont_habitaciones;//Contador 
    private List<tipoHabitacion> tipoHabitacion;
    

    public Habitacion(String id, Integer costo_noche, Integer cont_habitaciones, List<tipoHabitacion> tipoHabitacion) {
        this.id = id;
        this.costo_noche = costo_noche;
        this.cont_habitaciones = cont_habitaciones;
        this.tipoHabitacion = tipoHabitacion; 
    }

    
    public Integer getCont_habitaciones() {
        return cont_habitaciones;
    }

    public void setCont_habitaciones(Integer cont_habitaciones) {
        this.cont_habitaciones = cont_habitaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<tipoHabitacion> getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(List<tipoHabitacion> tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Integer getCosto_noche() {
        return costo_noche;
    }

    public void setCosto_noche(Integer costo_noche) {
        this.costo_noche = costo_noche;
    }

}
