package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Caract_habitacionPK implements Serializable{

    @ManyToOne
    @JoinColumn(name="CaracterísticasHabitaciones_id", referencedColumnName="id")
    private CaracterísticasHabitaciones CaracterísticasHabitaciones_id;

    @ManyToOne
    @JoinColumn(name="numero_habitacion", referencedColumnName="id")
    private Habitacion numero_habitacion;

    public Caract_habitacionPK(CaracterísticasHabitaciones característicasHabitaciones_id,
            Habitacion numero_habitacion) {
        super();
        this.CaracterísticasHabitaciones_id = característicasHabitaciones_id;
        this.numero_habitacion = numero_habitacion;
    }

    public CaracterísticasHabitaciones getCaracterísticasHabitaciones_id() {
        return CaracterísticasHabitaciones_id;
    }

    public void setCaracterísticasHabitaciones_id(CaracterísticasHabitaciones característicasHabitaciones_id) {
        this.CaracterísticasHabitaciones_id = característicasHabitaciones_id;
    }

    public Habitacion getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(Habitacion numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    
    
    
}
