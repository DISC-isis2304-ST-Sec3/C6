package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")
public class Hotel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Long id;
    private String nombre;
    private String tipo;
    private int estrellas; 

    public Hotel(){;}

    public Hotel(String nombre, String tipo, int estrellas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estrellas = estrellas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    
}
