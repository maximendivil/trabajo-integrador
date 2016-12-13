package ttps.clases;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Cartelera implements java.io.Serializable {
	@Id @GeneratedValue
	private long id;
	private int borrado;
	private String nombre;
	private Date fechaCreacion;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="cartelera",cascade={CascadeType.REMOVE})
	private Set<Publicacion> publicaciones;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="intereses")
	private Set<Alumno> alumnosInteresados;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="cartelerasHabilitadas")
	private Set<Publicador> personasHabilitadas;
	public Set<Publicador> getPersonasHabilitadas() {
		return personasHabilitadas;
	}

	public void setPersonasHabilitadas(Set<Publicador> personasHabilitadas) {
		this.personasHabilitadas = personasHabilitadas;
	}

	public Cartelera(){
		
	}
	
	public Cartelera(String nombre, Date fechaCreacion){
		this.nombre = nombre;
		this.borrado = 0;
		this.fechaCreacion = fechaCreacion;
		this.publicaciones = new HashSet<Publicacion>();
		this.alumnosInteresados = new HashSet<Alumno>();
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

	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Set<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Set<Alumno> getAlumnosInteresados() {
		return alumnosInteresados;
	}

	public void setAlumnosInteresados(Set<Alumno> alumnosInteresados) {
		this.alumnosInteresados = alumnosInteresados;
	}

	public int getBorrado() {
		return borrado;
	}

	public void setBorrado(int borrado) {
		this.borrado = borrado;
	}
	
	public void agregarPublicacion(Publicacion publicacion){
		this.publicaciones.add(publicacion);
	}
}
