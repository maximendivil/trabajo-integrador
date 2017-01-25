package ttps.rest;

import java.util.Collections;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ttps.clases.*;
import ttps.jwt.TokenManagerSecurity;
import ttps.clasesDAO.*;
import ttps.interfacesDAO.PersonaDAO;

/**
 * @author Manuel Ortiz - ortizman@gmail.com
 *
 * Nov 28, 2016
 */
@CrossOrigin
@RestController
public class LoginController {
	
	@Inject
	private PersonaDAO loginService;
	
	@Inject
	private TokenManagerSecurity tokenManagerSecurity;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Administrador userPost) {
		try {
			/*Administrador admin = new Administrador();
			admin.setUsuario("admin1");
			admin.setContraseña("admin");*/
			System.out.println("Nombre: " + userPost.getUsuario() + userPost.getPassword());
			Administrador user = (Administrador) loginService.login(userPost.getUsuario(), userPost.getPassword());
			Token token = new Token(tokenManagerSecurity.createJWT(user));
			return ResponseEntity.ok(token);
		} catch (Exception e) {
			return new ResponseEntity<>(Collections.singletonMap("AuthenticationException",e.getMessage()), HttpStatus.UNAUTHORIZED);
		}
	}

}