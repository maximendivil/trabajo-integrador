package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Persona implements java.io.Serializable{
	//Variables de instancia
	@Id @GeneratedValue
	protected long id;
	protected String nombre;
	protected String apellido;
	protected Date fechaNacimiento;
	protected long dni;
	protected String email;
	protected int rol; // 1 -> Admin, 2 -> Profesor, 3 -> Alumno, 4 -> Publicador
	protected String usuario;
	protected String contraseña;
	@OneToMany(mappedBy="creador",cascade={CascadeType.REMOVE})
	private List<Comentario> comentarios;

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
		this.comentarios = new ArrayList<Comentario>();
	}
	
	//Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void agregarComentario(Comentario c){
		this.comentarios.add(c);
	}
}
