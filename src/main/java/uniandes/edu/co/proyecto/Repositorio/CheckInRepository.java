package uniandes.edu.co.proyecto.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.Modelo.CheckIn;

import java.util.List;

public interface CheckInRepository extends MongoRepository<CheckIn, String> {

    // CREATE
    CheckIn save(CheckIn check);

    // READ
    @Query("{}")
    List<CheckIn> findAllCheckInes();

    @Query("{ 'cliente' : ?0 }")
    List<CheckIn> findAllCheckInsByClient(String idCliente);

}