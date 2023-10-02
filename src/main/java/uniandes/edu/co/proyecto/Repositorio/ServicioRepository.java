package uniandes.edu.co.proyecto.Repositorio;

import uniandes.edu.co.proyecto.Modelo.Servicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
     @Query(value = "SELECT * FROM Servicios", nativeQuery = true)
        Collection<Servicio> darServicios();

     @Query(value = "SELECT * FROM Servicios WHERE id = :id", nativeQuery = true)
        Servicio darServicio(@Param("id") int id);

    @Modifying
        @Transactional
        @Query(value = "INSERT INTO Servicios (id, nombre, Tipo_Servicio) VALUES ( proyecto_sequence.nextval , :nombre, :Tipo_Servicio)", nativeQuery = true)
        void insertarServicio(@Param("nombre") String nombre, @Param("Tipo_Servicio") String Tipo_Servicio);

    @Modifying
        @Transactional
        @Query(value = "UPDATE Servicios SET nombre = :nombre, Tipo_Servicio = :Tipo_Servicio WHERE id = :id", nativeQuery = true)
        void actualizarServicio(@Param("id") long id, @Param("nombre") String nombre, @Param("Tipo_Servicio") String Tipo_Servicio);

    
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Servicios WHERE id = :id", nativeQuery = true)
        void eliminarServicio(@Param("id") long id);
}