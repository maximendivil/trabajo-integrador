package ttps.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Publicador extends Persona implements java.io.Serializable{
	@OneToMany(fetch = FetchType.EAGER, mappedBy="creador",cascade={CascadeType.REMOVE})
	private Set<Publicacion> publicaciones;
	@ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.REMOVE})
	@JoinTable(name="habilitadas",
		joinColumns=@JoinColumn(name="PUBLICADOR_ID",referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="CARTELERA_ID",referencedColumnName="id")
		)
	private Set<Cartelera> cartelerasHabilitadas;	
	
	public Publicador(){
		
	}
	
	public Publicador(String nombre, String apellido, Date fechaNacimiento, long dni, String email, int rol, String usuario, String contraseña){
		super(nombre, apellido, fechaNacimiento, dni, email, rol, usuario, contraseña);
		this.publicaciones = new HashSet<Publicacion>();
		this.cartelerasHabilitadas = new HashSet<Cartelera>();
	}

	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Set<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Set<Cartelera> getCartelerasHabilitadas() {
		return cartelerasHabilitadas;
	}

	public void setCartelerasHabilitadas(Set<Cartelera> cartelerasHabilitadas) {
		this.cartelerasHabilitadas = cartelerasHabilitadas;
	}
	
	public void agregarCartelera(Cartelera c){
		this.cartelerasHabilitadas.add(c);
	}
}
