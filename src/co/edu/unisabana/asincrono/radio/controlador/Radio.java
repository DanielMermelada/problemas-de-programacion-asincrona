package co.edu.unisabana.asincrono.radio.controlador;

import co.edu.unisabana.asincrono.radio.entidad.Tulipanes;

public class Radio extends Thread {

    public Radio(String msg) {
        super(msg);
    }

    public void run() {
        for (int i = 0; i <= 24; i++) {
            System.out.println(this.getName());
            Vereda tulipanes = new Tulipanes();
        }
    }
}
