package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void mostrarSismoMasIntenso() {
        Main app = new Main();
        app.reiniciarArreglo();

        app.lecturas = new double[][]{
                {2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.6, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2},
                {4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1}
        };

        app.mostrarSismoMasIntenso();

        String expectedOutput = "\nEl día 1, a las 7:00, se registró el sismo más intenso, con un valor de 4.60 en la escala de Richter.";
        assertEquals(expectedOutput, getConsoleOutput(), "El resultado de mostrarSismoMasIntenso() no coincide con el valor esperado");
    }

    private String getConsoleOutput() {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        Main.main(new String[0]);

        return out.toString().trim();
    }
}
