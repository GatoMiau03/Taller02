package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int MIN_DIAS = 2;
    private static final int MAX_DIAS = 31;
    private static final int LECTURAS_POR_DIA = 24;
    private int dias;
    private double[][] lecturas;
    private Random random;

    public Main() {
        Scanner scanner = new Scanner(System.in);
        reiniciarArreglo();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.mostrarMenu();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; // Inicializar la variable opcion

        do {
            System.out.println("\n==== MENÚ ====");
            System.out.println("[1] Mostrar sismo más intenso");
            System.out.println("[2] Mostrar sismos ≥ 4.0 grados Richter");
            System.out.println("[3] Reiniciar el arreglo con nuevos valores");
            System.out.println("[4] Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    mostrarSismoMasIntenso();
                    break;
                case 2:
                    mostrarSismosMayoresIgualA4();
                    break;
                case 3:
                    reiniciarArreglo();
                    break;
                case 4:
                    System.out.print("\n¿Está seguro que desea salir? (S/N): ");
                    String confirmacion = scanner.next().toUpperCase();
                    if (!confirmacion.equals("S")) {
                        opcion = 0;
                    }
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, ingrese un número entre 1 y 4.");
            }
        } while (opcion != 4);
    }

    public void reiniciarArreglo() {
        do {
            System.out.print("\nIngrese la cantidad de días (entre " + MIN_DIAS + " y " + MAX_DIAS + "): ");
            Scanner scanner = new Scanner(System.in);

            try {
                dias = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine();
                continue;
            }

            if (dias < MIN_DIAS || dias > MAX_DIAS) {
                System.out.println("La cantidad de días debe estar entre " + MIN_DIAS + " y " + MAX_DIAS + ".");
            }
        } while (dias < MIN_DIAS || dias > MAX_DIAS);

        lecturas = new double[dias][LECTURAS_POR_DIA];
        random = new Random();

        for (int fila = 0; fila < dias; fila++) {
            for (int columna = 0; columna < LECTURAS_POR_DIA; columna++) {
                lecturas[fila][columna] = 1.0 + random.nextDouble() * (9.9 - 1.0);
            }
        }
    }

    public void mostrarSismoMasIntenso() {
        double maxIntensidad = lecturas[0][0];
        int diaMax = 1;
        int horaMax = 0;

        for (int fila = 0; fila < dias; fila++) {
            for (int columna = 0; columna < LECTURAS_POR_DIA; columna++) {
                if (lecturas[fila][columna] > maxIntensidad) {
                    maxIntensidad = lecturas[fila][columna];
                    diaMax = fila + 1;
                    horaMax = columna;
                }
            }
        }

        System.out.printf("\nEl día %d, a las %d:00, se registró el sismo más intenso, con un valor de %.2f en la escala de Richter.", diaMax, horaMax, maxIntensidad);
    }

    public void mostrarSismosMayoresIgualA4() {
        for (int fila = 0; fila < dias; fila++) {
            int contador = 0;

            for (int columna = 0; columna < LECTURAS_POR_DIA; columna++) {
                if (lecturas[fila][columna] >= 4.0) {
                    contador++;
                }
            }

            System.out.printf("Día %d: %d veces%n", fila + 1, contador);
        }
    }
}
