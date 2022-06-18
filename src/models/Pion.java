package models;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Pion extends JPanel {
    private Couleur couleur;
    private boolean isVisible=true;

    private boolean select=false;

    private Case myCase;

    public Pion(Couleur couleur, Case myCase) {
        this.couleur = couleur;
        this.myCase = myCase;
        setOpaque(false);
        initCouleur(couleur);
    }

    @Override
    public void paintComponent(Graphics g){
        g.fillOval(5, 5, getWidth()-10, getHeight()-10);
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setSelected(boolean select) {
        this.select = select;
        if(select) {
            initCouleur(Couleur.RED);
        } else {
            initCouleur(this.couleur);
        }
    }

    public void initCouleur(Couleur couleur){
        switch (couleur) {
            case BLANC :
                setForeground(Color.WHITE);
                setBackground(new Color(220, 220, 220));
                break;
            case NOIR :
                setForeground(new Color(70, 70, 70));
                setBackground(new Color(200, 200, 200));
                break;
            case RED :
                setForeground(Color.RED);
                setBackground(new Color(200, 200, 200));
                break;
        }
    }

    public Case getCase() {
        return this.myCase;
    }
    public boolean isSelect() {
        return select;
    }
    public void setCase(Case newCase) {
        this.myCase = newCase;
    }

}
