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

import ttps.clases.Alumno;
import ttps.clases.Cartelera;
import ttps.clases.Publicacion;
import ttps.interfacesDAO.CarteleraDAO;
import ttps.interfacesDAO.PublicacionDAO;

@RestController
@RequestMapping(value = "/cartelera")
public class CarteleraRestController {
	
	@Autowired
	private CarteleraDAO carteleraDAO;
	@Autowired
	private PublicacionDAO publicacionDAO;
	
	@RequestMapping(value = "/carteleras", method = RequestMethod.GET)
	@ResponseBody
	public List<Cartelera> listarCarteleras() {
	    List<Cartelera> carteleras = carteleraDAO.obtenerTodos();
	    if(carteleras.isEmpty()){
	    	return null;
    	}
	    return carteleras;
	}
	
	@RequestMapping(value = "/carteleras/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)    
	public ResponseEntity<Cartelera> listarCartelera(@PathVariable("id") long id) {
		Cartelera cartelera = carteleraDAO.obtener(id);
		if (cartelera == null) { 
			return new ResponseEntity<Cartelera>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Cartelera>(cartelera, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/alumnosInteresados", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)    
	public List<Alumno> listarAlumnosInteresados(@PathVariable("id") long id) {
		List<Alumno> alumnos = carteleraDAO.obtenerAlumnosInteresados(id);
	    if(alumnos.isEmpty()){
	    	return null;
    	}
	    return alumnos;
	}
	
	@RequestMapping(value = "/carteleras", method = RequestMethod.POST)
	public ResponseEntity<Void> crearPublicacion(@RequestBody Cartelera cartelera, UriComponentsBuilder ucBuilder){
		carteleraDAO.guardar(cartelera);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/cartelera/carteleras/{id}").buildAndExpand(cartelera.getId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	@RequestMapping(value = "/carteleras/{id}/", method = RequestMethod.POST)
	public ResponseEntity<Cartelera> crearPublicacion(@RequestBody Publicacion publicacion, @PathVariable("id") long idCartelera, UriComponentsBuilder ucBuilder){
		Cartelera cartelera = carteleraDAO.obtener(idCartelera);
		publicacionDAO.guardar(publicacion);
		cartelera.agregarPublicacion(publicacion);		
		carteleraDAO.modificar(cartelera);
		return new ResponseEntity<Cartelera>(cartelera, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/carteleras/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cartelera> actualizarCartelera(@PathVariable("id") long id, @RequestBody Cartelera cartelera) {
		Cartelera actual = carteleraDAO.obtener(id);
		if (actual == null) {
			return new ResponseEntity<Cartelera>(HttpStatus.NOT_FOUND);
		}
		actual.setAlumnosInteresados(cartelera.getAlumnosInteresados());
		actual.setFechaCreacion(cartelera.getFechaCreacion());
		actual.setNombre(cartelera.getNombre());
		actual.setPersonasHabilitadas(cartelera.getPersonasHabilitadas());
		actual.setPublicaciones(cartelera.getPublicaciones());
		carteleraDAO.modificar(actual);
		return new ResponseEntity<Cartelera>(actual, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/carteleras/{id}", method = RequestMethod.DELETE)    
	public ResponseEntity<Cartelera> eliminarPublicacion(@PathVariable("id") long id) {
        Cartelera cartelera = carteleraDAO.obtener(id);
        if (cartelera == null) {
        	return new ResponseEntity<Cartelera>(HttpStatus.NOT_FOUND);
    	}
 
        carteleraDAO.remover(id);;
        return new ResponseEntity<Cartelera>(HttpStatus.NO_CONTENT);
    }
}