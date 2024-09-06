package com.mycompany.projeto.kleiton;

import java.util.*;

public class PROJETO14KLEITON {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        int[] vetorAuxiliar = new int[25];

        
        System.out.println("Digite os números inteiros para a matriz 5x5:");
        int contador = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = scanner.nextInt();
                vetorAuxiliar[contador++] = matriz[i][j];
            }
        }

        
        System.out.println("Matriz original:");
        exibirMatriz(matriz);

        
        Arrays.sort(vetorAuxiliar);
        contador = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = vetorAuxiliar[contador++];
            }
        }
        System.out.println("Matriz ordenada:");
        exibirMatriz(matriz);

        
        System.out.println("Soma de cada linha e coluna:");
        calcularSomas(matriz);

        
        System.out.println("Números repetidos e suas quantidades:");
        encontrarNumerosRepetidos(vetorAuxiliar);

        
        calcularSomasDiagonais(matriz);

        
        substituirPrimos(matriz);
        System.out.println("Matriz após substituição dos números primos por -1:");
        exibirMatriz(matriz);

        scanner.close();
    }

    
    private static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

   
    private static void calcularSomas(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            int somaLinha = 0;
            int somaColuna = 0;
            for (int j = 0; j < 5; j++) {
                somaLinha += matriz[i][j];
                somaColuna += matriz[j][i];
            }
            System.out.println("Soma da linha " + i + ": " + somaLinha);
            System.out.println("Soma da coluna " + i + ": " + somaColuna);
        }
    }

    
    private static void encontrarNumerosRepetidos(int[] vetor) {
        Map<Integer, Integer> frequencia = new HashMap<>();
        for (int num : vetor) {
            frequencia.put(num, frequencia.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Número " + entry.getKey() + " aparece " + entry.getValue() + " vezes.");
            }
        }
    }

   
    private static void calcularSomasDiagonais(int[][] matriz) {
        int somaPrincipal = 0;
        int somaSecundaria = 0;
        for (int i = 0; i < 5; i++) {
            somaPrincipal += matriz[i][i];
            somaSecundaria += matriz[i][4 - i];
        }
        System.out.println("Soma da diagonal principal: " + somaPrincipal);
        System.out.println("Soma da diagonal secundária: " + somaSecundaria);
    }

    
    private static boolean isPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    
    private static void substituirPrimos(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (isPrimo(matriz[i][j])) {
                    matriz[i][j] = -1;
                }
            }
        }
    }
}
