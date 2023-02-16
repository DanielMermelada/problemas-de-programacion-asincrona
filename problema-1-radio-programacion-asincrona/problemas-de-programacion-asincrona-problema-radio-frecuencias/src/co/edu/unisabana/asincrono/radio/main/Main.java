package co.edu.unisabana.asincrono.radio.main;

import co.edu.unisabana.asincrono.radio.controlador.Radio;

public class Main {
    public static void main(String[] args) {
        Thread hilo = new Radio("Emitiendo broadcast...");

        hilo.start();
    }
}
