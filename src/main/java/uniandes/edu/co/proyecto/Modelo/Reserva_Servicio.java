package uniandes.edu.co.proyecto.Modelo;
import java.sql.Date;

import jakarta.persistence.*;


@Entity
@Table(name="reservas_servicios")
public class Reserva_Servicio {
    @EmbeddedId
    private Reserva_ServicioPK pk;
    public Reserva_Servicio (Reserva reservas_id, Servicio servicios_id, Date fecha_consumo,
    Integer cont_servicios)
    {
        this.pk = new Reserva_ServicioPK(reservas_id, servicios_id, fecha_consumo, cont_servicios);
    }



    public Reserva_Servicio()
    {;}
    public Reserva_ServicioPK getReservas_Servicios() {
        return pk;
    }

    public void SetSReservas_Servicios(Reserva_ServicioPK pk) {
        this.pk = pk;
    }


    
    
}
