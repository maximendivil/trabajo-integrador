package clases;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class Alumno extends Persona implements java.io.Serializable{
	//Variables de instancia
	private String legajo;
	private List<Comentario> comentarios;
	private List<Cartelera> intereses;
	
	//Constructores
	public Alumno(){
		
	}
	
	public Alumno(String nombre, String apellido, Date fechaNacimiento, double dni, String email, int rol, String usuario, String contraseña, String legajo){
		super(nombre, apellido, fechaNacimiento, dni, email, rol, usuario, contraseña);
		this.legajo = legajo;
		this.comentarios = new ArrayList<Comentario>();
		this.intereses = new ArrayList<Cartelera>();
	}
	
	//Getters y setters
	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Cartelera> getIntereses() {
		return intereses;
	}

	public void setIntereses(List<Cartelera> intereses) {
		this.intereses = intereses;
	}
}
