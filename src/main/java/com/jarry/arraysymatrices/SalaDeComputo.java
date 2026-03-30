package com.jarry.arraysymatrices;
    import java.util.Scanner;
         public class SalaDeComputo {
          
    private static final int FILAS = 3;
    private static final int COLUMNAS = 4;

    public static void main(String[] args) {

        String[][] sala = new String[FILAS][COLUMNAS];
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    mostrarSala(sala);
                    break;

                case 2:
                    int fila = pedirNumero(scanner, "fila", FILAS);
                    int columna = pedirNumero(scanner, "columna", COLUMNAS);
                    String usuario = pedirUsuario(scanner);
                    registrarUso(sala, fila, columna, usuario);
                    mostrarSala(sala); // mostrar cambio
                    break;

                case 3:
                    fila = pedirNumero(scanner, "fila", FILAS);
                    columna = pedirNumero(scanner, "columna", COLUMNAS);
                    liberarEquipo(sala, fila, columna);
                    mostrarSala(sala); // mostrar cambio
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    // MENÚ//

    static void mostrarMenu() {
        System.out.println("\n=== CONTROL SALA DE COMPUTO ===");
        System.out.println("1. Ver estado de la sala");
        System.out.println("2. Ocupar un equipo");
        System.out.println("3. Liberar un equipo");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // ENTRADA//

    static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Error: Ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static int pedirNumero(Scanner scanner, String tipo, int max) {
        System.out.print("Ingrese " + tipo + " (1 a " + max + "): ");
        return leerEntero(scanner);
    }

    static String pedirUsuario(Scanner scanner) {
        scanner.nextLine(); // limpiar buffer
        System.out.print("Nombre del usuario: ");
        return scanner.nextLine();
    }

    // LÓGICA//

    static void mostrarSala(String[][] sala) {
        System.out.println("\n ESTADO DE LA SALA ");

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                String estado = (sala[i][j] == null)
                        ? "LIBRE"
                        : sala[i][j];

                System.out.print("[" + (i + 1) + "," + (j + 1) + ":" + estado + "]\t");
            }
            System.out.println();
        }
    }

    static void registrarUso(String[][] sala, int fila, int columna, String usuario) {
        int f = fila - 1;
        int c = columna - 1;

        if (!esValido(sala, f, c)) {
            System.out.println("Error: Posición inválida.");
            return;
        }

        if (sala[f][c] != null) {
            System.out.println("Error: Ya está ocupado por " + sala[f][c]);
        } else {
            sala[f][c] = usuario;
            System.out.println("Equipo asignado correctamente.");
        }
    }

    static void liberarEquipo(String[][] sala, int fila, int columna) {
        int f = fila - 1;
        int c = columna - 1;

        if (!esValido(sala, f, c)) {
            System.out.println("Error: Posición inválida.");
            return;
        }

        if (sala[f][c] == null) {
            System.out.println("Aviso: El equipo ya estaba libre.");
        } else {
            System.out.println("Equipo liberado de " + sala[f][c]);
            sala[f][c] = null;
        }
    }

    // UTILIDADES//

    static boolean esValido(String[][] sala, int f, int c) {
        return f >= 0 && f < sala.length && c >= 0 && c < sala[0].length;
    }
}