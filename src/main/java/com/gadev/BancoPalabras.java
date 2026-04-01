package com.gadev;

public class BancoPalabras {
    private static final String[] PALABRAS =  {
            "Gato", "Perro", "Auto", "Animal"
    };

    public String palabraAleatoria(){
        int indiceAleatorio = (int) (Math.random() * PALABRAS.length);
        return PALABRAS[indiceAleatorio];
    }
}
