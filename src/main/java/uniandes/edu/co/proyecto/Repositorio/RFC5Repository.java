package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;

public interface RFC5Repository extends JpaRepository<Reserva_Servicio, Long>{
    @Query(value = "SELECT\r\n" + 
            "    u.login AS usuario,\r\n" + 
            "    p.nombre AS producto_nombre,\r\n" + 
            "    rfs.fecha_consumo AS fecha_consumo,\r\n" + 
            "    p.costo AS costo_producto\r\n" + 
            "FROM\r\n" + 
            "    usuarios u\r\n" + 
            "JOIN\r\n" + 
            "    reservas r ON u.id = r.Usuarios_id\r\n" + 
            "JOIN\r\n" + 
            "    reservas_servicios rfs ON r.id = rfs.reservas_id\r\n" + 
            "JOIN\r\n" + 
            "    servicios s ON rfs.servicios_id = s.id\r\n" + 
            "JOIN\r\n" + 
            "    servicios_productos sp ON s.id = sp.servicios_id\r\n" + 
            "JOIN\r\n" + 
            "    productos p ON sp.productos_id = p.id\r\n" + 
            "WHERE\r\n" + 
            "    u.login = :login -- Reemplaza con el nombre de usuario que estás buscando\r\n" + 
            "    AND r.fecha_entrada >= TO_DATE( :fechaI, 'YYYY-MM-DD')\r\n" +
            "    AND r.fecha_salida <= TO_DATE( :fechaO, 'YYYY-MM-DD')", nativeQuery = true )
            
            Collection<Object[]> darRta(@Param("fechaI") String fechaInicial, @Param("fechaO") String fechaFinal, @Param(value = "login") String login);
}

