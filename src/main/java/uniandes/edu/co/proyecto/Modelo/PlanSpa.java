package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="PlanesSpa")
public class PlanSpa {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer duracion;
	private Integer costo;

    public PlanSpa(Long id,Integer duracion, Integer costo) {
        this.id = id;
        this.duracion = duracion;
        this.costo = costo;
    }

    public PlanSpa()
    {;}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public Integer getCosto() {
        return costo;
    }
    public void setCosto(Integer costo) {
        this.costo = costo;
    }


}