package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.Modelo.ExtraSala;
import uniandes.edu.co.proyecto.Modelo.Servicio_Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface Servicio_ProductoRepository extends JpaRepository<ExtraSala, Long>{
    
    @Query(value = "SELECT * FROM Servicio_Producto", nativeQuery = true)
    Collection<Servicio_Producto> darServicio_Producto();

    @Query(value = "SELECT * FROM Servicio_Producto WHERE característicashabitaciones_id = :característicashabitaciones_id AND servicios_id = :servicios_id", nativeQuery = true)
    Servicio_Producto darGustanPorId(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("servicios_id") Integer servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicio_Producto WHERE característicashabitaciones_id = :característicashabitaciones_id AND servicios_id = :servicios_id", nativeQuery = true)
    void eliminarServicio_Producto(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("servicios_id") Integer servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Servicio_Producto SET característicashabitaciones_id = :característicashabitaciones_id_actualizado, servicios_id = :servicios_id_actualizado WHERE característicashabitaciones_id = :característicashabitaciones_id AND servicios_id = :servicios_id", nativeQuery = true)
    void actualizarServicio_Producto(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("servicios_id") Integer servicios_id, @Param("característicashabitaciones_id_actualizado") Integer característicashabitaciones_id_actualizado, @Param("servicios_id_actualizado") Integer servicios_id_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicio_Producto (característicashabitaciones_id, servicios_id) VALUES (:característicashabitaciones_id, :servicios_id)", nativeQuery = true)
    void insertarServicio_Producto(@Param("característicashabitaciones_id") Integer característicashabitaciones_id, @Param("servicios_id") Integer servicios_id);

        
}