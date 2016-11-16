package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Profesor extends Publicador implements java.io.Serializable{
		
	public Profesor(){
		
	}
	public Profesor(String nombre, String apellido, Date fechaNacimiento, double dni, String email, int rol, String usuario, String contraseña){
		super(nombre,apellido,fechaNacimiento,dni,email,rol,usuario,contraseña);
	}
}
