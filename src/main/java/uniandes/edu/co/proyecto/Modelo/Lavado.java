package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Lavado extends Servicio{
    private String tipoPrenda;
    private Integer numeroPrendas;

    public Lavado()
    {;}

    public Lavado(String tipoPrenda, Integer numeroPrendas) {
        this.tipoPrenda = tipoPrenda;
        this.numeroPrendas = numeroPrendas;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public Integer getNumeroPrendas() {
        return numeroPrendas;
    }

    public void setNumeroPrendas(Integer numeroPrendas) {
        this.numeroPrendas = numeroPrendas;
    }
}
