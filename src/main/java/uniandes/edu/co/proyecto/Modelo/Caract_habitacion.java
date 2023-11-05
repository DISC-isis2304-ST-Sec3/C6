package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name="caract_habitacion")
public class Caract_habitacion{

    @EmbeddedId
    private Caract_habitacionPK pk;

    public Caract_habitacion(CaracterísticasHabitaciones característicasHabitaciones_id,
    Habitacion numero_habitacion) {
        this.pk= new Caract_habitacionPK(característicasHabitaciones_id, numero_habitacion);
    }
    public Caract_habitacion(){
        ;
    }
    public Caract_habitacionPK getPk() {
        return pk;
    }
    public void setPk(Caract_habitacionPK pk) {
        this.pk = pk;
    }

    

    
}