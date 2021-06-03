package co.edu.unicundi.proyectoSpringPrueba.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IConsultaService extends ICrud<Consulta, Integer>  {

	public Consulta retornarPorId(int id) throws ModelNotFoundException;
	
	public List<Consulta> retornar();
	
	public Page<Consulta> retornarPaginado(Pageable pageable);
	
	public void guardar(Consulta consulta);
	
	public void editar(Consulta consulta) throws ModelNotFoundException;
	
	public void eliminar(Integer id) throws ModelNotFoundException;
	
	public Page<Consulta> listarPaginado(int page, int size);
	
	public List<Consulta> buscarConsultaOrdenar( String orden);
	
	//public Page<Consulta> findByNombreDoctorAndId(Integer page, Integer cantidad, String nombre, Integer id) throws ModelNotFoundException;

   // public Page<Consulta> findByNombreDoctorOrId(Integer page, Integer cantidad, String nombre, Integer id) throws ModelNotFoundException ;

    public Page<Consulta> findAllByOrdenByIdAsc(Integer nPage, Integer cantidad);

    public Page<Consulta> findAllByOrdenByIdDesc(Integer nPage, Integer cantidad);
}
