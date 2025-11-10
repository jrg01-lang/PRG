package prueba.t;
import java.util.Scanner;
import prueba.t.UtilitatsConsola;
/**
 * @author joan
 */

public class UtilitatsArrays {
    /**
     * Mostra l'array de sencers que rep com a parĂ metre per pantalla
     *
     * @param array L'array que contĂ© els valors que volem mostrar per pantalla.
     */
    public static void mostraArray(int[] array) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < array.length; i++) {
            System.out.print(separador + array[i]);
            separador = ", ";
        }
        System.out.println(']');

    }
    
    public static int sumaArray(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; ++i){
           total += array[i];
        }
        
        return total;
    }
    public static void mitjanaArrays(int[] array) {
        int total = sumaArray(array);
        int totalnum = array.length;
        float mitjana = (float) total / (float) totalnum;
        System.out.println("Mitjana:" + mitjana);
    }
    public static int[] generaArray(int longitud, int minim, int maxim) {
        int[] array = new int[longitud];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = minim + (int) (Math.random() * (maxim - minim + 1));
        }

        return array;
    }
    public static String[] generaArrayAlumnes(int cantidad) {
        String[] array = new String[cantidad];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = UtilitatsConsola.llegirCadena("Escribe el nombre del alumno:");
        }
        
        return array;
    }
    public static boolean comparaArrays(int[] array1, int[] array2) {
        boolean sonIguals = true;
        
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    sonIguals = false;
                    break;
                }
            }
        } else {
            sonIguals = false;
        }
        return sonIguals;
    }
    public static int maximArray(int[] array){
        int maxim = array[0];
        for (int a : array)
            if (a > maxim)
                maxim = a;
        return maxim;
    }
    
    
    
    
    
    
    
    public static int minArray(int[] array){
        int min = array[0];
        for (int a : array)
            if (a < min)
                min = a;
        return min;
    }
    /**
     * Mostra l'array de double que rep com a parĂ metre per pantalla
     *
     * @param array L'array que contĂ© els valors que volem mostrar per pantalla.
     */
    /*
    public static void mostraArray(boolean[] array) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < array.length; i++) {
            System.out.print(separador + array[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a parĂ metre per pantalla
     *
     * @param array L'array que contĂ© els valors que volem mostrar per pantalla.
     */
    /*
    public static void mostraArray(double[] array) {
        String separador = "";
        System.out.print('[');

        for (int i = 0; i < array.length; i++) {
            System.out.print(separador + array[i]);
            separador = ", ";
        }
        System.out.println(']');
        System.out.println();
    }

    /**
     * Mostra l'array de double que rep com a parĂ metre per pantalla
     *
     * @param array L'array que contĂ© els valors que volem mostrar per pantalla.
     */
    /*
    public static void mostraArray(String[] array) {
        String separador = "";
        System.out.print('[');
        for (String a : array) {
            System.out.print(separador + a);
            separador = ", ";
        }
        System.out.println(']');
    }

    // ACT 4_1_2
    /**
     * Suma els sencers d'un array
     * @param array 
     * @return int.
     */
    /*
    public static int sumaArray(int[] array) {
        int suma = 0;
        
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    // ACT4_1_2
    /**
     * Suma els sencers d'un array
     * @param array 
     * @return int.
     */
    /*
    public static float mitjanaArray(int[] array) {
        int suma = sumaArray(array);
        int total = array.length;

        return ((float) suma/(float) total);
    }

    
    // ACT4_1_4
    /**
     * Genera un array de sencers de la longitud demanada
     * @param longitud La longitud de l'array
     * @param minim, el min valor
     * @param maxim, el max valor
     * @return L'array emplenat de forma aleatĂČria.
     */
    /*
    public static int[] generaArray(int longitud, int minim, int maxim) {
        int[] array = new int[longitud];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = minim + (int) (Math.random() * (maxim - minim + 1));
        }
        return array;
    }
     
    //ACT4_1_5
    /**
     * Compara dos arrrays de sencers de qualsevol longitud
     *
     * @param array1 El primer array
     * @param array2 El segon array
     * @return El resultat
     */
    /*
    public static boolean comparaArrays(int[] array1, int[] array2) {
        boolean sonIguals = true;
        
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    sonIguals = false;
                    break;
                }
            }
        } else {
            sonIguals = false;
        }
        return sonIguals;
    }
    */
}



