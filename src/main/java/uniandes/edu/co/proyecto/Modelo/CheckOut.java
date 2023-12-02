package uniandes.edu.co.proyecto.Modelo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("checkOut")
public class CheckOut {

    @Id
    private String id;

    private ObjectId reserva;
    private ObjectId habitacion;
    private LocalDate fechaSalida;

    public CheckOut(ObjectId reserva, ObjectId habitacion, LocalDate fechaSalida) {
        super();
        this.reserva = reserva;
        this.habitacion = habitacion;
        this.fechaSalida = fechaSalida;
    }

    public CheckOut() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectId getReserva() {
        return reserva;
    }

    public void setReserva(ObjectId reserva) {
        this.reserva = reserva;
    }

    public ObjectId getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ObjectId habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}