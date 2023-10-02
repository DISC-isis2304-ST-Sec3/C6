package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.Modelo.ExtraSala;
import uniandes.edu.co.proyecto.Modelo.Maquina_Gimnasio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface Maquina_GimnasioRepository extends JpaRepository<ExtraSala, Integer>{
     @Query(value = "SELECT * FROM Maquina_Gimnasio", nativeQuery = true)
        Collection<Maquina_Gimnasio> darMaquina_Gimnasios();

     @Query(value = "SELECT * FROM Maquina_Gimnasio WHERE Gimnasio_id = :Gimnasio_id AND Maquina_id", nativeQuery = true)
        Maquina_Gimnasio ExtrasSalas(@Param("id") int id);

    @Modifying
        @Transactional
        @Query(value = "INSERT INTO Maquina_Gimnasio (id, nombre, costo) VALUES ( proyecto_sequence.nextval , :nombre, :costo)", nativeQuery = true)
        void insertarExtraSala(@Param("nombre") String nombre, @Param("costo") Integer costo);

    @Modifying
        @Transactional
        @Query(value = "UPDATE Maquina_Gimnasio SET nombre = :nombre, costo = :costo WHERE id = :id", nativeQuery = true)
        void actualizarExtraSala(@Param("id") long id, @Param("nombre") String nombre, @Param("costo") String costo);

    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Maquina_Gimnasio WHERE id = :id", nativeQuery = true)
        void eliminarExtraSala(@Param("id") long id);

        
}