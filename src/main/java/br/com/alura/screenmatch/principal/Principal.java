package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;

import java.io.DataOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=69ae5116";

    public void exibeMenu() {
        System.out.println("#######################################################################################");
        System.out.println("Digite o nome da série que deseja buscar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println("\n" + dados);

        System.out.println("\n#######################################################################################");
        List<DadosTemporada> temporadas = new ArrayList<>();
//
		for (int i = 1 ; i <= dados.TotalTemporadas() ; i++){
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + APIKEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

//        System.out.println("\n#######################################################################################");
//        for (int i = 0 ; i < dados.TotalTemporadas() ; i++) {
//            List<DadosEpisodio> episodiosDaTemporada = temporadas.get(i).episodios();
//            for (int j = 0 ; j < episodiosDaTemporada.size() ; j++) {
//                System.out.println(episodiosDaTemporada.get(j).titulo().toUpperCase());
//            }
//        }
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println("\n" + e.titulo().toUpperCase())));
//
//        System.out.println("\n#######################################################################################");
//        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream())
//                .collect(Collectors.toList());
//
//        var top = 10;
//        System.out.printf("\nTop %s Episódios:\n\n", top);
//        dadosEpisodios.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primeiro filtro N/A: " + e))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//                .peek(e -> System.out.println("Ordenação: " + e))
//                .limit(top)
//                .peek(e -> System.out.println("Limite: " + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Mapeamento: " + e))
//                .forEach(System.out::println);

        System.out.println("\n#######################################################################################");
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("Digite um trexo do título do episósio: ");
        var trechoTitulo  =leitura.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .findFirst();
        if (episodioBuscado.isPresent()) {
            System.out.println("Episódio encontrado !!!");
            System.out.println("Temporada: " + episodioBuscado.get());
        } else {
            System.out.println("Episódio não encontrado na série: " + dados.titulo());
        }

//        System.out.println("\n#######################################################################################\"");
//
//        System.out.println("A partir de que ano você deseja assitir o filme? ");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//        LocalDate dataBusca = LocalDate.of(ano,1,1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e -> e.getDataDeLancamento() != null && e.getDataDeLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                "Episódio: " + e.getTitulo() +
//                                "Data de lançamento: " + e.getDataDeLancamento().format(formatador)
//                ));

        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
                .filter(av -> av.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println("Temporadas e suas avaliações:" + avaliacoesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(av -> av.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        System.out.println("Estatística de média de avaliações: " + est.getAverage());
        System.out.println("Melhor episódio com avaliação máxima: " + est.getMax());
        System.out.println("Pior episódio com avaliação mínima: " + est.getMin());
        System.out.println("Quantidade de episódios: " + est.getCount());



    }
}
