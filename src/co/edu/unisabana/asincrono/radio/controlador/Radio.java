package co.edu.unisabana.asincrono.radio.controlador;

import co.edu.unisabana.asincrono.radio.entidad.Chia;
import co.edu.unisabana.asincrono.radio.entidad.Tulipanes;
import co.edu.unisabana.asincrono.radio.entidad.Villacampo;

public class Radio extends Thread {

    public Radio(String msg) {
        super(msg);
    }

    public void run() {
        for (int i = 0; i <= 24; i++) {
            try {
                sleep(1000);
                System.out.println(this.getName());
                Vereda tulipanes = new Tulipanes();
                Vereda chia = new Chia();
                Vereda villacampo = new Villacampo();
                tulipanes.obtenerSenal();
                chia.obtenerSenal();
                villacampo.obtenerSenal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
