package uniandes.edu.co.proyecto.Modelo;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReservaSpa extends Spa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "spa", referencedColumnName = "id")
    private Sala sala;


    public ReservaSpa()
    {;}

    public ReservaSpa( Long id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
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
    
    
}
