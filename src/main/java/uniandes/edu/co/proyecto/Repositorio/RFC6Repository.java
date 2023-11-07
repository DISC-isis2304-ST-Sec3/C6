package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.Modelo.Reserva;

public interface RFC6Repository extends JpaRepository<Reserva, Long>{


    //Primera parte


    @Query(value = "WITH OcupacionDiaria AS (\r\n" +
        "SELECT\r\n" +
            "fecha_entrada AS fecha_reserva,\r\n" +
            "COUNT(DISTINCT habitaciones_id) AS habitaciones_ocupadas\r\n" +
        "FROM\r\n" +
            "reservas\r\n" +
        "WHERE\r\n" +
            "check_in = 1 -- Asegúrate de que solo estás considerando reservas con check-in confirmado\r\n" +
            "AND fecha_entrada BETWEEN (SELECT MIN(fecha_entrada) FROM reservas) AND (SELECT MAX(fecha_salida) FROM reservas)\r\n" +
        "GROUP BY\r\n" +
            "fecha_entrada\r\n" +
        ")\r\n" +
        "SELECT\r\n" +
            "fecha_reserva, habitaciones_ocupadas\r\n" +
        "FROM\r\n" +
            "OcupacionDiaria\r\n" +
        "ORDER BY\r\n" +
            "habitaciones_ocupadas DESC\r\n" +
        "FETCH FIRST 50 ROWS ONLY"
                    , nativeQuery = true )
                    Collection<Object[]> darPrimeraParte();



    @Query(value = "WITH IngresosDiarios AS (\r\n" +
        "SELECT\r\n" +
            "fecha_consumo AS fecha,\r\n" +
            "SUM(cont_servicios) AS total_ingresos\r\n" +
        "FROM\r\n" +
            "reservas_servicios\r\n" +
        "GROUP BY\r\n" +
            "fecha_consumo\r\n" +
    ")\r\n" +
    "SELECT\r\n" +
        "fecha, total_ingresos\r\n" +
    "FROM\r\n" +
        "IngresosDiarios\r\n" +
    "ORDER BY\r\n" +
        "total_ingresos DESC"
                    , nativeQuery = true )
                    Collection<Object[]> darSegundaParte();



    
    @Query(value = "WITH OcupacionDiaria AS (\r\n" +
        "SELECT\r\n" +
            "fecha_entrada AS fecha_reserva,\r\n" +
            "COUNT(DISTINCT habitaciones_id) AS habitaciones_ocupadas\r\n" +
        "FROM\r\n" +
            "reservas\r\n" +
        "WHERE\r\n" +
            "check_in = 1 -- Asegúrate de que solo estás considerando reservas con check-in confirmado\r\n" +
            "AND fecha_entrada BETWEEN (SELECT MIN(fecha_entrada) FROM reservas) AND (SELECT MAX(fecha_salida) FROM reservas)\r\n" +
        "GROUP BY\r\n" +
            "fecha_entrada\r\n" +
        ")\r\n" +
        "SELECT\r\n" +
            "fecha_reserva, habitaciones_ocupadas\r\n" +
        "FROM\r\n" +
            "OcupacionDiaria\r\n" +
        "ORDER BY\r\n" +
            "habitaciones_ocupadas ASC\r\n" +
        "FETCH FIRST 50 ROWS ONLY"
                    , nativeQuery = true )
                    Collection<Object[]> darTerceraParte();

                    
}