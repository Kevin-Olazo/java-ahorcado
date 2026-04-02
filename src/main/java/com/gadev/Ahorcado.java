package com.gadev;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ahorcado {
    // Número máximo de intentos permitidos antes de perder el juego
    private static final int MAX_INTENTOS = 6;

    // Atributos
    private final String palabraSecreta;
    private final char[] progreso;
    private final Set<Character> usadas;
    private int intentosRestantes;

    // Constructor que inicializa el juego.
    public Ahorcado(String palabra){
        this.palabraSecreta = palabra.toUpperCase();
        this.progreso = new char[this.palabraSecreta.length()];
        Arrays.fill(progreso, '_');
        this.usadas = new HashSet<>();
        this.intentosRestantes = MAX_INTENTOS;
    }

    // Método que procesa la letra ingresada por el jugador.
    public boolean intentarLetra(char letra){
        // Convertimos la letra a mayúscula
        letra = Character.toUpperCase(letra);

        // Verificamos si la letra ya ha sido usada anteriormente.
        // Si es así, no se permite volver a usarla y se devuelve false.
        if (usadas.contains(letra)){
            return false;
        }

        // Agregamos la letra al conjunto de letras usadas para evitar que se vuelva a usar en el futuro.
        usadas.add(letra);
        // iniciamos una variable para saber si la letra ingresada se encuentra en la palabra secreta
        boolean encontrado = false;

        // Recorremos la palabra secreta para verificar si la letra ingresada coincide con alguna de las letras de la palabra.
        for (int i = 0; i < palabraSecreta.length(); i++){
            if (letra == palabraSecreta.charAt(i)){
                progreso[i] = letra;
                encontrado = true;
            }
        }

        if (!encontrado) intentosRestantes--;

        return encontrado;
    }

    // Verifica si el jugador ha ganado el juego al revisar si hay algún guion bajo.
    public boolean estaGanado(){
        for (char c : progreso){
            if (c == '_') return false;
        }

        return true;
    }

    //  Verifica si el jugador ha perdido el juego al revisar si los intentos restantes son cero.
    public boolean estaPerdido(){
        return intentosRestantes == 0;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public int getIntentosFallidos() {
        // Calculamos los intentos fallidos restando los intentos restantes del máximo permitido
        return MAX_INTENTOS - intentosRestantes;
    }

    public Set<Character> getUsadas() {
        // Devolvemos una copia inmutable del conjunto de letras usadas para evitar modificaciones externas
        return Collections.unmodifiableSet(usadas);
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public String getProgreso() {
        //
        StringBuilder sb = new StringBuilder();
        for(char c : progreso){
            sb.append(c).append(' ');
        }
        return sb.toString().trim();
    }
}
