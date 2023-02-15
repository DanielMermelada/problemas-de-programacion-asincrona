package co.edu.unisabana.asincrono.radio.entidad;

import co.edu.unisabana.asincrono.radio.controlador.Vereda;
import co.edu.unisabana.asincrono.radio.interfaz.Senal;

public class Chia extends Vereda implements Senal {

    @Override
    public void obtenerSenal(){
        CalidadSenal = 1;
        System.out.println("Chia tiene Senal buena, Calidad Senal: "+ CalidadSenal);
    }

}
