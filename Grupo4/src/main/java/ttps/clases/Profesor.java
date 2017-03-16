package ttps.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Profesor extends Publicador implements java.io.Serializable{
		
	public Profesor(){
		
	}
	public Profesor(String nombre, String apellido, Date fechaNacimiento, long dni, String email, int rol, String usuario, String contraseña){
		super(nombre,apellido,fechaNacimiento,dni,email,rol,usuario,contraseña);
	}
}
