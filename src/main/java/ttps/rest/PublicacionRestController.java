package ttps.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ttps.clases.Publicacion;
import ttps.interfacesDAO.PublicacionDAO;

@RestController
@RequestMapping(value = "/publicacion")
public class PublicacionRestController {
	
	@Autowired
	private PublicacionDAO publicacionDAO;
	
	@RequestMapping(value = "/publicaciones", method = RequestMethod.GET)
	@ResponseBody
	public List<Publicacion> listarPublicaciones() {
	    List<Publicacion> publicaciones = publicacionDAO.obtenerTodos();
	    if(publicaciones.isEmpty()){
	    	return null;
    	}
	    //return new ResponseEntity<List<Publicacion>>(publicaciones, HttpStatus.OK);
	    return publicaciones;
	}
	
	@RequestMapping(value = "/publicaciones/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)    
	public ResponseEntity<Publicacion> listarPublicacion(@PathVariable("id") long id) {
		Publicacion publicacion = publicacionDAO.obtener(id);
		if (publicacion == null) { 
			return new ResponseEntity<Publicacion>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Publicacion>(publicacion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/publicaciones", method = RequestMethod.POST)
	public ResponseEntity<Void> crearPublicacion(@RequestBody Publicacion publicacion, UriComponentsBuilder ucBuilder){
		publicacionDAO.guardar(publicacion);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/publicaciones/{id}").buildAndExpand(publicacion.getId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	@RequestMapping(value = "/publicaciones/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable("id") long id, @RequestBody Publicacion publicacion) {
		Publicacion actual = publicacionDAO.obtener(id);
		if (actual == null) {
			return new ResponseEntity<Publicacion>(HttpStatus.NOT_FOUND);
		}
		actual.setCartelera(publicacion.getCartelera());;
		actual.setComentarios(publicacion.getComentarios());
		actual.setCreador(publicacion.getCreador());
		actual.setDescripcion(publicacion.getDescripcion());
		actual.setFechaCreacion(publicacion.getFechaCreacion());
		actual.setMultimedia(publicacion.getMultimedia());
		actual.setTitulo(publicacion.getTitulo());
		publicacionDAO.modificar(actual);
		return new ResponseEntity<Publicacion>(actual, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/publicaciones/{id}", method = RequestMethod.DELETE)    
	public ResponseEntity<Publicacion> eliminarPublicacion(@PathVariable("id") long id) {
        Publicacion publicacion = publicacionDAO.obtener(id);
        if (publicacion == null) {
        	return new ResponseEntity<Publicacion>(HttpStatus.NOT_FOUND);
    	}
 
        publicacionDAO.remover(id);
        return new ResponseEntity<Publicacion>(HttpStatus.NO_CONTENT);
    }
}
