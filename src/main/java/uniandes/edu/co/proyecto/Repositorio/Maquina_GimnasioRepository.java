package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.Modelo.ExtraSala;
import uniandes.edu.co.proyecto.Modelo.Maquina_Gimnasio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface Maquina_GimnasioRepository extends JpaRepository<ExtraSala, Long>{
     @Query(value = "SELECT * FROM Maquina_Gimnasio", nativeQuery = true)
        Collection<Maquina_Gimnasio> darMaquina_Gimnasios();

     @Query(value = "SELECT * FROM Maquina_Gimnasio WHERE Gimnasio_id = :Gimnasio_id AND Maquina_id = :Maquina_id", nativeQuery = true)
        Maquina_Gimnasio darMaquina_Gimnasio(@Param("Gimnasio_id") Integer Gimnasio_id, @Param("Maquina_id") Integer Maquina_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gustan WHERE Gimnasio_id = :Gimnasio_id AND Maquina_id = :Maquina_id", nativeQuery = true)
    void eliminarMaquinaGimnasio(@Param("Gimnasio_id") Integer Gimnasio_id, @Param("Maquina_id") Integer Maquina_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gustan SET gimnasio_id = :gimnasio_id_actualizado, maquina_id = :maquina_id_actualizado WHERE gimnasio_id = :gimnasio_id AND maquina_id = :maquina_id", nativeQuery = true)
    void actualizarMaquinaGimn(@Param("gimnasio_id") Integer gimnasio_id, @Param("maquina_id") Integer maquina_id, @Param("gimnasio_id_actualizado") Integer gimnasio_id_actualizado, @Param("maquina_id_actualizado") Integer maquina_id_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gustan (gimnasio_id, maquina_id) VALUES (:gimnasio_id, :maquina_id)", nativeQuery = true)
    void insertarMaquinaGimn(@Param("gimnasio_id") Integer gimnasio_id, @Param("maquina_id") Integer maquina_id);

        
}