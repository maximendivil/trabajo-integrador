package clases;

import java.util.Date;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Persona implements java.io.Serializable{
	//Variables de instancia
	@Id @GeneratedValue
	protected int id;
	protected String nombre;
	protected String apellido;
	protected Date fechaNacimiento;
	protected long dni;
	protected String email;
	protected int rol; // 1 -> Admin, 2 -> Profesor, 3 -> Alumno, 4 -> Publicador
	protected String usuario;
	protected String contraseña;

	//Constructores
	public Persona(){
		
	}
	
	public Persona(String nombre, String apellido, Date fechaNacimiento, long dni, String email, int rol, String usuario, String contraseña){
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
		this.email = email;
		this.rol = rol;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
