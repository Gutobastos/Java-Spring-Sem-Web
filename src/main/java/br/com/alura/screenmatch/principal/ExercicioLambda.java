package br.com.alura.screenmatch.principal;

import java.util.*;

public class ExercicioLambda {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

//        Operacao multiplicar = new Operacao() {
//            @Override
//            public int executar(int a, int b) {
//                return a * b;
//            }
//        };
        //LAMBDA - 1
        Operacao multiplicar = (a, b) -> a * b;
        System.out.println(multiplicar.executar(5, 5));

        System.out.println("#################################");
//        int numero = 5;
//        for (int testePrimo = 1 ; testePrimo <=  numero ; testePrimo++) {
//            int total = numero % testePrimo;
//            System.out.println(numero);
//            if (total != 0) {
//                System.out.println("Não é primo");
//            } else {
//                testePrimo = numero;
//                System.out.println("É primo");
//            }
//        }
        //LAMBDA - 2
        System.out.println("Informe um número para saber se é PRIMO: ");
        int numero = leitura.nextInt();
        int prova = 0;
        ArrayList<Integer> listaRestos = new ArrayList<>();

        for (int testePrimo = 1; testePrimo <= numero; testePrimo++) {
            int total = numero % testePrimo;
            listaRestos.add(total);
        }
        for (int i = 0; i < listaRestos.size(); i++) {
            if (listaRestos.get(i) == 0 ) {
                prova++;
            }
        }
        if (prova > 2 || numero == 1) {
            System.out.println("NÃO É PRIMO: " + numero);
        }
        else if (listaRestos.get(0) == 0 && listaRestos.get(numero-1) == 0) {
            System.out.println("É PRIMO: " + numero);
        }

        System.out.println("#################################");
        System.out.println("Escreva uma letra, palavras ou texto para ficar em maiúsculas: ");
        String texto = "fim";
        System.out.println("Texto: " + texto.toUpperCase());
        System.out.println("#################################");
    }
}
