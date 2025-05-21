package br.com.alura.screenmatch.exercicios;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciocioLambda2 {
    public static void main(String[] args) {
        System.out.println("****************************************************");
        /// LAMBDA -1- PARTE-2
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        System.out.println("****************************************************");
        /// LAMBDA -2- PARTE-2
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("****************************************************");
        /// LAMBDA -3- PARTE-2
        List<Integer> listaDeNumeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> multiplosImpares = listaDeNumeros.stream()
                .filter(n -> n % 2 != 0 )
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println(multiplosImpares);
        System.out.println("****************************************************");
        /// LAMBDA -4- PARTE-2
        List<String> palavras2 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        List<String> iguais = palavras2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(iguais);
        System.out.println("****************************************************");
        /// LAMBDA -5- PARTE-2
        Primo primo = new Primo();
        List<List<Integer>> listaDeNumeros2 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12));

        List<Integer> numerosPrimos = listaDeNumeros2.stream()
                .flatMap(List::stream)
                .filter(Primo::ehPrimo)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(numerosPrimos + "\n");
        System.out.println("****************************************************");
        /// LAMBDA -6- PARTE-2
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );
        pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .map(Pessoa::getNome)
                .sorted()
                .forEach(System.out::println);
        System.out.println("****************************************************");
        /// LAMBDA -7- PARTE-2
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        List<Produto> produtosFiltrados = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() < 1000)
                .sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .collect(Collectors.toList());
        System.out.println(produtosFiltrados);
        System.out.println("****************************************************");
        /// LAMBDA -8- PARTE-2
        List<Produto> produtos2 = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        List<Produto> produtosFiltrados2 = produtos2.stream()
                .filter(c -> c.getCategoria().equals("Eletrônicos"))
                .filter(c -> c.getPreco() < 1000)
                .sorted((c1, c2) -> Double.compare(c1.getPreco(), c2.getPreco()))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(produtosFiltrados2);
        System.out.println("****************************************************");


    }
}
