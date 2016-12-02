package ttps.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ttps.clases.Publicacion;
import ttps.interfacesDAO.PublicacionDAO;

@RestController
@RequestMapping(value = "/publicacion")
public class PublicacionRestController {
	
	@Autowired
	private PublicacionDAO publicacionDAO;
	
	@RequestMapping(value = "/publicaciones", method = RequestMethod.GET)
	@ResponseBody
	public String listarPublicaciones() {
	    List<Publicacion> publicaciones = publicacionDAO.obtenerTodos();
		/*Publicacion publicacion = new Publicacion("Prueba","Es una prueba","casa",new Date(),null);
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacion);*/
		if(publicaciones.isEmpty()){
			//return new ResponseEntity<List<Publicacion>>(HttpStatus.NO_CONTENT);
		}
		//return new ResponseEntity<List<Publicacion>>(publicaciones, HttpStatus.OK);
		return new Gson().toJson(publicaciones);
	}
	
	 @RequestMapping(value = "/publicaciones/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)    
	 public String listarPublicacion(@PathVariable("id") long id) {
	        Publicacion publicacion = publicacionDAO.obtener(id);
	        if (publicacion == null) {
	        	return (HttpStatus.NOT_FOUND).toString();
	 		}
	        return new Gson().toJson(publicacion);
	 }

}
