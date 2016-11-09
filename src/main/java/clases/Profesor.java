package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class Profesor extends Persona implements java.io.Serializable{
	private List<Publicacion> publicaciones;
	private List<Cartelera> cartelerasHabilitadas;
	private List<Comentario> comentarios;
	
	public Profesor(){
		
	}
	
	public Profesor(String nombre, String apellido, Date fechaNacimiento, double dni, String email, int rol, String usuario, String contraseña){
		super(nombre, apellido, fechaNacimiento, dni, email, rol, usuario, contraseña);
		this.publicaciones = new ArrayList<Publicacion>();
		this.cartelerasHabilitadas = new ArrayList<Cartelera>();
		this.comentarios = new ArrayList<Comentario>();
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public List<Cartelera> getCartelerasHabilitadas() {
		return cartelerasHabilitadas;
	}

	public void setCartelerasHabilitadas(List<Cartelera> cartelerasHabilitadas) {
		this.cartelerasHabilitadas = cartelerasHabilitadas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
