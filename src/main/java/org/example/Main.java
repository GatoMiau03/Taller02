package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main{
public void mostrarMenu() {
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;
    do {
        System.out.println("\n Menú");
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

    public static void main(String[] args) {
        Main app = new Main();
        app.mostrarMenu();
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



    lecturas = new double[dias][LECTURAS_POR_DIA];
    random = new Random();

        for (int fila = 0; fila < dias; fila++) {
        for (int columna = 0; columna < LECTURAS_POR_DIA; columna++) {
            lecturas[fila][columna] = 1.0 + random.nextDouble() * (9.9 - 1.0);
        }
    }
}
