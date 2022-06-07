package models;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Pion extends JPanel {
    private Couleur couleur;
    private boolean isVisible=true;

    private Case myCase;

    public Pion(Couleur couleur, Case myCase) {
        this.couleur = couleur;
        this.myCase = myCase;
        setOpaque(false);
        switch (couleur) {
            case BLANC :
                setForeground(Color.WHITE);
                setBackground(new Color(220, 220, 220));
                break;
            case NOIR :
                setForeground(new Color(70, 70, 70));
                setBackground(new Color(200, 200, 200));
                break;
        }
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

    public void setVisibility(boolean visibility) {
        this.isVisible = visibility;
    }

    public Case getCase() {
        return this.myCase;
    }

    public void setCase(Case newCase) {
        this.myCase = newCase;
    }

}
