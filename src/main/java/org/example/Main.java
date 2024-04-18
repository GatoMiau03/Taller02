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