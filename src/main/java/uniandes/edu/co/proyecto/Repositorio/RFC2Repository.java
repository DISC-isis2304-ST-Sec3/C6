package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;

public interface RFC2Repository extends JpaRepository<Reserva_Servicio, Long>{

    @Query(value = "SELECT s.nombre AS servicio, SUM(rs.cont_servicios) AS total_consumido " + 
            "FROM reservas_servicios rs " + 
            "INNER JOIN servicios s ON rs.servicios_id = s.id " + 
            "INNER JOIN reservas r ON rs.reservas_id = r.id " + 
            "WHERE r.fecha_entrada >  TO_DATE(:fechaI, 'YYYY-MM-DD') AND r.fecha_salida < TO_DATE(:fechaO,'YYYY-MM-DD')" +
            "GROUP BY s.nombre " + 
            "ORDER BY total_consumido DESC " + 
            "FETCH FIRST 20 ROWS ONLY", nativeQuery = true )
            Collection<Object[]> darRta(@Param("fechaI") String fechaInicial, @Param("fechaO") String fechaFinal);

                    

}
