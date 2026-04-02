package com.gadev;

import java.util.Scanner;

public class MenuAhorcado {
    private final Scanner scanner;

    public MenuAhorcado(){
        this.scanner = new Scanner(System.in);
    }

    public void start(){

        boolean jugarDeNuevo = true;

        while(jugarDeNuevo){
            String palabra = BancoPalabras.palabraAleatoria();
            Ahorcado juego = new Ahorcado(palabra);

            while (!juego.estaGanado()  && !juego.estaPerdido()){
                mostrarEstado(juego);
                char letra = pedirLetra(juego);
                juego.intentarLetra(letra);
            }

            mostrarResultadoFinal(juego);
            jugarDeNuevo = preguntarJugarDeNuevo();

        }

    }

    private void mostrarEstado(Ahorcado juego){
        System.out.println(DibujoAhorcado.getFigure(juego.getIntentosRestantes()));
        System.out.println(juego.getProgreso());
    }

    private void mostrarResultadoFinal(Ahorcado juego){

    }

    private char pedirLetra(Ahorcado juego){
        while(true){
            System.out.print("Ingresa una letra:");
            String input = scanner.nextLine().trim().toLowerCase();

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
        System.out.print("Quiere jugar de nuevo?: (S/N)");
        String opcion = scanner.nextLine().toLowerCase();
        return opcion.equals("s");
    }

}
