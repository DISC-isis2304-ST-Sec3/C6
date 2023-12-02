package uniandes.edu.co.proyecto.Modelo;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("hoteles")
public class Hotel {
    @Id
    private Long Hotel_Id;
    private String nombre;
    private String tipo;
    private int estrellas; 


    public Hotel(String nombre, String tipo, int estrellas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estrellas = estrellas;
    }
   public Hotel() {
        super();
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
