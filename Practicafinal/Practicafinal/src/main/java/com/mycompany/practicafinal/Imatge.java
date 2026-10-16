package com.mycompany.practicafinal;

import javax.swing.ImageIcon;

public class Imatge {
    private ImageIcon[] trosos;

    //Constructor, crea una llista d'imatges i les carrega
    public Imatge() {
        trosos = new ImageIcon[9];
        carregarImatges();
    }

    //Mètode que carrega les imatges
    private void carregarImatges() {
        int index = 0;
        //Doble bucle pel nom que li hem posat a les imatges
        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                //Deixam la posició (2,2) buida
                if (fil == 2 && col == 2) {
                    trosos[index] = null;
                  
                } 
                //Cercam la imatge corresponent  la carpeta "imagenes"
                else {
                    String nom = "imagenes/" + col + fil + ".png";
                    trosos[index] = new ImageIcon(nom);
                }
                index++;
            }
        }
    }

    //Retorna la imatge número "paràmetre" de la llista
    public ImageIcon getTros(int index) {
        return trosos[index];
    }
}
