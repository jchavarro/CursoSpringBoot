package gia.utp.primerproyecto.primerproyecto.model.repository;

import gia.utp.primerproyecto.primerproyecto.model.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {

    Optional<List<LibroEntity>> findAllByEditorial(String editorial);

    @Query(value = "SELECT * FROM libro WHERE NOMBRE_LIBRO = :nombreLibro AND AUTOR_LIBRO = :autorLibro",
            nativeQuery = true)
    Optional<List<LibroEntity>> obtenerLibroPorNombres(String nombreLibro, String autorLibro);
}
