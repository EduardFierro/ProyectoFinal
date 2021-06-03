package co.edu.unicundi.proyectoSpringPrueba.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.Medico;

@Repository
public interface IMedicoRepo extends JpaRepository<Medico, Integer>{
	
	@Query(value = "select count(*) from medico where id = :id", nativeQuery  = true)
	Object cantidadObtenida(@Param("id") Integer id);


		
	//FindBy Ordenar Ignorar Mayusculas Minusculas
	

	//nombre
	
	//apellido
	//correo
	//Direccion detalle 
	//Direccion Ciudad
	//Direccion Pais
	//Direccion barrio
	
}
