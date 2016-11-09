package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Publicacion implements java.io.Serializable{
	@Id @GeneratedValue
	private int id;
	private String titulo;
	private String descripcion;
	private String multimedia;
	private Date fechaCreacion;
	private List<Comentario> comentarios;
	private Persona creador;
	
	public Publicacion(){
		
	}
	
	public Publicacion(String titulo, String descripcion, String multimedia, Date fechaCreacion, Persona creador){
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.multimedia = multimedia;
		this.fechaCreacion = fechaCreacion;
		this.creador = creador;
		this.comentarios = new ArrayList<Comentario>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(String multimedia) {
		this.multimedia = multimedia;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Persona getCreador() {
		return creador;
	}

	public void setCreador(Persona creador) {
		this.creador = creador;
	}
} 
