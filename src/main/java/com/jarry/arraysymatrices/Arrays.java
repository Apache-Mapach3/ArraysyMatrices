package com.jarry.arraysymatrices;
    import java.util.Random;
    import java.util.Scanner;
        public class Arrays {
            public static void main(String[] args) {
        // Declaracion y creacion de arreglo//
        int[] numeros = crearArreglo(10);
        llenarAleatorio(numeros);
        // Recorrido y mostrar//
        System.out.println("Arreglo original (en for clasico):");
        imprimirClasico(numeros);
        // Modifica//
        reemplazarImpares(numeros);
        multiplicarPorIndice(numeros);

        System.out.println("\nArreglo modificado (en for-each):");
        imprimir(numeros);
        // Busca//
        int valorBuscado = pedirValor();
        buscar(numeros, valorBuscado);
    }

    static int[] crearArreglo(int tamaño) {
        return new int[tamaño];
    }

    static void llenarAleatorio(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
    }

    // For clasico//
    static void imprimirClasico(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // For each//
    static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void reemplazarImpares(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = 0;
            }
        }
    }

    static void multiplicarPorIndice(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= i;
        }
    }

    static int pedirValor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el valor a buscar: ");
        int valor = sc.nextInt();
        sc.close();
        return valor;
    }

    static void buscar(int[] arr, int valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) {
                System.out.println("Valor encontrado en el índice: " + i);
                return;
            }
        }
        System.out.println("Valor no encontrado.");
    }
}