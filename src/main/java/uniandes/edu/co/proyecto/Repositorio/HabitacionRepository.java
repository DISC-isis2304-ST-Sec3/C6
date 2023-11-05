package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.Modelo.Habitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{
     @Query(value = "SELECT * FROM Habitaciones", nativeQuery = true)
        Collection<Habitacion> darHabitaciones();

     @Query(value = "SELECT * FROM Habitaciones WHERE id = :id", nativeQuery = true)
        Habitacion darHabitacion(@Param("id") int id);

    @Modifying
        @Transactional
        @Query(value = "INSERT INTO Habitaciones (id, tipo_habitacion, costo_noche) VALUES ( proyecto_sequence.nextval , :tipo_habitacion, :costo_noche, :cont_habitaciones)", nativeQuery = true)
        void insertarHabitacion(@Param("tipo_habitacion") String tipo_habitacion, @Param("costo_noche") Integer costo_noche, @Param("cont_habitaciones") Integer cont_habitaciones);

    @Modifying
        @Transactional
        @Query(value = "UPDATE Habitaciones SET tipo_habitacion = :tipo_habitacion, costo_noche = :costo_noche, cont_habitaciones WHERE id = :id", nativeQuery = true)
        void actualizarHabitacion(@Param("id") long id, @Param("tipo_habitacion") String tipo_habitacion, @Param("costo_noche") Integer costo_noche, @Param("cont_habitaciones") Integer cont_habitaciones);

    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Habitaciones WHERE id = :id", nativeQuery = true)
        void eliminarHabitacion(@Param("id") long id);

        
}