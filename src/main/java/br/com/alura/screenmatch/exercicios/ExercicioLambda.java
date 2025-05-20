package br.com.alura.screenmatch.exercicios;

import java.util.*;

public class ExercicioLambda {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Scanner leituraTexto = new Scanner(System.in);

//        LAMBDA - 1
        System.out.println("Resposta da multiplicação entre 2 valores inteiros usando LAMBDA:");
        Operacao multiplicar = (a, b) -> a * b;
        System.out.println(multiplicar.executar(5, 5));
        System.out.println("#################################");
//        LAMBDA - 2
        System.out.println("Escreva uma letra, palavras ou texto para ficar em maiúsculas: ");
        String texto = leituraTexto.nextLine();
        System.out.println("Texto: " + texto.toUpperCase());
        System.out.println("#################################");
//        LAMBDA - 3
        System.out.println("Informe um número para saber se é PRIMO: ");
        int numero = leitura.nextInt();
        int prova = 0;
        ArrayList<Integer> listaRestos = new ArrayList<>();

        for (int testePrimo = 1; testePrimo <= numero; testePrimo++) {
            int total = numero % testePrimo;
            listaRestos.add(total);
        }
        for (Integer listaResto : listaRestos) {
            if (listaResto == 0) {
                prova++;
            }
        }
        if (prova > 2 || numero == 1) {
            System.out.println("NÃO É PRIMO: " + numero);
        } else if (listaRestos.get(0) == 0 && listaRestos.get(numero - 1) == 0) {
            System.out.println("É PRIMO: " + numero);
        }
        System.out.println("#################################");
//        LAMBDA - 4
        System.out.println("Informe uma palavra para verificar se é um PALÍNDROMO: ");
        texto = leituraTexto.nextLine();
        Palindromo palindromo = str -> str.contentEquals(new StringBuilder(str).reverse());
        System.out.println("O texto: " + texto.toUpperCase() + " POLÍNDROMO: "
                + palindromo.executar(texto.toUpperCase()));  // Resultado: true ou false
        System.out.println("#################################");
//        LAMBDA - 5
        List <Integer> inteiros = Arrays.asList(1,2,3,4,5);
        inteiros.replaceAll(i -> i * 3);
        System.out.println(inteiros);
        System.out.println("#################################");
//        LAMBDA - 6
        List<String> ordemLetras = Arrays.asList("a", "z", "h", "d");
        ordemLetras.sort(Comparator.naturalOrder());
        System.out.println(ordemLetras);
        System.out.println("#################################");
//        LAMBDA - 7
        Divisor divisor = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Divisão por ZERO !");
            return a / b;
        };
        try {
            System.out.println(divisor.executaDivisao(10, 2)); // Esperado: 5
            System.out.println(divisor.executaDivisao(10, 0)); // Esperado: Exceção
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
