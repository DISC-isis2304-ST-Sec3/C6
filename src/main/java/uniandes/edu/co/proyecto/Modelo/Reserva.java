package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name="Reservas")
public class Reserva {
    
    private Integer numero_personas;
    private Integer id;
    private Date fecha_entrada;
}
