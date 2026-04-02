package com.gadev;

public class DibujoAhorcado {
    private static final String[] FIGURAS = {
            // 0 errores
            "  +------+\n" +
                    "  |      |\n" +
                    "         |\n" +
                    "         |\n" +
                    "         |\n" +
                    "         |\n" +
                    "=============",

            // 1 error — cabeza
            "  +------+\n" +
                    "  |      |\n" +
                    "  O      |\n" +
                    "         |\n" +
                    "         |\n" +
                    "         |\n" +
                    "============",

            // 2 errores — cuerpo
            "  +------+\n" +
                    "  |      |\n" +
                    "  O      |\n" +
                    "  |      |\n" +
                    "         |\n" +
                    "         |\n" +
                    "============",

            // 3 errores — brazo izquierdo
            "  +------+\n" +
                    "  |      |\n" +
                    "  O      |\n" +
                    " /|      |\n" +
                    "         |\n" +
                    "         |\n" +
                    "============",

            // 4 errores — ambos brazos
            "  +------+\n" +
                    "  |      |\n" +
                    "  O      |\n" +
                    " /|\\     |\n" +
                    "         |\n" +
                    "         |\n" +
                    "============",

            // 5 errores — pierna izquierda
            "  +------+\n" +
                    "  |      |\n" +
                    "  O      |\n" +
                    " /|\\     |\n" +
                    " /       |\n" +
                    "         |\n" +
                    "============",

            // 6 errores — completo
            "  +------+\n" +
                    "  |      |\n" +
                    "  O      |\n" +
                    " /|\\     |\n" +
                    " / \\     |\n" +
                    "         |\n" +
                    "============"
    };


    public static String getFigure(int indice){
        return FIGURAS[indice];
    }
}
