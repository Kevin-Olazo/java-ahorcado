package com.gadev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ahorcado {
    private static final int MAX_INTENTOS = 6;

    private String palabraSecreta;
    private char[] progreso;
    private Set<Character> usadas;
    private int intentosRestantes;

    public Ahorcado(String palabra){
        this.palabraSecreta = palabra.toLowerCase();
        this.progreso = new char[this.palabraSecreta.length()];
        Arrays.fill(progreso, '_');
        this.usadas = new HashSet<>();
        this.intentosRestantes = MAX_INTENTOS;
    }

    public boolean intentarLetra(char letra){
        letra = Character.toLowerCase(letra);

        if (usadas.contains(letra)){
            System.out.println("Ya ingresaste esa letra");
            return false;
        }

        usadas.add(letra);
        boolean encontrado = false;

        for (int i = 0; i < palabraSecreta.length(); i++){
            if (letra == palabraSecreta.charAt(i)){
                progreso[i] = letra;
                encontrado = true;
            }
        }

        if (!encontrado) intentosRestantes--;

        return encontrado;
    }


}
