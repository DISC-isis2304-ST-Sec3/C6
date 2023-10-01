package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity

@Table (name="Habitaciones")
public class Habitacion {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    //private TODO
}
