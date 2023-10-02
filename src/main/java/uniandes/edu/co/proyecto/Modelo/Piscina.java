package uniandes.edu.co.proyecto.Modelo;
import java.util.Date;
import jakarta.persistence.Entity;


@Entity
public class Piscina extends Servicio{
    private Integer capacidad;
    private Integer profundidad;
    private Date horaApertura;
    private Date horaCierre;

    public Piscina()
    {;}

    public Piscina(Integer capacidad,Integer profundidad, Date horaApertura, Date horaCierre) {
        super();
       
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
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
