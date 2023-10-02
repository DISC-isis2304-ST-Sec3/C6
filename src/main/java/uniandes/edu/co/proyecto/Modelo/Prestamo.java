package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;


@Entity
public class Prestamo extends Servicio{
    
    private Boolean estado;

    public Prestamo()
    {;}

    public Prestamo( Boolean estado) {
        super();
       this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
