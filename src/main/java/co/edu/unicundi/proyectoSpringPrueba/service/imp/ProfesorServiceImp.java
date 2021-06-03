package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IProfesorRepo;
import co.edu.unicundi.proyectoSpringPrueba.service.IProfesorService;
@Service
public class ProfesorServiceImp implements IProfesorService  {
	@Autowired
	private IProfesorRepo profesorRepo;
	
	List<Profesor> profesores = new ArrayList<Profesor>();
	@Override
	public Profesor buscarId(int id) throws ModelNotFoundException {
		/*for(Profesor p: profesores) {
			if(p.getId()==id) {
				return p;
			}
		}*/
		Profesor profesor = profesorRepo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("Profesor no exontrado"));
        return profesor;
		//throw new ModelNotFoundException("Profesor no existe");

	}

	@Override
	public List<Profesor> mostrarProfesores() throws ModelNotFoundException{
		/*for(Profesor p: profesores) {
			
			return profesores;
		}
		
		throw new ModelNotFoundException("No hay profesores creados");*/
		return this.profesorRepo.findAll();

	}

	@Override
	public void guardarProfesor(Profesor profesor) throws Exception  {
		/*for(Profesor p: profesores) {
			if(p.getId()==profesor.getId()) {
				throw new Exception("Ya existe el ID");
			}			
		}
		profesores.add(profesor);*/
		this.profesorRepo.save(profesor);
		
	}

	@Override
	public void editarProfesor(Profesor profesor) throws Exception, ModelNotFoundException {
		/*for(int i=0; i<profesores.size();i++) {
			if(profesores.get(i).getId()==profesor.getId()) {
				profesores.set(i, profesor);
				return "Profesor Actualizado";
			}
		}
		throw new ModelNotFoundException("PROFESOR No actualizado");*/
		Profesor pro = this.buscarId(profesor.getId());
        pro.setApellido(profesor.getApellido());
        pro.setNombre(profesor.getNombre());
        pro.setCorreo(profesor.getCorreo());
        pro.setEdad(profesor.getEdad());
        //pro.setCedula(profesor.getCedula());
        this.profesorRepo.save(pro);
	}

	@Override
	public void eliminarProfesor(int id) throws ModelNotFoundException{
		/*for(Profesor p: profesores) {
			if(p.getId()==id) {
				profesores.remove(p);
				return "Profesor Eliminado";
			}
		}
		throw new ModelNotFoundException("No existe el profesor a eliminar ");*/
		this.profesorRepo.delete(this.buscarId(id));
	}

	@Override
	public Profesor buscarCedulaNombramiento(String cedula) {
		return this.profesorRepo.findByCedula(cedula);
		
	}

	@Override
	public Profesor buscarCedulaSQL(String cedula) {
		return this.profesorRepo.consultarCedulaSQL(cedula);
	}

}
