package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.Modelo.Reserva;


public interface RFC7Repository extends JpaRepository <Reserva, Long>{
    
    @Query(value = "SELECT consumo.usuario_id, consumo.usuario_login, estadia.total_dias_estadia, total_consumido\r\n" + //
            "FROM (\r\n" + 
            "    -- Resultado del cálculo de consumo\r\n" + 
            "    SELECT u.id AS usuario_id, u.login AS usuario_login, SUM(r.costo_total) AS total_consumido\r\n" + 
            "    FROM usuarios u\r\n" + 
            "    JOIN reservas r ON u.id = r.usuarios_id\r\n" + 
            "    WHERE r.fecha_entrada >= TO_DATE(SYSDATE - 365, 'DD/MM/YYYY')\r\n" + 
            "    GROUP BY u.id, u.login\r\n" + 
            "    HAVING SUM(r.costo_total) > 150000\r\n" + 
            ") consumo\r\n" + 
            "JOIN (\r\n" + 
            "    -- Resultado del cálculo de duración de estadía\r\n" + 
            "    SELECT u.id AS usuario_id, u.login AS usuario_login, SUM(ABS(r.fecha_salida - r.fecha_entrada)) AS total_dias_estadia\r\n" + 
            "    FROM usuarios u\r\n" + 
            "    JOIN reservas r ON u.id = r.usuarios_id\r\n" + 
            "    WHERE r.fecha_entrada >= TO_DATE(SYSDATE - 365, 'DD/MM/YYYY') and r.fecha_entrada <= (SELECT CURRENT_DATE from dual)\r\n" + 
            "    GROUP BY u.id, u.login\r\n" + 
            "    HAVING SUM(ABS(r.fecha_salida - r.fecha_entrada)) >= 14\r\n" + 
            ") estadia\r\n" + 
            "ON consumo.usuario_id = estadia.usuario_id\r\n" + 
            "", nativeQuery = true )
            Collection<Object[]> darRta();
}
