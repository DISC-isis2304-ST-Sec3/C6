package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CaracterísticasHabitaciones")
public class CaracterísticasHabitaciones {
        @Id
        private int id;
        
        private String nombre;
    
        public CaracterísticasHabitaciones(){;}

        public CaracterísticasHabitaciones(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        
}