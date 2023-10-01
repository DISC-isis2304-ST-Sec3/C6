package uniandes.edu.co.proyecto.Modelo;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Gimnasio extends Servicio{
    private Integer capacidad;
    private Date horaApertura;
    private Date horaCierre;

    public Gimnasio()
    {;}

    public Gimnasio(Integer capacidad,Date horaApertura, Date horaCierre) {
        this.capacidad = capacidad;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    
    
}
