package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="productos")
public class Producto {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String nombre;
    private Integer costo;
    private String tipo;
    public Producto(String nombre, Integer costo, String tipo) {
        this.nombre = nombre;
        this.costo = costo;
        this.tipo =tipo;
    }

    public Producto()
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
