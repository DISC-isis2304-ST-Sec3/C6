// package uniandes.edu.co.proyecto.Repositorio;
// import java.util.Collection;
// import org.springframework.data.jpa.repository.JpaRepository;
// import uniandes.edu.co.proyecto.Modelo.ExtraSala;
// import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;
// import uniandes.edu.co.proyecto.Modelo.SalaExtra;

// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.data.jpa.repository.Modifying;
// import jakarta.transaction.Transactional;

// public interface Sala_ExtraRepository extends JpaRepository<ExtraSala, Integer>{
// @Query(value = "SELECT * FROM Sala_Extra", nativeQuery = true)
//     Collection<SalaExtra> darReserva_Servicio();

//     @Query(value = "SELECT * FROM Sala_Extra WHERE reservas_id = :reservas_id AND servicios_id = :servicios_id", nativeQuery = true)
//     SalaExtra darReserva_ServiciosporId(@Param("reservas_id") Integer reservas_id, @Param("servicios_id") Integer servicios_id);

//     @Modifying
//     @Transactional
//     @Query(value = "DELETE FROM Sala_Extra WHERE reservas_id = :reservas_id AND servicios_id = :servicios_id", nativeQuery = true)
//     void eliminarReserva_Servicios(@Param("reservas_id") Integer reservas_id, @Param("servicios_id") Integer servicios_id);

//     @Modifying
//     @Transactional
//     @Query(value = "UPDATE Sala_Extra SET reservas_id = :reservas_id_actualizado, servicios_id = :servicios_id_actualizado WHERE reservas_id = :reservas_id AND servicios_id = :servicios_id", nativeQuery = true)
//     void actualizarReserva_Servicios(@Param("reservas_id") Integer reservas_id, @Param("servicios_id") Integer servicios_id, @Param("reservas_id_actualizado") Integer reservas_id_actualizado, @Param("servicios_id_actualizado") Integer servicios_id_actualizado);
    
//     @Modifying
//     @Transactional
//     @Query(value = "INSERT INTO Sala_Extra (reservas_id, servicios_id) VALUES (:reservas_id, :servicios_id)", nativeQuery = true)
//     void insertarReserva_Servicios(@Param("reservas_id") Integer reservas_id, @Param("servicios_id") Integer servicios_id);

        
// }