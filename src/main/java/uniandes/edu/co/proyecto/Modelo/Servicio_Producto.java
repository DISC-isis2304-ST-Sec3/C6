package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.*;


@Entity
@Table(name="Servicios_Productos")
public class Servicio_Producto {
    @EmbeddedId
    private Servicio_ProductoPK pk;


    public Servicio_Producto (Producto Productos_id, Servicio servicios_id)
    {
        this.pk = new Servicio_ProductoPK(Productos_id, servicios_id);
    }

    public Servicio_Producto()
    {;}
    public Servicio_ProductoPK getServicio_Producto() {
        return pk;
    }

    public void SetSServicio_Producto(Servicio_ProductoPK pk) {
        this.pk = pk;
    }

    
}