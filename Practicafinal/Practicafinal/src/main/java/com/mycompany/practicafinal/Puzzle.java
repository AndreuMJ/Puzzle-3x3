
package com.mycompany.practicafinal;

import java.util.Random;

public class Puzzle {
    private Casilla[][] tauler;
    private int filaBuida;
    private int columnaBuida;
    private Imatge imatge;
    private final int mida = 3;

    //Mètode constructor amb una imatge
    public Puzzle(Imatge imatge) {
        this.imatge = imatge;
        tauler = new Casilla[mida][mida];
        //Cream el puzle i l'escapçam
        inicialitzar();
        escapçar();
    }

    //Mètode per inicialitzar el puzzle
    public void inicialitzar() {
        int index = 0;
        //Doble bucle per posar al 3x3 les 8 imatges
        for (int i = 0; i < mida; i++) {
            for (int j = 0; j < mida; j++) {
                if (index < 8) {
                    tauler[i][j] = new Casilla(index + 1, imatge.getTros(index));
                } 
                //Deixam l'espai en blanc
                else {
                    tauler[i][j] = new Casilla(0, null);
                    filaBuida = i;
                    columnaBuida = j;
                }
                index++;
            }
        }
    }

    //Mètode que posa aleatoriament les caselles
    public void escapçar() {
        Random random = new Random();
        Casilla[] llista = new Casilla[9];
        int index = 0;

        //Cream una llista amb les caselles
        for (int i = 0; i < mida; i++) {
            for (int j = 0; j < mida; j++) {
                llista[index++] = tauler[i][j];
            }
        }

        //Posam aleatoriament les caselles a la llista
        for (int i = llista.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Casilla temp = llista[i];
            llista[i] = llista[j];
            llista[j] = temp;
        }

        //Tornam a fer el tauler amb la llista aleatoria
        index = 0;
        for (int i = 0; i < mida; i++) {
            for (int j = 0; j < mida; j++) {
                tauler[i][j] = llista[index];
                if (tauler[i][j].esBuida()) {
                    filaBuida = i;
                    columnaBuida = j;
                }
                index++;
            }
        }
    }

    //Mètode per moure la casella buida
    public void moure(char direccio) {
        int novaFila = filaBuida;
        int novaColumna = columnaBuida;

        //Moure depenent de la tecla
        switch (direccio) {
            case 'w' -> novaFila--;
            case 's' -> novaFila++;
            case 'a' -> novaColumna--;
            case 'd' -> novaColumna++;
            default -> {
                return;
            }
        }

        //Canviar la fila/columna segons la tecla
        //Control per no tenir una fila/columna a -1, no es mou res si es vol anar a -1
        if (novaFila >= 0 && novaFila < mida && novaColumna >= 0 && novaColumna < mida) {
            tauler[filaBuida][columnaBuida] = tauler[novaFila][novaColumna];
            tauler[novaFila][novaColumna] = new Casilla(0, null);
            filaBuida = novaFila;
            columnaBuida = novaColumna;
        }
    }

    //Mètode que comprova si has guanyat
    public boolean estaResolt() {
        //Recorr la matriu i el "contador" sempre ha de ser igual a l'id de la casella
        int contador = 1;
        for (int i = 0; i < mida; i++) {
            for (int j = 0; j < mida; j++) {
                //La casella buida ha d'estar a la posició (2,2)
                if (i == 2 && j == 2) {
                    return tauler[i][j].esBuida();
                }
                if (tauler[i][j].getId() != contador) {
                    return false;
                }
                contador++;
            }
        }
        return true;
    }

    //Mètode que torna la casella d'una posició del taule
    public Casilla getCasella(int fila, int columna) {
        return tauler[fila][columna];
    }
}
