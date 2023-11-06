package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;

public interface RFC2Repository extends JpaRepository<Reserva_Servicio, Long>{

    @Query(value = "--Requerimeinto 2\r\n" + 
            "SELECT s.nombre AS servicio, SUM(rs.cont_servicios) AS total_consumido\r\n" + 
            "FROM reservas_servicios rs\r\n" + 
            "INNER JOIN servicios s ON rs.servicios_id = s.id\r\n" + 
            "INNER JOIN reservas r ON rs.reservas_id = r.id\r\n" + 
            "WHERE r.fecha_entrada > :fechaI AND r.fecha_salida < :fechaO\r\\n" + //
                    " " + 
            "GROUP BY s.nombre\r\n" + 
            "ORDER BY total_consumido DESC\r\n" + 
            "FETCH FIRST 20 ROWS ONLY", nativeQuery = true )
            Collection<Object[]> darRta(@Param("fechaI") String fechaInicial, @Param("fechaO") String fechaFinal);

                    

}
