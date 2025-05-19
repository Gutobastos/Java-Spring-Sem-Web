package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
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
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=69ae5116");
		var json2 = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=2&apikey=69ae5116");
		var json3 = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=69ae5116");
		System.out.println("\nSobre a Série " + json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println("\nRelatório dos " + dados);

		DadosEpisodio dadosEpisodios = conversor.obterDados(json2, DadosEpisodio.class);
		System.out.println("\nRelatório dos " + dadosEpisodios);

		DadosTemporada dadosTemporadas = conversor.obterDados(json3, DadosTemporada.class);
		System.out.println("\nRelatório das " + dadosTemporadas + "\n");

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1 ; i <= dados.TotalTemporadas() ; i++){
			var json4 = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season="+ i +"&&apikey=69ae5116");
			DadosTemporada dadosTemporada = conversor.obterDados(json4, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
	}
}