package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.Modelo.ExtraSala;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface ExtraSalaRepository extends JpaRepository<ExtraSala, Integer>{
     @Query(value = "SELECT * FROM ExtrasSalas", nativeQuery = true)
        Collection<ExtraSala> darExtraSalas();

     @Query(value = "SELECT * FROM ExtrasSalas WHERE id = :id", nativeQuery = true)
        ExtraSala darExtrasSala(@Param("id") int id);

    @Modifying
        @Transactional
        @Query(value = "INSERT INTO ExtrasSalas (id, nombre, costo) VALUES ( proyecto_sequence.nextval , :nombre, :costo)", nativeQuery = true)
        void insertarExtraSala(@Param("nombre") String nombre, @Param("costo") Integer costo);

    @Modifying
        @Transactional
        @Query(value = "UPDATE ExtrasSalas SET nombre = :nombre, costo = :costo WHERE id = :id", nativeQuery = true)
        void actualizarExtraSala(@Param("id") long id, @Param("nombre") String nombre, @Param("costo") Integer costo);

    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM ExtrasSalas WHERE id = :id", nativeQuery = true)
        void eliminarExtraSala(@Param("id") long id);

        
}