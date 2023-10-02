package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.*;


@Entity
@Table(name="Reservas")
public class Reserva_Servicio {
    @EmbeddedId
    private Reserva_ServicioPK pk;


    public Reserva_Servicio (Reserva reservas_id, Servicio servicios_id)
    {
        this.pk = new Reserva_ServicioPK(reservas_id, servicios_id);
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
