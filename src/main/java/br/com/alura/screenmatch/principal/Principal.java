package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=69ae5116";

    public void exibeMenu() {
        System.out.println("Digite o nome da série que deseja buscar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println("\n" + dados + "\n");

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1 ; i <= dados.TotalTemporadas() ; i++){
			var json4 = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + APIKEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json4, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

        for (int i = 0 ; i < dados.TotalTemporadas() ; i++) {
            List<DadosEpisodio> episodiosDaTemporada = temporadas.get(i).episodios();
            for (int j = 0 ; j < episodiosDaTemporada.size() ; j++) {
                System.out.println("\n" + episodiosDaTemporada.get(j).titulo().toUpperCase());
            }
        }
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println("\n" + e.titulo().toUpperCase())));
    }
}
