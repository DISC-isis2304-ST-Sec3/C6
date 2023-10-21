package uniandes.edu.co.proyecto.Repositorio;
import uniandes.edu.co.proyecto.Modelo.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;


public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
     @Query(value = "SELECT * FROM Reservas", nativeQuery = true)
        Collection<Reserva> darReservas();

     @Query(value = "SELECT * FROM Reservas WHERE id = :id", nativeQuery = true)
        Reserva darReserva(@Param("id") Integer id);

    @Modifying
        @Transactional
        @Query(value = "INSERT INTO Reservas (id, numero_personas,fecha_entrada,fecha_salida,costo_total,check_in,check_out) VALUES ( proyecto_sequence.nextval , :numero_personas, :fecha_entrada, :fecha_salida, :costo_total, :check_in, :check_out)", nativeQuery = true)
        void insertarReserva(@Param("numero_personas") Integer numero_personas, @Param("fecha_entrada") Date fecha_entrada, @Param("fecha_salida") Date fecha_salida, @Param("costo_total") Integer costo_total, @Param("check_in") Boolean check_in, @Param("check_out") Boolean check_out);

    @Modifying
        @Transactional
        @Query(value = "UPDATE Reservas SET numero_personas = :numero_personas, fecha_entrada = :fecha_entrada, fecha_salida=:fecha_salida, costo_total=:costo_total, check_in=:check_in,check_out= :check_out WHERE id = :id" , nativeQuery = true)
        void actualizarReserva(@Param("id") long id,@Param("numero_personas") Integer numero_personas,@Param("fecha_entrada") Date fecha_entrada, @Param("fecha_salida") Date fecha_salida, @Param("costo_total") Integer costo_total, @Param("check_in") Boolean check_in, @Param("check_out") Boolean check_out);
    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Reservas WHERE id = :id", nativeQuery = true)
        void eliminarReserva(@Param("id") long id);
}