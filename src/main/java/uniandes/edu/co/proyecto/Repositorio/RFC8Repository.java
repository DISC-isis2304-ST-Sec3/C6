package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelo.Reserva;

public interface RFC8Repository  extends JpaRepository <Reserva, Long>{

    @Query(value = "SELECT s.nombre AS nombre_del_servicio, COUNT(rs.reservas_id) AS cantidad_de_solicitudes\r\n" + 
            "FROM servicios s\r\n" + 
            "LEFT JOIN reservas_servicios rs ON s.id = rs.servicios_id\r\n" + 
            "LEFT JOIN reservas r ON rs.reservas_id = r.id\r\n" + 
            "WHERE r.fecha_entrada >= (SYSDATE - 365) -- Último año de operación\r\n" + 
            "GROUP BY s.nombre\r\n" + 
            "HAVING COUNT(rs.reservas_id) < 3\r\n" + 
            "ORDER BY cantidad_de_solicitudes\r\n" + 
            "", nativeQuery = true )
    Collection<Object[]> darRta();

    
}
