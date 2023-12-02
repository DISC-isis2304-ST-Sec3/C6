package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.Modelo.tipoHabitacion;

import java.util.List;

public interface tipoHabitacionRepository extends MongoRepository<tipoHabitacion, String> {

    // CREATE
    tipoHabitacion save(tipoHabitacion tipoHabitacion);

    // READ
    @Query(value = "{ tipo : ?0 }")
    tipoHabitacion findByTipo(String tipo);

    @Query("{}")
    List<tipoHabitacion> findAllTiposHabitacion();

    // DELETE
    @Query(value = "{ 'tipo' : ?0 }", delete = true)
    void deleteByTipo(String tipo);

    // UPDATE
    @Query("{ 'tipo' : ?0 }")
    tipoHabitacion updateTipoHabitacion(String tipo, tipoHabitacion TipoHabitacion);

}