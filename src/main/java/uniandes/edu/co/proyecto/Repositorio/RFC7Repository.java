package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelo.Reserva;


public interface RFC7Repository extends JpaRepository <Reserva, Long>{
    
    @Query(value = "SELECT u.login AS usuario,\r\n" + 
            "       r.Usuarios_id AS usuario_id,\r\n" + 
            "       SUM(rs.cont_servicios * s.precio) AS consumo_total,\r\n" + 
            "       SUM(r.fecha_salida - r.fecha_entrada) AS total_dias_en_hotel\r\n" + 
            "FROM reservas r\r\n" + 
            "INNER JOIN usuarios u ON r.Usuarios_id = u.id\r\n" + 
            "LEFT JOIN reservas_servicios rs ON r.id = rs.reservas_id\r\n" + 
            "LEFT JOIN servicios s ON rs.servicios_id = s.id\r\n" + 
            "WHERE r.fecha_entrada >= TO_DATE(SYSDATE - 365, 'YYYY-MM-DD')  -- Filtrar reservas del último año\r\n" + 
            "GROUP BY u.login, r.Usuarios_id\r\n" + 
            "HAVING SUM(r.fecha_salida - r.fecha_entrada) >= 14 OR \r\n" + 
            "       SUM(rs.cont_servicios * s.precio) > 150000\r\n" + 
            "", nativeQuery = true )
            Collection<Object[]> darRta();
}
