package br.com.alura.screenmatch.exercicios;

import java.util.*;
import java.util.stream.Collectors;

public class ExercicioStreamLambda {
    public static void main(String[] args) {
        System.out.println("###################################################");
        ///STREAM - 1
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> max = numeros.stream()
                .max(Integer::compare);

        max.ifPresent(System.out::println);

        System.out.println("###################################################");
        ///STREAM - 2
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
        Map<Integer, List<String>> agrupamento = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(agrupamento);

        System.out.println("###################################################");
        ///STREAM - 3
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");

        String resultado = String.join(", ", nomes);

        System.out.println("Lista de nomes: " + resultado);

        System.out.println("###################################################");
        ///STREAM - 4
        List<Integer> listaDeNumeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        int somaQuadrados = listaDeNumeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(somaQuadrados);

        System.out.println("###################################################");
        ///STREAM - 5
        List<Integer> numerosSeparar = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> separacao = numerosSeparar.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Números pares: " + separacao.get(true));
        System.out.println("Números impares: " + separacao.get(false));

        System.out.println("###################################################");
        ///STREAM - 6, 7, 8, 9
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        Map<Double, List<Produto>> produtosPrecosCrescente = produtos.stream()
                .filter(c -> c.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() < 1000)
                .collect(Collectors.groupingBy(Produto::getPreco));

        System.out.println("Produtos eletrônicos separados por preço crescente: " + produtosPrecosCrescente);

        System.out.println("----------------------------------------------------");

        Map<String, List<Produto>> produtosCategorias = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println("Produtos por categorias: " + produtosCategorias);

        System.out.println("----------------------------------------------------");

        Map<String, Long> quantidadeProdutos = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));

        System.out.println("Quantidade de produtos: " + quantidadeProdutos);

        System.out.println("----------------------------------------------------");

        Map<String, Optional<Produto>> produtoMaisCaroCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));

        System.out.println("Lista de produtos mais caro por categoria: " + produtoMaisCaroCategoria);

        System.out.println("----------------------------------------------------");

        Map<String, Double> totalPrecoDosProdutos = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.summingDouble(Produto::getPreco)));
        System.out.println("Soma dos valores totais dos produtos das categorias: " + totalPrecoDosProdutos);
    }
}
