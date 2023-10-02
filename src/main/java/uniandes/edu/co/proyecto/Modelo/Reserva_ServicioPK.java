package uniandes.edu.co.proyecto.Modelo;
import java.io.Serializable;

import jakarta.persistence.*;


@Embeddable
public class Reserva_ServicioPK implements Serializable{

@ManyToOne
@JoinColumn(name = "Reservas_id", referencedColumnName= "id")
private Reserva Reservas_id;

@ManyToOne
@JoinColumn(name = "Servicios_id", referencedColumnName= "id")
private Servicio Servicios_id;

public Reserva_ServicioPK(Reserva Reservas_id, Servicio Servicios_id){
    super();
    this.Reservas_id = Reservas_id;
    this.Servicios_id = Servicios_id;
}

    public Reserva getReservas() {
        return Reservas_id;
    }

    public void setReservas(Reserva Reservas_id) {
        this.Reservas_id = Reservas_id;
    }
    public Servicio getServicios() {
        return Servicios_id;
    }

    public void SetServicios(Servicio Servicios_id) {
        this.Servicios_id = Servicios_id;
    }

    
}