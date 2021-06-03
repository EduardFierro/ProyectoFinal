package co.edu.unicundi.proyectoSpringPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import co.edu.unicundi.proyectoSpringPrueba.entity.Examen;

@Repository
public interface IExamenRepo  extends JpaRepository<Examen, Integer>{
    public Optional<Examen> findById(Integer id);
}