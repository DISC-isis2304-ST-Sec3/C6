package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;


@Entity
public class Lavado extends Servicio{
    private String tipoPrenda;
    private Integer numeroPrendas;

    public Lavado()
    {;}

    public Lavado(String tipoPrenda, Integer numeroPrendas) {
        super();
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
