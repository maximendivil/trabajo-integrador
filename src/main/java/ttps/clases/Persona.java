package ttps.clases;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Persona implements java.io.Serializable{
	//Variables de instancia
	@Id @GeneratedValue
	protected long id;
	protected int borrado;
	protected String nombre;
	protected String apellido;
	protected Date fechaNacimiento;
	protected long dni;
	protected String email;
	protected int rol; // 1 -> Admin, 2 -> Profesor, 3 -> Alumno, 4 -> Publicador
	protected String usuario;
	protected String password;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="creador",cascade={CascadeType.REMOVE})
	private Set<Comentario> comentarios;

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
		this.password = contraseña;
		this.borrado = 0;
		this.comentarios = new HashSet<Comentario>();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void agregarComentario(Comentario c){
		this.comentarios.add(c);
	}

	public int getBorrado() {
		return borrado;
	}

	public void setBorrado(int borrado) {
		this.borrado = borrado;
	}
}
