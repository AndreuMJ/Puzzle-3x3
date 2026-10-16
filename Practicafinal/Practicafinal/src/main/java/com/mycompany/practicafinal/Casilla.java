package com.mycompany.practicafinal;

import javax.swing.ImageIcon;

public class Casilla {
    private int id;
    private ImageIcon imagen;

    //Constructor amb l'id i la imatge per paràmetre
    public Casilla(int id, ImageIcon imagen) {
        this.id = id;
        this.imagen = imagen;
    }

    //Mètode que retorna l'id
    public int getId() {
        return id;
    }

    //Mètode que retorna la imatge
    public ImageIcon getImagen() {
        return imagen;
    }

    //Mètode que retorna si és buida
    public boolean esBuida() {
        return id == 0;
    }
}
