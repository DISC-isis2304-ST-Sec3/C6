package uniandes.edu.co.proyecto.Modelo;
import java.sql.Date;
import jakarta.persistence.*;


@Entity
@Table(name="Reservas")
public class Reservas_Servicios {
    @EmbeddedId
    private Reservas_ServiciosPK pk;


    public Reservas_Servicios (Reserva reservas_id, Servicio servicios_id)
    {
        this.pk = new Reservas_ServiciosPK(reservas_id, servicios_id);
    }

    public Reservas_Servicios()
    {;}
    public Reservas_ServiciosPK getReservas_Servicios() {
        return pk;
    }

    public void SetSReservas_Servicios(Reservas_ServiciosPK pk) {
        this.pk = pk;
    }

    
}
