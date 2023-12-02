package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.Entity;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;import jakarta.persistence.Table;

@Document("CaracterísticasHabitaciones")

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