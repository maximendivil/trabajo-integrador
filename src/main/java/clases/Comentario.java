package clases;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Comentario implements java.io.Serializable{
	@Id @GeneratedValue
	private long id;
	private String texto;
	private Date fechaCreacion;
	@ManyToOne(optional=false)
	@JoinColumn(name="PUBLICACION_ID")
	private Publicacion publicacion;
	@ManyToOne(optional=false)
	@JoinColumn(name="PERSONA_ID")
	private Persona creador;
	
	public Comentario(){
		
	}
	
	public Comentario(String texto, Date fechaCreacion, Persona creador){
		this.texto = texto;
		this.fechaCreacion = fechaCreacion;
		this.creador = creador;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Persona getCreador() {
		return creador;
	}

	public void setCreador(Persona creador) {
		this.creador = creador;
	}
	
	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
}
