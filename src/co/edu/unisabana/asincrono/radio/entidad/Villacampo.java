package co.edu.unisabana.asincrono.radio.entidad;

import co.edu.unisabana.asincrono.radio.controlador.Vereda;
import co.edu.unisabana.asincrono.radio.interfaz.Senal;

public class Villacampo extends Vereda implements Senal {

    @Override
    public void obtenerSenal(){
        CalidadSenal = 2;
        System.out.println("Senal muy buena");
    }

}
