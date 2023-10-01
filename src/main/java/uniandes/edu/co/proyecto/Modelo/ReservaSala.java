package uniandes.edu.co.proyecto.Modelo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReservaSala extends Sala{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Date fecha;
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "sala", referencedColumnName = "id")
    private Sala sala;
    public ReservaSala()
    {;}

    public ReservaSala( Long id, Date fecha, Integer duracion) {
        this.id = id;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
}