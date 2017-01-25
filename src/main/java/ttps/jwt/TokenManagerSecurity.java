package ttps.jwt;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ttps.clases.*;

/**
 * @author Manuel Ortiz - manuel.ortiz@fluxit.com.ar
 * 
 *         Nov 27, 2016
 * 
 *         <p>
 *         Esta clase se encarga de las operaciones asociadas al token de
 *         autenticacion
 *         </p>
 *         <p>
 *         El token es de tipo JWT donde tiene un header, un payload y un
 *         SIGNATURE
 *         </p>
 * 
 */
@Service
public class TokenManagerSecurity {

	/**
	 * semilla secreta
	 */
	@Inject
	private String secretKey;

	/**
	 * <p>
	 * Tiempo de expiracion del token
	 * </p>
	 * <p>
	 * Se define en segundos
	 * </p>
	 */
	@Inject
	private Long ttlSeg;

	/**
	 * El mapper utilizado para pasar de un ServiceRequest a json y viceversa
	 */

	@Inject
	private ObjectMapper mapper;

	public TokenManagerSecurity() {
		super();

	}

	/**
	 * Genera el token de autenticacion a partir de un usuario autenticado. El
	 * usuario se guarda como dato dentro del token. De esta forma se recibe en
	 * cada request.
	 * 
	 * @return token de autenticacion
	 * @throws Exception
	 */
	/**
	 * @param serviceRequest
	 * @return
	 * @throws Exception
	 */
	public String createJWT(Persona user) throws Exception {

		String subject = mapper.writeValueAsString(user);

		// The JWT signature algorithm we will be using to sign the token

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setIssuedAt(now).claim("content", subject).signWith(SignatureAlgorithm.HS512,
				secretKey);

		// if it has been specified, let's add the expiration
		if (getTtlSeg() >= 0) {
			long ttlMillis = getTtlSeg() * 1000;
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();

	}

	/**
	 * Parsea el token, verifica que sea valido, y finalmente devuelve el user.
	 * 
	 * @param jwt
	 *            token jwt
	 * @return El user si el token es valido y no expiro
	 * @throws ServiceException
	 */
	public Persona parseJWT(String jwt) {

		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();

		return this.getContentJWT(claims.get("content").toString());
	}

	public Persona getContentJWT(String contentJson) {

		try {
			return mapper.readValue(contentJson, Persona.class);
		} catch (Exception e) {
			System.out.println("Error intentando parsear el payload del token: " + contentJson + e.getMessage());
			throw new IllegalStateException("Error de parseo. El payload del token no puede parsearse");
		}

	}

	public Long getTtlSeg() {
		return ttlSeg;
	}

	public void setTtlSeg(Long ttlSeg) {
		this.ttlSeg = ttlSeg;
	}

}
