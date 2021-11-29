package gestionale;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.sun.tools.javac.Main;

import gestionale.controller.PaginaIniziale;


@SpringBootApplication
public class MySpingMvc1Application {

	public static void main(String[] args) throws SQLException {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(MySpingMvc1Application.class);
		builder.headless(false).allowCircularReferences(true);
		ConfigurableApplicationContext context = builder.run(args);
	}

}
