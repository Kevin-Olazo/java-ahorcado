package com.gadev;

public class BancoPalabras {
    private static final String[] PALABRAS = {
            "Gato", "Perro", "Conejo"
    };

    public static String palabraAleatoria(){
        int indice = (int) (Math.random() * PALABRAS.length);
        return PALABRAS[indice];
    }
}
