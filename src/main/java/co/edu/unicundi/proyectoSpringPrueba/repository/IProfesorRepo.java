package co.edu.unicundi.proyectoSpringPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;

@Repository
public interface IProfesorRepo extends JpaRepository<Profesor, Integer> {

	//SQL falta

    @Query(value="Select p FROM Profesor p WHERE p.cedula = :cedula")
    public Profesor consultarCedulaSQL(String cedula);

    //Nombramiento
    public Profesor findByCedula(String cedula);
	
	
}
