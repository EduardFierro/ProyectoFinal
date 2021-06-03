package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.unicundi.proyectoSpringPrueba.dto.ListarPorIdConsultaDto;
import co.edu.unicundi.proyectoSpringPrueba.entity.ConsultaExamen;
import co.edu.unicundi.proyectoSpringPrueba.exception.InvalidFormatExcepcion;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.service.ICrud;
import co.edu.unicundi.proyectoSpringPrueba.view.ConsultaExamenView;

public interface IConsultaExamenService extends ICrud<ConsultaExamen, Integer> {

	public void guardarNativo(ConsultaExamen consultaExamen);
	
	List<ListarPorIdConsultaDto> listarPorIdCosnulta(Integer idConsulta);
	
	Page<ConsultaExamen> listarPorIdCosnultaPaginado(Integer id, Integer page, Integer size);

	void eliminarConsultaExamen(Integer consulta, Integer examen) throws ModelNotFoundException, InvalidFormatExcepcion;

	ConsultaExamen filtrarPorId(Integer idConsulta, Integer idExamen) throws ModelNotFoundException;

	Page<ConsultaExamenView> vista(Integer nPage, Integer cantidad);	
	
}
