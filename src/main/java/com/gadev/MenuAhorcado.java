package com.gadev;

import java.util.Scanner;

public class MenuAhorcado {
    private final Scanner scanner;

    public MenuAhorcado(){
        this.scanner = new Scanner(System.in);
    }

    // Inicia el juego del ahorcado
    public void start(){

        // Bucle principal para permitir jugar varias veces
        boolean jugarDeNuevo = true;

        // Mientras el usuario quiera seguir jugando, se inicia una nueva partida
        while(jugarDeNuevo){
            //  Muestra un mensaje al empezar una nueva partida
            System.out.println("¡Adivina la palabra!");

            // Selecciona una palabra aleatoria del banco de palabras
            String palabra = BancoPalabras.palabraAleatoria();

            // Crea una nueva instancia del juego de ahorcado con la palabra seleccionada
            Ahorcado juego = new Ahorcado(palabra);

            // Bucle del juego, se repite hasta que el jugador gane o pierda
            while (!juego.estaGanado()  && !juego.estaPerdido()){
                // Muestra el estado actual del juego
                // (dibujo del ahorcado, el progreso de la palabra y las letras usadas)
                mostrarEstado(juego);
                // Pide al jugador que ingrese una letra y procesa su intento
                char letra = pedirLetra(juego);

                boolean intentar = juego.intentarLetra(letra);
            }

            // Una vez que el juego ha terminado, se muestra el resultado final
            mostrarResultadoFinal(juego);

            // Pregunta al jugador si desea jugar de nuevo
            jugarDeNuevo = preguntarJugarDeNuevo();

        }

        scanner.close();
        System.out.println("Gracias por jugar al ahorcado! ¡Hasta la próxima!");

    }

    private void mostrarEstado(Ahorcado juego){
        System.out.println(DibujoAhorcado.getFigure(juego.getIntentosFallidos()));
        System.out.println("Palabra : " + juego.getProgreso());
        System.out.println("Letras usadas : " + juego.getUsadas());
        System.out.println("Intentos restantes : " + juego.getIntentosRestantes());
    }

    private void mostrarResultadoFinal(Ahorcado juego){
        mostrarEstado(juego);
        if (juego.estaGanado()) {
            System.out.println("Ganaste!");
        } else {
            System.out.println("Perdiste! \nLa palabra era: " + juego.getPalabraSecreta() );
        }
    }

    private char pedirLetra(Ahorcado juego){
        while(true){
            System.out.print("Ingresa una letra: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() != 1){
                System.out.println("Ingresa una sola letra");
                continue;
            }

            char letra = input.charAt(0);

            if (!Character.isLetter(letra)){
                System.out.println("Solo se aceptan letras.");
                continue;
            }

            if (juego.getUsadas().contains(letra)){
                System.out.println("Ya utilizaste esta letra.");
                continue;
            }

            return letra;
        }
    }

    private boolean preguntarJugarDeNuevo(){
        System.out.print("Quiere jugar de nuevo? (S/N): ");
        String opcion = scanner.nextLine().toUpperCase().trim();
        return opcion.equals("S");
    }

}
