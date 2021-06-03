package co.edu.unicundi.proyectoSpringPrueba.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;

@Repository
public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{
	
	//SQL Native
	
	@Query(value= "select count(*) from consulta where id =id", nativeQuery = true)
	Object cantidadObtenida(@Param("id")Integer id);
	
	//JPQL
	//@Query(value= "SELECT c FROM Consulta c WHERE c.nombreDoctor =:nombreDoctor")
	//List<Consulta>buscarConsultaPorDoctor(@Param("nombreDoctor")Integer String);
	
	@Query(value= "SELECT c FROM Consulta c")
	List<Consulta>buscarConsultaOrdenar(Sort sort);
	
	public Page<Consulta> findAllByOrderByIdAsc(Pageable page);

    public Page<Consulta> findAllByOrderByIdDesc(Pageable page);

   
   // public Page<Consulta> findByNombreDoctorAndId(Pageable page, String nombre, Integer id);

  
  //  public Page<Consulta> findByNombreDoctorOrId(Pageable page, String nombre, Integer id);
    
}
