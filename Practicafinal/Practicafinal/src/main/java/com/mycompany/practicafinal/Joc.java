package com.mycompany.practicafinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Joc extends JFrame {
    private Container panelContenidos;  
    private Puzzle puzzle;
    private JLabel[][] paneles;

    //Mètode main
    public static void main(String[] args) {
    //Crear i mostrar la interfície gràfica de forma segura
    new Joc().metodoPrincipal();
}
    
    public void metodoPrincipal() {
        //Inicialització del tauler 3x3
        Imatge imatge = new Imatge();
        puzzle = new Puzzle(imatge);
        paneles = new JLabel[3][3];

        //Configuració finestra principal
        setTitle("Trencaclosques");
        Dimension dimensioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int amplada = dimensioPantalla.width / 2;
        int alçada = dimensioPantalla.height / 2;
        setSize(amplada, alçada);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Collir el content pane
        panelContenidos = getContentPane();
        panelContenidos.setLayout(new BorderLayout());

        //Inicialització i afegiment del menú
        inicialitzarMenu();

        //Creació del tauler i afegiment al contenidor
        JPanel panelTauler = inicialitzarTauler();
        panelContenidos.add(panelTauler, BorderLayout.CENTER);

        //Refrescar el contingut del tauler
        refrescarTauler();

        //Listener de teclat
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char tecla = e.getKeyChar();
                puzzle.moure(tecla);
                refrescarTauler();
                comprobarVictoria();
            }
        });
        setVisible(true);
    }

    //Mètode per inicialitzar el menú
    private void inicialitzarMenu() {
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuJoc = new JMenu("Joc");

        JMenuItem itemInicialitzar = new JMenuItem("Inicialitzar");
        JMenuItem itemEscapçar = new JMenuItem("Escapçar");
        JMenuItem itemSortir = new JMenuItem("Sortir");
        
        //Posa el joc en posició de victòria
        itemInicialitzar.addActionListener(e -> {
            puzzle.inicialitzar();
            refrescarTauler();
        });
        
        //Posa aleatoriament les peces
        itemEscapçar.addActionListener(e -> {
            puzzle.escapçar();
            refrescarTauler();
        });

        //Acaba el joc i tanca la pantalla
        itemSortir.addActionListener(e -> System.exit(0));

        //Afegim els items al menu
        menuJoc.add(itemInicialitzar);
        menuJoc.add(itemEscapçar);
        menuJoc.add(itemSortir);
        //Afegim el menu a la barra
        barraMenu.add(menuJoc);

        //Afegim la barra menu adalt del content pane
        panelContenidos.add(barraMenu, BorderLayout.NORTH);
    }

    //Mètode per començar el joc
    private JPanel inicialitzarTauler() {
    JPanel panelTauler = new JPanel(new GridLayout(3, 3));

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            paneles[i][j] = new JLabel();
            paneles[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            paneles[i][j].setVerticalAlignment(SwingConstants.CENTER);
            //Afegir les lineas de separació
            paneles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            panelTauler.add(paneles[i][j]);
        }
    }
    //Afegim un listener per quan canvii la mida de la finestra
    panelTauler.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            refrescarTauler();
        }
    });
    return panelTauler;
 }

    //Mètode per refrescar el tauler amb redimensionament
    private void refrescarTauler() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = puzzle.getCasella(i, j);
                if (casilla.esBuida()) {
                    paneles[i][j].setIcon(null);
                } else {
                    ImageIcon icon = casilla.getImagen();
                    //Aquí feim el redimensionat
                    if (icon != null) {
                        Image img = icon.getImage();
                        int ample = paneles[i][j].getWidth();
                        int altura = paneles[i][j].getHeight();
                        if (ample == 0 || altura == 0) {
                            ample = 120;
                            altura = 120;
                        }
                        Image escalada = img.getScaledInstance(ample, altura, Image.SCALE_SMOOTH);
                        paneles[i][j].setIcon(new ImageIcon(escalada));
                    } else {
                        paneles[i][j].setIcon(null);
                    }
                }
            }
        }
    }

    //Mètode que compova si has guanyat, si és així mostra un panell de victòria
    private void comprobarVictoria() {
        if (puzzle.estaResolt()) {
            JOptionPane.showMessageDialog(this, "¡Enhorabona! Has resolt el trencaclosques.", "Victoria", JOptionPane.INFORMATION_MESSAGE);
        }
    }


}
