package ttps.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Administrador extends Publicador implements java.io.Serializable {
	/*@OneToMany(mappedBy="creador")
	private List<Publicacion> publicaciones;
	@OneToMany(mappedBy="creador")
	private List<Comentario> comentarios;*/
	
	public Administrador(){
		
	}
	
	public Administrador(String nombre, String apellido, Date fechaNacimiento, long dni, String email, int rol, String usuario, String contraseņa){
		super(nombre, apellido, fechaNacimiento, dni, email, rol, usuario, contraseņa);
		/*this.publicaciones = new ArrayList<Publicacion>();
		this.comentarios = new ArrayList<Comentario>();*/
	}

	/*public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}*/
}
