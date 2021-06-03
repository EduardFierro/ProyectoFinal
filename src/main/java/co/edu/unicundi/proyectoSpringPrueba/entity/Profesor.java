package co.edu.unicundi.proyectoSpringPrueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	@NotNull(message = "Id es obligatorio")	
	@Id
	private Integer id;

	@NotNull(message = "Cédula es obligatorio")
	@Size(min = 7, max = 10, message = "Cedula debe tener entre 7 y 10 números")	
	@Column(name = "cedula", length = 10, nullable = false, unique = true)
	private String cedula;
	@NotNull(message = "Nombre es obligatorio")
	@Column(name = "nombre", length = 25, nullable = false)
	private String nombre;
	
	@NotNull(message = "Apellido es obligatorio")
	@Column(name = "apellido", length = 25, nullable = false)
	private String apellido;
	
	@NotNull(message = "Correo es obligatorio")
	@Email
	@Column(name = "correo", length = 60, nullable = false)
	private String correo;
	
	@NotNull(message = "Edad es obligatoria")
	@Column(name = "edad", nullable = false)
	private Integer edad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apelido) {
		this.apellido = apelido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
