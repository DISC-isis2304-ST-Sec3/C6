package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.Modelo.Reserva;

public interface RFC1Repository extends JpaRepository<Reserva, Long>{


    //MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN EN EL ÚLTIMO AÑO CORRIDO


    @Query(value = "SELECT\r\n" + 
                    "    h.id AS habitacion_id,\r\n" + 
                    "    SUM(s.precio) AS dinero_recolectado\r\n" + 
                    "FROM\r\n" + 
                    "    habitaciones h\r\n" + 
                    "JOIN\r\n" + 
                    "    reservas r ON h.id = r.habitaciones_id\r\n" + 
                    "JOIN\r\n" + 
                    "    reservas_servicios rs ON r.id = rs.reservas_id\r\n" + 
                    "JOIN\r\n" + 
                    "    servicios s ON rs.servicios_id = s.id\r\n" + 
                    "WHERE\r\n" + 
                    "    r.fecha_entrada >= SYSDATE - 365\r\n" + 
                    "GROUP BY\r\n" + 
                    "    h.id\r\n" + 
                    "ORDER BY\r\n" + 
                    "    h.id"
                    , nativeQuery = true )
                    Collection<Object[]> darConsumos();

                    
}