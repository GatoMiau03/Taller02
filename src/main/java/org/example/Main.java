package org.example;
public class Main {
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
}