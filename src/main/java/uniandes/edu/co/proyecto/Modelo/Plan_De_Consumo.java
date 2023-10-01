package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Plan_De_Consumo {
@Entity
@Table(name="hoteles")
public class Hotel {
    @Id
    private int id;
    
    private String nombre;
    private boolean bebida; 
    private boolean comida;

    public Hotel(){;}

    public Hotel(int id, String nombre, boolean bebida, boolean comida) {
        this.id = id;
        this.nombre = nombre;
        this.bebida = bebida;
        this.comida = comida;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isBebida() {
        return bebida;
    }

    public boolean isComida() {
        return comida;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBebida(boolean bebida) {
        this.bebida = bebida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }
    

    
}


}
