package uniandes.edu.co.proyecto.Repositorio;

import uniandes.edu.co.proyecto.Modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     @Query(value = "SELECT * FROM Usuarios", nativeQuery = true)
        Collection<Usuario> darUsuarios();

     @Query(value = "SELECT * FROM Usuarios WHERE id = :id", nativeQuery = true)
        Usuario darUsuario(@Param("id") int id);

    @Modifying
        @Transactional
        @Query(value = "INSERT INTO Usuarios (id, login, contrasena, nombre, no_documento) VALUES ( proyecto_sequence.nextval , :login, :contrasena, :nombre, :no_documento)", nativeQuery = true)
        void insertarUsuario(@Param("login") String login, @Param("contrasena") String contrasena, @Param("nombre") String nombre, @Param("no_documento") Integer no_documento);

    @Modifying
        @Transactional
        @Query(value = "UPDATE Usuarios SET login =:login, contrasena = :contrasena, nombre = :nombre, no_documento = :no_documento WHERE id = :id", nativeQuery = true)
        void actualizarUsuario(@Param("id") long id, @Param("login") String login, @Param("contrasena") String consena, @Param("nombre") String nombre, @Param("no_documento") Integer no_documento);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM Usuarios WHERE id = :id", nativeQuery = true)
        void eliminarUsuario(@Param("id") long id);
}