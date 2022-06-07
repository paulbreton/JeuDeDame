package Listeners;

import models.Case;
import views.Plate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerCase implements MouseListener {

    private Case case1;
    private Plate plateau;


    public ListenerCase(Case case1, Plate plate) {
        super();
        this.case1 = case1;
        this.plateau = plate;
    }


    public void mouseClicked(MouseEvent arg0) {

    }


    public void mouseEntered(MouseEvent arg0) {

    }


    public void mouseExited(MouseEvent arg0) {

    }


    public void mousePressed(MouseEvent arg0) {
        if(case1.isSelectionnee()){
            plateau.deplacer(case1);
        }
    }


    public void mouseReleased(MouseEvent arg0) {

    }



}

