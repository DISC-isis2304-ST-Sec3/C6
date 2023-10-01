package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="ExtraSalas")
public class ExtraSala {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
	private Integer costo;

    public ExtraSala(Long id,String nombre, Integer costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public ExtraSala()
    {;}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCosto() {
        return costo;
    }
    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}