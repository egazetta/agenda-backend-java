package br.com.simplenetwork.agenda;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class AgendaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
