package ttps.clases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Comentario implements java.io.Serializable{
	@Id @GeneratedValue
	private long id;
	private int borrado;
	public int getBorrado() {
		return borrado;
	}

	public void setBorrado(int borrado) {
		this.borrado = borrado;
	}

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
		this.borrado = 0;
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
