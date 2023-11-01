package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.Modelo.ExtraSala;
import uniandes.edu.co.proyecto.Modelo.Reserva;
import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;
import uniandes.edu.co.proyecto.Modelo.Servicio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface Reserva_ServiciosRepository extends JpaRepository<ExtraSala, Integer>{
@Query(value = "SELECT * FROM Reserva_Servicio", nativeQuery = true)
    Collection<Reserva_Servicio> darReserva_Servicio();

    @Query(value = "SELECT * FROM Reserva_Servicio WHERE reservas_id = :reservas_id AND servicios_id = :servicios_id", nativeQuery = true)
    Reserva_Servicio darReserva_ServiciosporId(@Param("reservas_id") Integer reservas_id, @Param("servicios_id") Integer servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Reserva_Servicio WHERE reservas_id = :reservas_id AND servicios_id = :servicios_id", nativeQuery = true)
    void eliminarReserva_Servicios(@Param("reservas_id") Integer reservas_id, @Param("servicios_id") Integer servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Reserva_Servicio SET reservas_id = :reservas_id_actualizado, servicios_id = :servicios_id_actualizado WHERE reservas_id = :reservas_id AND servicios_id = :servicios_id", nativeQuery = true)
    void actualizarReserva_Servicios(@Param("reservas_id") Integer reservas_id, @Param("servicios_id") Integer servicios_id, @Param("reservas_id_actualizado") Integer reservas_id_actualizado, @Param("servicios_id_actualizado") Integer servicios_id_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Reserva_Servicio (reservas_id, servicios_id) VALUES (:reservas_id, :servicios_id)", nativeQuery = true)
    void insertarReserva_Servicios(@Param("reservas_id") Reserva reserva, @Param("servicios_id") Servicio servicio);

        
}