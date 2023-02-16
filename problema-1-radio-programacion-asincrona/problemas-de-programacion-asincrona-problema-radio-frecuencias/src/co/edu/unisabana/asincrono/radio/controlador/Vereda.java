package co.edu.unisabana.asincrono.radio.controlador;

public abstract class Vereda {

    public int CalidadSenal;

    public void obtenerSenal(){
        CalidadSenal = 0;
        System.out.println("Senal base");
    }

}
