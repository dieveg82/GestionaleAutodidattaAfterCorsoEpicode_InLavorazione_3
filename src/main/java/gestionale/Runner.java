package gestionale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import gestionale.controller.AnagraficaClienti;
import gestionale.controller.PaginaIniziale;

@Component
public class Runner implements CommandLineRunner{

	@Autowired
	PaginaIniziale paginaIniziale;
	
	@Autowired
	AnagraficaClienti anagraficaClienti;
	
	@Override
	public void run(String... args) throws Exception {

		paginaIniziale.initialize();
	}

}
