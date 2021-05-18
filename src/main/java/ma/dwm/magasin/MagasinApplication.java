package ma.dwm.magasin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.dwm.magasin.views.MagasinView;

@SpringBootApplication
public class MagasinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagasinApplication.class, args);
		MagasinView.launch(args);
	}

}
