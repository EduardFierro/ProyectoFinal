package co.edu.unicundi.proyectoSpringPrueba.service;

import java.util.List;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;

public interface IProfesorService {
	
	public Profesor buscarId(int id) throws ModelNotFoundException;
	
	public List<Profesor>mostrarProfesores() throws ModelNotFoundException;
	
	public void guardarProfesor(Profesor profesor) throws Exception;
	
	public void editarProfesor(Profesor profesor) throws Exception, ModelNotFoundException;
	
	public void eliminarProfesor(int id) throws ModelNotFoundException;
	
	public Profesor buscarCedulaNombramiento(String cedula);

    public Profesor buscarCedulaSQL(String cedula);
	
}
