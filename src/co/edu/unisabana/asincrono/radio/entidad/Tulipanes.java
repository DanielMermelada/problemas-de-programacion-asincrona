package co.edu.unisabana.asincrono.radio.entidad;

import co.edu.unisabana.asincrono.radio.controlador.Vereda;
import co.edu.unisabana.asincrono.radio.interfaz.Senal;

public class Tulipanes extends Vereda implements Senal {

    @Override
    public void obtenerSenal(){
        CalidadSenal = 0;
        System.out.println("Tulipanes tiene Senal inexistente, Calidad Senal: "+ CalidadSenal);
    }

}
