package sumaNegativos;

import java.util.Arrays;
import java.util.Scanner;

public class MainNoExceptions {
    private static final Scanner sc = new Scanner(System.in);

    private static int [][] inicializarArray (){
        int[][] numeros;
        numeros = new int [2][];
        numeros [0] = new int[5];
        numeros [1] = new int[5];
        return numeros;
    }

    private static int[] introducirNegativos (int[] negativos){
        boolean repetir;
        for (int i = 0; i < negativos.length; i++) {
            System.out.print("Introduzca un número negativo: ");
            negativos[i] = sc.nextInt();
            if (negativos [i] >= 0) {
                throw new IllegalArgumentException("Número no negativo."); //Excepción si los números no son negativos.
            }
            sc.nextLine();
        }
        return negativos;
    }

    private static int[] introducirPositivos (int[] positivos){
        boolean repetir;
        for (int i = 0; i < positivos.length; i++) {
            System.out.print("Introduzca un número positivo: ");
            positivos[i] = sc.nextInt();
            if (positivos [i] < 0) {
                throw new IllegalArgumentException("Número no positivo."); //Excepción si los números no son positivos.
            }
            sc.nextLine();
        }
        return positivos;
    }

    private static int sumarArray (int[] sumandos) {
        int suma = 0;
        for (int i = 0; i < sumandos.length; i++) {
            suma += sumandos[i];
        }
        return suma;
    }

    private static void menu (int[][] numeros) {
        int opcion = 1;
        System.out.println("Este programa permite gestionar un array bidimensional de números negativos y positivos.\nOpciones:\n1. Introducir valores en el array.\n2. Calcular la media.\n3.Calcular la suma.\n4. Mostrar el array ordenado de menor a mayor.\n0. Salir");
        while (opcion != 0) {
            System.out.println("Introduzca su opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    introducirNegativos(numeros[0]);
                    introducirPositivos(numeros[1]);
                    break;
                case 2:
                    System.out.println("Media del array de números negativos: " + (double) sumarArray(numeros[0]) / numeros[0].length);
                    System.out.println("Media del array de números positivos: " + (double) sumarArray(numeros[1]) / numeros[1].length);
                    System.out.println("Media de ambos arrays: " + (double) (sumarArray(numeros[0]) + sumarArray(numeros[1])) / (numeros[0].length + numeros[1].length));
                    break;
                case 3:
                    System.out.println("Suma del array de números negativos: " + sumarArray(numeros[0]));
                    System.out.println("Suma del array de números positivos: " + sumarArray(numeros[1]));
                    System.out.println("Suma de ambos arrays: " + (sumarArray(numeros[0]) + sumarArray(numeros[1])));
                    break;
                case 4:
                    Arrays.sort(numeros[0]);
                    Arrays.sort(numeros[1]);
                    System.out.println("Array bidimensional de números negativos y positivos: "+ Arrays.deepToString(numeros));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.err.println("Introduzca un número válido.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        menu(inicializarArray());
    }
}