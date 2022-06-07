package Listeners;

import models.Couleur;
import models.Pion;
import views.Plate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerPion implements MouseListener {

    private Plate plate;
    private Pion pion;

    public ListenerPion(Pion pion, Plate plate){
        this.plate = plate;
        this.pion = pion;
    }

    public void mouseClicked(MouseEvent arg0) {

    }

    public void mouseEntered(MouseEvent arg0) {

    }

    public void mouseExited(MouseEvent arg0) {

    }

    public void mousePressed(MouseEvent arg0) {
        if (this.pion.getCouleur() == Couleur.BLANC) {
            plate.afficherPossibilitesBlanc(this.pion);
        } else {
            plate.afficherPossibilitesNoir(this.pion);
        }
    }

    public void mouseReleased(MouseEvent arg0) {

    }

}
