package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.Modelo.Caract_habitacion;
import uniandes.edu.co.proyecto.Modelo.ExtraSala;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface Caract_habitacionRepository extends JpaRepository<ExtraSala, Integer>{
    
    @Query(value = "SELECT * FROM Caract_habitacion", nativeQuery = true)
    Collection<Caract_habitacion> darServicio_Producto();

    @Query(value = "SELECT * FROM Caract_habitacion WHERE característicashabitaciones_id = :característicashabitaciones_id AND numero_habitacion = :numero_habitacion", nativeQuery = true)
    Caract_habitacion darCaract_habitacionPorId(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("numero_habitacion") Integer numero_habitacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Caract_habitacion WHERE característicashabitaciones_id = :característicashabitaciones_id AND numero_habitacion = :numero_habitacion", nativeQuery = true)
    void eliminarCaract_habitacion(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("numero_habitacion") Integer numero_habitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Caract_habitacion SET característicashabitaciones_id = :característicashabitaciones_id_actualizado, numero_habitacion = :numero_habitacion_actualizado WHERE característicashabitaciones_id = :característicashabitaciones_id AND numero_habitacion = :numero_habitacion", nativeQuery = true)
    void actualizarCaract_habitacion(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("numero_habitacion") Integer numero_habitacion, @Param("característicashabitaciones_id_actualizado") Integer característicashabitaciones_id_actualizado, @Param("numero_habitacion_actualizado") Integer numero_habitacion_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Caract_habitacion (característicashabitaciones_id, numero_habitacion) VALUES (:característicashabitaciones_id, :numero_habitacion)", nativeQuery = true)
    void insertarCaract_habitacion(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("numero_habitacion") Integer numero_habitacion);

        
}