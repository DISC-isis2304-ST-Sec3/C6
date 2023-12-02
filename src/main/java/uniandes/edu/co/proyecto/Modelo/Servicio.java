package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Servicio")

public class Servicio {
    @Id
    private String id;
    private String Nombre;
    private String Tipo_Servicio;
    private Integer Precio;
    @DBRef
    private Hotel Hotel_Id;



    public Servicio()
    {;}

    public Servicio(String id, String Nombre, String Tipo_Servicio, Integer Precio, Hotel Hotel_Id) {
        this.id = id;
        this.Nombre = Nombre;
        this.Tipo_Servicio= Tipo_Servicio;
        this.Precio= Precio;
        this.Hotel_Id = Hotel_Id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTipoServicio() {
        return Tipo_Servicio;
    }

    public void setTipoServicio(String Tipo_Servicio) {
        this.Tipo_Servicio = Tipo_Servicio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = Nombre;
    }
    
    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer Precio) {
        this.Precio = Precio;
    }
}
