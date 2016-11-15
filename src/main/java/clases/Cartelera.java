package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cartelera implements java.io.Serializable {
	@Id @GeneratedValue
	private long id;
	private String nombre;
	private Date fechaCreacion;
	@OneToMany(mappedBy="cartelera")
	private List<Publicacion> publicaciones;
	@ManyToMany(mappedBy="intereses")
	private List<Alumno> alumnosInteresados;
	@ManyToMany(mappedBy="cartelerasHabilitadas")
	private List<Publicador> personasHabilitadas;
	public Cartelera(){
		
	}
	
	public Cartelera(String nombre, Date fechaCreacion){
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.publicaciones = new ArrayList<Publicacion>();
		this.alumnosInteresados = new ArrayList<Alumno>();
	}

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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public List<Alumno> getAlumnosInteresados() {
		return alumnosInteresados;
	}

	public void setAlumnosInteresados(List<Alumno> alumnosInteresados) {
		this.alumnosInteresados = alumnosInteresados;
	}
	
	
}
