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
        plate.resetPossibility();
        plate.setPionSelect(this.pion);
        if (this.pion.isSelect()) {
            plate.resetDeletePion();
            plate.listDefenitiveDelete.add(this.pion);
            this.pion.setSelected(true);
            if (this.pion.getCouleur() == Couleur.BLANC) {
                plate.afficherPossibilitesNoir(this.pion.getCase().getRow()+1, this.pion.getCase().getCol()-1);
                plate.afficherPossibilitesNoir(this.pion.getCase().getRow()+1, this.pion.getCase().getCol()+1);
            }  else {
                plate.afficherPossibilitesBlanc(this.pion.getCase().getRow()-1, this.pion.getCase().getCol()-1);
                plate.afficherPossibilitesBlanc(this.pion.getCase().getRow()-1, this.pion.getCase().getCol()+1);
            }
        } else {
            plate.setPionActive(this.pion);
            if (this.pion.getCouleur() == Couleur.BLANC) {
                plate.afficherPossibilitesBlanc(this.pion.getCase().getRow()-1, this.pion.getCase().getCol()-1);
                plate.afficherPossibilitesBlanc(this.pion.getCase().getRow()-1, this.pion.getCase().getCol()+1);
            }  else {
                plate.afficherPossibilitesNoir(this.pion.getCase().getRow()+1, this.pion.getCase().getCol()-1);
                plate.afficherPossibilitesNoir(this.pion.getCase().getRow()+1, this.pion.getCase().getCol()+1);
            }
        }
    }

    public void mouseReleased(MouseEvent arg0) {

    }

}
