package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Table;
@Document("Plan_De_Consumo")

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


    public String getNombre() {
        return nombre;
    }

    public boolean isBebida() {
        return bebida;
    }

    public boolean isComida() {
        return comida;
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


