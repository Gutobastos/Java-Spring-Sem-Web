package br.com.alura.screenmatch.exercicios;

public class Primo {
    public static boolean ehPrimo(int numero){
        if (numero < 2) return false; // Números menores que 2 não são primos
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Divisível por outro número que não 1 e ele mesmo
            }
        }
        return true;
    }
    }
