package views;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Listeners.*;
import models.*;


public class Plate extends JPanel {
    private Pion pionActive;
    private Pion pionSelect;
    private final ArrayList<Pion> listDeletePion = new ArrayList<Pion>();
    public ArrayList<Pion> listDefenitiveDelete = new ArrayList<Pion>();
    private boolean tourNoir;
    private final int[][] matrice = new int[10][10];

    public Plate(){
        tourNoir=false;
        setLayout(new GridLayout(10, 10));
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
                    ajouterCase(Couleur.NOIR, i, j);
                    this.matrice[i][j]=0;
                }
                else{
                    ajouterCase(Couleur.BLANC, i, j);
                    this.matrice[i][j]=-1;
                }
            }
        }
        initPionNoir();
        initPionBlanc();
    }

    private void ajouterCase(Couleur couleur, int row, int col){
        Case case1 = new Case(couleur, row, col);
        case1.addMouseListener(new ListenerCase(case1, this));
        add(case1);
    }

    private Pion creerPion(Couleur couleur, Case case1){
        Pion pion = new Pion(couleur, case1);
        pion.addMouseListener(new ListenerPion(pion, this));
        return pion;
    }

    private void initPionBlanc() {
        for(int i = 9; i > 5; i--) {
            for (int j=0; j<10; j++) {
                Case case1 = getCase(i, j);
                if(case1.getCouleur() == Couleur.NOIR) {
                    case1.add(creerPion(Couleur.BLANC, case1));
                    this.matrice[i][j]=2;
                }
            }
        }
    }

    private void initPionNoir() {
        for(int i = 0; i < 4; i++) {
            for (int j=0; j<10; j++) {
                Case case1 = getCase(i, j);
                if(case1.getCouleur() == Couleur.NOIR) {
                    case1.add(creerPion(Couleur.NOIR, case1));
                    this.matrice[i][j]=1;
                }
            }
        }
    }

    public Case getCase(int i, int j){
        return (Case) getComponent(j+i*10);
    }

    public Pion getPion(int i, int j) {
        return (Pion) (getCase(i,j).getComponent(0));
    }

    public void showPossibilities(Pion pion) {
        if((pion.isSelect() && pion.getCouleur() == Couleur.BLANC) || (!pion.isSelect() && pion.getCouleur() == Couleur.NOIR)) {
            this.afficherPossibilitesNoir(pion.getCase().getRow()+1, pion.getCase().getCol()-1);
            this.afficherPossibilitesNoir(pion.getCase().getRow()+1, pion.getCase().getCol()+1);
        } else {
            this.afficherPossibilitesBlanc(pion.getCase().getRow()-1, pion.getCase().getCol()-1);
            this.afficherPossibilitesBlanc(pion.getCase().getRow()-1, pion.getCase().getCol()+1);
        }
    }

    public void afficherPossibilitesBlanc(int row, int col) {
        if(this.isInPlate(row, col) && !this.tourNoir){
            if(this.getMatrice(row, col) == 0) {
                if(this.pionSelect.getCase().getRow() - row == 1) {
                    this.getCase(row, col).setSelectionnee(true);
                } else {
                    this.getCase(row, col).setPossible(true);
                }
                if(this.getMatrice(row-1, col-1) == 1 && (this.pionActive.getCase().getRow() - (row-1)) > 2) {
                    this.afficherPossibilitesBlanc(row-1, col-1);
                }
                if(this.getMatrice(row-1, col+1) == 1 && (this.pionActive.getCase().getRow() - (row-1)) > 2) {
                    this.afficherPossibilitesBlanc(row-1, col+1);
                }
            }
            if(this.getMatrice(row, col) == 1 && this.getMatrice(row-1, col-1) == 0 && this.pionSelect.getCouleur() != Couleur.NOIR) {
                this.getPion(row, col).setSelected(true);
                this.listDeletePion.add(this.getPion(row, col));
                this.afficherPossibilitesBlanc(row-1, col-1);
            }
            if(this.getMatrice(row, col) == 1 && this.getMatrice(row-1, col+1) == 0 && this.pionSelect.getCouleur() != Couleur.NOIR) {
                this.getPion(row, col).setSelected(true);
                this.listDeletePion.add(this.getPion(row, col));
                this.afficherPossibilitesBlanc(row-1, col+1);
            }
        }
    }

    public void afficherPossibilitesNoir(int row, int col) {
        if(this.isInPlate(row, col) && this.tourNoir){
            if(this.getMatrice(row, col) == 0) {
                if(row - this.pionSelect.getCase().getRow() == 1) {
                    this.getCase(row, col).setSelectionnee(true);
                } else {
                    this.getCase(row, col).setPossible(true);
                }
                if(this.getMatrice(row+1, col-1) == 2 && (row+1 - this.pionActive.getCase().getRow()) > 2) {
                    this.afficherPossibilitesNoir(row+1, col-1);
                }
                if(this.getMatrice(row+1, col+1) == 2 && (row+1 - this.pionActive.getCase().getRow()) > 2) {
                    this.afficherPossibilitesNoir(row+1, col+1);
                }
            }
            if(this.getMatrice(row, col) == 2 && this.getMatrice(row+1, col-1) == 0 && this.pionSelect.getCouleur() != Couleur.BLANC) {
                this.getPion(row, col).setSelected(true);
                this.listDeletePion.add(this.getPion(row, col));
                this.afficherPossibilitesNoir(row+1, col-1);
            }
            if(this.getMatrice(row, col) == 2 && this.getMatrice(row+1, col+1) == 0 && this.pionSelect.getCouleur() != Couleur.BLANC) {
                this.getPion(row, col).setSelected(true);
                this.listDeletePion.add(this.getPion(row, col));
                this.afficherPossibilitesNoir(row+1, col+1);
            }
        }
    }

    public void deplacer(Case case1) {
        resetPossibility();
        if (this.tourNoir) {
            updateMatrice(this.pionActive.getCase(), case1, 1);
        } else {
            updateMatrice(this.pionActive.getCase(), case1, 2);
        }
        this.pionActive.getCase().removeAll();
        this.pionActive.getCase().repaint();
        case1.add(this.pionActive);
        this.pionActive.setCase(case1);

        this.tourNoir = !this.tourNoir;
        for (Pion pion : this.listDefenitiveDelete) {
            pion.getCase().removeAll();
            pion.getCase().repaint();
            this.matrice[pion.getCase().getRow()][pion.getCase().getCol()] = 0;
        }
        this.resetDeletePion();
        this.listDefenitiveDelete.clear();
    }

    private void updateMatrice(Case oldC, Case newC, int value) {
        this.matrice[oldC.getRow()][oldC.getCol()] = 0;
        this.matrice[newC.getRow()][newC.getCol()] = value;
    }

    public void resetPossibility() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                getCase(i, j).setSelectionnee(false);
                getCase(i, j).setPossible(false);
            }
        }
    }

    public void resetDeletePion() {
        for (Pion pion: this.listDeletePion) {
            pion.setSelected(false);
        }
        this.listDeletePion.clear();
    }

    public void resetDeleteDefinitivePion() {
        for (Pion pion: this.listDefenitiveDelete) {
            pion.setSelected(false);
        }
        this.listDefenitiveDelete.clear();
    }

    public void setPionActive(Pion p) {
        this.pionActive = p;
    }

    public void setPionSelect(Pion p) {
        System.out.println(p.getCase().getRow());
        this.pionSelect = p;
    }

    private boolean isInPlate(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }

    private int getMatrice(int row, int col) {
        return isInPlate(row, col) ? this.matrice[row][col] : -1;
    }
}

