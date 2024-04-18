package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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
}