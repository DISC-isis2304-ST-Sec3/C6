package uniandes.edu.co.proyecto.Modelo;
import java.io.Serializable;

import jakarta.persistence.*;


@Embeddable
public class Servicio_ProductoPK implements Serializable{

@ManyToOne
@JoinColumn(name = "Productos_id", referencedColumnName= "id")
private Producto Productos_id;

@ManyToOne
@JoinColumn(name = "Servicios_id", referencedColumnName= "id")
private Servicio Servicios_id;

public Servicio_ProductoPK(Producto Productos_id, Servicio Servicios_id){
    super();
    this.Productos_id = Productos_id;
    this.Servicios_id = Servicios_id;
}

    public Producto getReservas() {
        return Productos_id;
    }

    public void setReservas(Reserva Reservas_id) {
        this.Productos_id = Productos_id;
    }
    public Servicio getServicios() {
        return Servicios_id;
    }

    public void SetServicios(Servicio Servicios_id) {
        this.Servicios_id = Servicios_id;
    }

    
}