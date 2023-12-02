package uniandes.edu.co.proyecto.Repositorio;
import uniandes.edu.co.proyecto.Modelo.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
   import org.springframework.data.jpa.repository.Modifying; // Add this import statement

   import jakarta.transaction.Transactional; // Add this import statement
   public interface ReservaRepository extends MongoRepository<Reserva, String> {
      
      //CREATE
      Reserva save(Reserva reserva);
      
      // READ
      @Query("{}")
      List<Reserva> findAllReservaes();
      
      @Query(value = "{ id : ?0 }")
      Reserva findByTipo(String id);

      // DELETE
      @Modifying
      @Query(value = "{ 'id' : ?0 }")
      void deleteById(String id);

      //UPDATE
      @Modifying
      @Query(value = "{ 'id' : ?0 }")
      Reserva updateReserva(String id, Reserva reserva);
       
   } 

        

      



