package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class Case extends JPanel {

    private Couleur couleur;
    private int row;
    private int col;
    private boolean selectionnee;
    private boolean possible;

    public Case(Couleur couleur, int row, int col){
        setLayout(new GridLayout(1,0));
        this.row = row;
        this.col = col;
        this.couleur=couleur;
        initCouleur();
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public boolean isSelectionnee() {
        return selectionnee;
    }
    public boolean isPossible() {
        return this.possible;
    }

    public void setSelectionnee(boolean selectionnee) {
        this.selectionnee = selectionnee;
        if(selectionnee){
            setBackground(Color.RED);
            setForeground(Color.RED);
        }
        else {
            initCouleur();
        }
    }

    public void setPossible(boolean possible) {
        this.possible = possible;
        if(possible){
            setBackground(new Color(150, 0, 0));
            setForeground(new Color(150, 0, 0));
        }
        else {
            initCouleur();
        }
    }

    private void initCouleur(){
        switch(couleur){
            case BLANC :
                setBackground(Color.WHITE);
                setForeground(new Color(200, 200, 200));

                break;
            case NOIR :
                setBackground(Color.GRAY);
                setForeground(new Color(20, 20, 20));
                break;
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public void paintComponent(Graphics g){
        g.fillRect(0, 0, getWidth(), getHeight());
    }


}
