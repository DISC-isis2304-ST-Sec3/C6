package uniandes.edu.co.proyecto.Repositorio;

import uniandes.edu.co.proyecto.Modelo.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
     @Query(value = "SELECT * FROM Hoteles", nativeQuery = true)
        Collection<Hotel> darHoteles();

     @Query(value = "SELECT * FROM Hoteles WHERE id = :id", nativeQuery = true)
        Hotel darHotel(@Param("id") int id);

    @Modifying
        @Transactional
        @Query(value = "INSERT INTO Hoteles (id, nombre, tipo, estrellas) VALUES ( proyecto_sequence.nextval , :nombre, :tipo, :estrellas)", nativeQuery = true)
        void insertarHotel(@Param("nombre") String nombre, @Param("tipo") String tipo, @Param("estrellas") Integer estrellas);

    @Modifying
        @Transactional
        @Query(value = "UPDATE Hoteles SET nombre = :nombre, tipo = :tipo, estrellas = :estrellas WHERE id = :id", nativeQuery = true)
        void actualizarHotel(@Param("id") long id, @Param("nombre") String nombre, @Param("tipo") String tipo, @Param("estrellas") Integer estrellas);

    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Hoteles WHERE id = :id", nativeQuery = true)
        void eliminarHotel(@Param("id") long id);
}