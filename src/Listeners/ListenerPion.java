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
        this.plate.resetPossibility();
        this.plate.setPionSelect(this.pion);
        if (this.pion.isSelect()) {
            this.plate.listDefenitiveDelete.add(this.pion);
            this.pion.setSelected(true);
        } else {
            this.plate.resetDeleteDefinitivePion();
            this.plate.resetDeletePion();
            this.plate.setPionActive(this.pion);
        }
        this.plate.showPossibilities(this.pion);
    }

    public void mouseReleased(MouseEvent arg0) {

    }

}
