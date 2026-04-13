package com.jarry.arraysymatrices;

public class Matrices {

    public static void main(String[] args) {

        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        imprimir(matriz);
        imprimirPorColumnas(matriz);

        System.out.println("Suma: " + sumar(matriz));

        intercambiarFilas(matriz);
        imprimir(matriz);
    }

    static void imprimir(int[][] m) {
        for (int[] fila : m) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    static void imprimirPorColumnas(int[][] m) {
        for (int j = 0; j < m[0].length; j++) {
            for (int i = 0; i < m.length; i++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int sumar(int[][] m) {
        int suma = 0;
        for (int[] fila : m) {
            for (int valor : fila) {
                suma += valor;
            }
        }
        return suma;
    }

    static void intercambiarFilas(int[][] m) {
        int[] temp = m[0];
        m[0] = m[m.length - 1];
        m[m.length - 1] = temp;
    }
}