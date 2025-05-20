package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Principal principal = new Principal();
		principal.exibeMenu();

//		List<DadosTemporada> temporadas = new ArrayList<>();
//
//		for (int i = 1 ; i <= dados.TotalTemporadas() ; i++){
//			var json4 = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season="+ i +"&&apikey=69ae5116");
//			DadosTemporada dadosTemporada = conversor.obterDados(json4, DadosTemporada.class);
//			temporadas.add(dadosTemporada);
//		}
//		temporadas.forEach(System.out::println);
	}
}