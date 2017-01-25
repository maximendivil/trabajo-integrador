package ttps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = "ttps.cartelera")
public class CarteleraConfig {

	@Bean
	public String secretKey() {
		return "&%$#!QWERT";
	}

	@Bean
	public Long ttlSeg() {
		return Long.valueOf(1 * 60 * 60 * 10);
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
