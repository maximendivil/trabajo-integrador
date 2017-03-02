package ttps.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
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
	public ResponseEntity<?> login(@RequestBody Persona userPost) {
		try {
			int rol = loginService.buscarRol(userPost.getUsuario());
			String clase;
			Persona user = null;
			if ((rol == 2) || (rol == 3)){
				if (rol == 2){
					clase = "Profesor";
				}
				else {
					clase = "Alumno";
				}
				chequearConGuarani(userPost, clase);
			}
			else {
				user = (Persona) loginService.login(userPost.getUsuario(), userPost.getPassword());
			}			
			Token token = new Token(tokenManagerSecurity.createJWT(user));
			return ResponseEntity.ok(token);
		} catch (Exception e) {
			return new ResponseEntity<>(Collections.singletonMap("AuthenticationException",e.getMessage()), HttpStatus.UNAUTHORIZED);
		}
	}
	
	public void chequearConGuarani(Persona user, String clase) throws JSONException {
		try {

			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost("http://localhost:8080/APIRESTGuarani/" + clase + "/chequearlogin");
			
			/*JSONObject json = new JSONObject();
			json.put("usuario", user.getUsuario());
			json.put("contraseña", user.getPassword());
			
			HttpEntity httpEntity = new StringEntity(json.toString());
			
			postRequest.setEntity(httpEntity);*/
			
		    /*postRequest.setHeader("Accept", "application/json");
		    postRequest.setHeader("Content-type", "application/json");*/
			
			/*List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			nvps.add(new BasicNameValuePair("usuario", "maximendivil"));
			nvps.add(new BasicNameValuePair("contraseña", "mmendivil123"));
			postRequest.setEntity(new UrlEncodedFormEntity(nvps));*/
			
			StringEntity params =new StringEntity("{\"usuario\":\"maximendivil\",\"contraseña\":\"mmendivil123\"}");
		    postRequest.addHeader("content-type", "application/json");
		    postRequest.setEntity(params);
		    
			HttpResponse response = httpClient.execute(postRequest);
			
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
	}

}