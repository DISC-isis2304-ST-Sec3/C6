package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;

public interface RFC3Repositoy extends JpaRepository<Reserva_Servicio, Long>{
    @Query(value = "select id, round(cont_habitaciones*100/ :Dia, 2) as resultado_multiplicacion\r\n" +
            "from habitaciones", nativeQuery = true )
            Collection<Object[]> darRta(@Param("Dia")Integer diaActual);
}
