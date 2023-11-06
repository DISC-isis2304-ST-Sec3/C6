package uniandes.edu.co.proyecto.Modelo;
import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;


@Embeddable
public class Reserva_ServicioPK implements Serializable{

@ManyToOne
@JoinColumn(name = "reservas_id", referencedColumnName= "id")
private Reserva Reservas_id;

@ManyToOne
@JoinColumn(name = "servicios_id", referencedColumnName= "id")
private Servicio Servicios_id;

private Date fecha_consumo;

private Integer cont_servicios;



public Reserva_ServicioPK(Reserva Reservas_id, Servicio Servicios_id,Date fecha_consumo,Integer cont_servicios ){
    super();
    this.Reservas_id = Reservas_id;
    this.Servicios_id = Servicios_id;
    this.fecha_consumo = fecha_consumo;
    this.cont_servicios = cont_servicios;
}

    public Reserva getReservas_id() {
    return Reservas_id;
}

public void setReservas_id(Reserva reservas_id) {
    Reservas_id = reservas_id;
}

public Servicio getServicios_id() {
    return Servicios_id;
}

public void setServicios_id(Servicio servicios_id) {
    Servicios_id = servicios_id;
}

public Date getFecha_consumo() {
    return fecha_consumo;
}

public void setFecha_consumo(Date fecha_consumo) {
    this.fecha_consumo = fecha_consumo;
}

public Integer getCont_servicios() {
    return cont_servicios;
}

public void setCont_servicios(Integer cont_servicios) {
    this.cont_servicios = cont_servicios;
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