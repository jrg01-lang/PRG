/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT4_6;

import java.util.ArrayList;
import prueba.t.UtilitatsArrays;
import prueba.t.UtilitatsClasses;
import prueba.t.UtilitatsConsola;
import prueba.t.UtilitatsMatrius;

/**
 *
 * @author Julen
 */
public class BuscaMinas {

    static int NTAULER;
    static int NBOMBES;
    static int FILA = 0;
    static int COLUMNA = 1;
    static int ACTIVO = 2;
    static int SIMBOL_BOMBA = 99;
    static int SIMBOL_BUIT = 0;
    static int SIMBOL_DESACTIVAT = 98;
    static int SIMBOL_DESCOBERT = 50;
    static int[][] tauler;
    static ArrayList<int[]> Bombes = new ArrayList<>();
    static ArrayList<int[]> Encontrades = new ArrayList<>();

    public static void main(String[] args) {
        NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NBOMBES = UtilitatsConsola.llegirSencer("Nombre de Bombes: ");
        tauler = new int[NTAULER][NTAULER];
        afegeixBombes(tauler, NBOMBES);
        afegeixNumeros(tauler);
        int fila;
        int columna;
        boolean perdiste = false;
        do {
            // Mostra el tauler
            //UtilitatsArrays.mostraArray(cuc);
            
            mostraTauler(tauler);
            UtilitatsClasses.mostrarArrayListIntprimitiu(Encontrades);
            // Cambia la posició del cuc
            fila = UtilitatsConsola.llegirSencer("SELECIONA UNA FILA -1:SORTIR: ");
            if (fila <= -1) {
                break;
            }

            columna = UtilitatsConsola.llegirSencer("SELECIONA UNA COLUMNA -1:SORTIR: ");
            if (columna <= -1) {
                break;
            }
            perdiste = Busqueda(fila, columna);

        } while (!perdiste);

    }

    public static void afegeixBombes(int[][] tauler, int NBOMBES) {
        int[] bombes;  // posicio nova fulla
        int nbombes = NBOMBES;
        boolean okbomba = true;

        do {
            bombes = UtilitatsArrays.generaArray(3, 0, NTAULER - 1);
            bombes[2] = SIMBOL_DESACTIVAT;
            if (tauler[bombes[0]][bombes[1]] == SIMBOL_BUIT) {
                tauler[bombes[0]][bombes[1]] = SIMBOL_BOMBA;
                nbombes--;
                Bombes.add(bombes);
            }
        } while (nbombes != 0);
    }

    public static void afegeixNumeros(int[][] tauler) {
        UtilitatsClasses.mostrarArrayListIntprimitiu(Bombes);
        for (int i = 0; i < Bombes.size(); i++) {
            int Fila = Bombes.get(i)[0];
            int Columna = Bombes.get(i)[1];
            int[] df = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
            for (int k = 0; k < 8; k++) {
                int nf = Fila + df[k];
                int nc = Columna + dc[k];

                // Comprobar que está dentro del tablero
                if (nf >= 0 && nf < tauler.length && nc >= 0 && nc < tauler[0].length) {

                    if (Check(nf, nc)) {   // Si no es bomba
                        tauler[nf][nc] += 1;
                    }
                }
            }

        }
    }

    public static boolean Check(int Fila, int Columna) {

        for (int i = 0; i < Bombes.size(); i++) {
            if (Bombes.get(i)[0] == Fila && Bombes.get(i)[1] == Columna) {
                return false;
            }
        }
        return true;
    }

    public static boolean Busqueda(int Fila, int Columna) {
        int[] df = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        if (Fila >= 0 && Fila < tauler.length && Columna >= 0 && Columna < tauler[0].length) {
            if (Check(Fila, Columna)) {   // Si no es bomba
                if (tauler[Fila][Columna] <= 0) {
                    tauler[Fila][Columna] = SIMBOL_DESCOBERT;
                    Busqueda(Fila, Columna);
                } else {
                    int[] array = {Fila, Columna};
                    boolean existe = false;
                    for (int[] pos : Encontrades) {
                        if (pos[0] == Fila && pos[1] == Columna) {
                            existe = true;
                            break;
                        }
                    }

                    if (!existe && tauler[Fila][Columna] >= 1 && tauler[Fila][Columna] <= 8) {
                        Encontrades.add(array);
                    }

                }
            } else {
                //PERDISTE ENCONTRASTE UNA BOMBA
                return true;
            }
        }
        for (int k = 0; k < 8; k++) {
            int nf = Fila + df[k];
            int nc = Columna + dc[k];

            // Comprobar que está dentro del tablero
            if (nf >= 0 && nf < tauler.length && nc >= 0 && nc < tauler[0].length) {
                if (Check(nf, nc)) {   // Si no es bomba
                    if (tauler[nf][nc] <= 0) {
                        tauler[nf][nc] = SIMBOL_DESCOBERT;
                        Busqueda(nf, nc);
                    } else {
                        int[] array = {nf, nc};
                        System.out.println(tauler[nf][nc] + " " + nf + " " + nc);
                        boolean existe = false;
                        for (int[] pos : Encontrades) {
                            if (pos[0] == nf && pos[1] == nc) {
                                existe = true;
                                break;
                            }
                        }

                        if (!existe && tauler[nf][nc] >= 1 && tauler[nf][nc] <= 8) {
                            Encontrades.add(array);
                        }
                    }
                } else {
                    //PERDISTE ENCONTRASTE UNA BOMBA
                    return true;
                }
            }
        }
        return false;
    }

    public static void mostraTauler(int[][] tauler) {
        
        for (int i = 0; i < NTAULER; i++) {
            System.out.print('|');
            for (int j = 0; j < NTAULER; j++) {
                String car = "   ";
                boolean print = true;
                if (tauler[i][j] == 0) {
                    car = "   ";
                }
                if (tauler[i][j] == 50) {
                    car = " x ";
                }

                if (tauler[i][j] >= 1 && tauler[i][j] <= 8) {
                    System.out.print(" " + tauler[i][j] + " ");
                    print = false;
                }
                if (print) {
                    System.out.print(car);
                }
                if (tauler[i][j] == SIMBOL_BOMBA) {
                    car = " ? ";
                }
            }
            System.out.println("|");
        }
        UtilitatsMatrius.mostrarMatriu(tauler);
    }
}
