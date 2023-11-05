package uniandes.edu.co.proyecto.Modelo;
import java.sql.Date;

import jakarta.persistence.*;


@Entity
@Table(name="reservas_servicios")
public class Reserva_Servicio {
    @EmbeddedId
    private Reserva_ServicioPK pk;
    private static Date fecha_consumo;
    private Integer cont_servicios;


    public Reserva_Servicio (Reserva reservas_id, Servicio servicios_id, Date fecha_consumo,
    Integer cont_servicios)
    {
        this.pk = new Reserva_ServicioPK(reservas_id, servicios_id);
        this.fecha_consumo= fecha_consumo;
        this.cont_servicios= cont_servicios; // Contador de reservas por fecha
    }

    public Integer getCont_servicios() {
        return cont_servicios;
    }

    public void setCont_servicios(Integer cont_servicios) {
        this.cont_servicios = cont_servicios;
    }

    public Reserva_Servicio()
    {;}
    public Reserva_ServicioPK getReservas_Servicios() {
        return pk;
    }

    public void SetSReservas_Servicios(Reserva_ServicioPK pk) {
        this.pk = pk;
    }

    public static Date getFecha_consumo() {
        return fecha_consumo;
    }

    public void setFecha_consumo(Date fecha_consumo) {
        this.fecha_consumo = fecha_consumo;
    }
    
    
}
