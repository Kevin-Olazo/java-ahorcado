package com.gadev;

import java.util.Scanner;

public class MenuAhorcado {
    private Scanner scanner;

    public MenuAhorcado(){
        this.scanner = new Scanner(System.in);
    }

    public void start(){



        boolean jugarDeNuevo = true;

        while(jugarDeNuevo){
            String palabra = BancoPalabras.palabraAleatoria();
            Ahorcado juego = new Ahorcado(palabra);

            while (!juego.estaGanado() || !juego.estaPerdido()){

                char letra = pedirLetra(juego);
                juego.intentarLetra(letra);

                System.out.println(juego.getProgreso());
            }

            jugarDeNuevo = preguntarJugarDeNuevo();

        }

    }

    private char pedirLetra(Ahorcado juego){
        while(true){
            System.out.print("\nIngresa una letra:");
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
        String opcion = scanner.nextLine();
        return opcion.equals("S");
    }



}
