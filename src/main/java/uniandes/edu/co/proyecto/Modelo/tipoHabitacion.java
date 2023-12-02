package uniandes.edu.co.proyecto.Modelo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tipoHabitacion")
public class tipoHabitacion {

    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private String tipo;

    public tipoHabitacion(String id, String nombre, String descripcion, String tipo) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public tipoHabitacion() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}