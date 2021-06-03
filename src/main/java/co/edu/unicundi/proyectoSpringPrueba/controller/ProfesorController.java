package co.edu.unicundi.proyectoSpringPrueba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.proyectoSpringPrueba.entity.Profesor;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.service.IProfesorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.*;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/profesores")
@Api(value="Servicio de Profesor ", description = "Este servicio gestiona un CRUD de profesores")
public class ProfesorController {
	
	@Autowired
	IProfesorService service;
	
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un profesor por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		Profesor profesor = service.buscarId(id);
		return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);	
				

	}
	
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea a un profesor con su información")
	public ResponseEntity<?> guardar (@Valid @RequestBody Profesor profesor) throws Exception {
		service.guardarProfesor(profesor);
		return new ResponseEntity<Profesor>(profesor, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar al profesor correspondiente al id",
            notes = "Editar al profesor correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Profesor.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Profesor> editar(@Valid @RequestBody Profesor profesor) throws Exception, ModelNotFoundException{
		service.editarProfesor(profesor);
		return new ResponseEntity<Profesor>(profesor, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina el profesor correspondiente al id",
            notes = "Elimina el profesor correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Profesor.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Profesor.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminarProfesor(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todos los profesores creados")
	public ResponseEntity<List<Profesor>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Profesor>>(service.mostrarProfesores(), HttpStatus.OK);

	}
	@GetMapping("/buscarCedulaNombramiento/{cedula}")
    @ApiOperation(
            value = "Retorna el profesor correspondiente a la cedula",
            notes = "Retorna el profesor correspondiente a la cedula"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Profesor.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Profesor.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    public ResponseEntity<Profesor> buscarCedulaNombramiento(@PathVariable String cedula) throws ModelNotFoundException{
        Profesor profe = this.service.buscarCedulaNombramiento(cedula);
        if(profe != null) {
            return new ResponseEntity<Profesor>(profe, HttpStatus.OK);
        }else {
            return new ResponseEntity<Profesor>(profe, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscarCedulaSQL/{cedula}")
    @ApiOperation(
            value = "Retorna el profesor correspondiente a la cedula",
            notes = "Retorna el profesor correspondiente a la cedula"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Profesor.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Profesor.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    public ResponseEntity<Profesor> buscarCedulaJPQL(@PathVariable String cedula) throws ModelNotFoundException{
        Profesor profe = this.service.buscarCedulaSQL(cedula);
        if(profe != null) {
            return new ResponseEntity<Profesor>(profe, HttpStatus.OK);
        }else {
            return new ResponseEntity<Profesor>(profe, HttpStatus.NOT_FOUND);
        }
    }

}
