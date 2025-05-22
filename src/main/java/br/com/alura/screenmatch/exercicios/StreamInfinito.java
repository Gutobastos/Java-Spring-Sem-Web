package br.com.alura.screenmatch.exercicios;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamInfinito {
    public static void main(String[] args) {

        List<Integer> armazenador = Stream.iterate(1, n -> n + 1)
                .limit(5).toList();

        armazenador.forEach(System.out::println);
        System.out.println("######################");
        List<List<String>> list = List.of(
                List.of("a", "b"),
                List.of("c", "d")
        );

        Stream<String> stream = list.stream()
                .flatMap(Collection::stream);

        stream.forEach(System.out::println);
        System.out.println("######################");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        result.ifPresent(System.out::println);
    }
}
