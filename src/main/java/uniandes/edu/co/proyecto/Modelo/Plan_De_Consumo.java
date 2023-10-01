package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="plan_de_consumo")
public class Plan_De_Consumo {

    @Id
    private int id;
    
    private String nombre;
    private boolean bebida; 
    private boolean comida;

    public Plan_De_Consumo(){;}

    public Plan_De_Consumo(int id, String nombre, boolean bebida, boolean comida) {
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


