package views;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Listeners.*;
import models.*;


public class Plate extends JPanel {
    private Case caseActive;
    private Pion pionActive;

    private boolean tourNoir;

    private int[][] matrice = new int[10][10];
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
        afficherMatrice();
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

    public Case getCase(int i){
        return (Case) getComponent(i);
    }

    public void afficherPossibilitesBlanc(Pion p) {
        this.pionActive = p;
        resetPossibility();
        if(p.getCouleur().equals(Couleur.BLANC) && !tourNoir){
            int col = p.getCase().getCol();
            int row = p.getCase().getRow();

            if(this.matrice[row-1][col-1] == 0) {
                getCase(row-1, col-1).setSelectionnee(true);
            }

            if(this.matrice[row-1][col+1] == 0) {
                getCase(row-1, col+1).setSelectionnee(true);
            }
        } else {
            System.out.println("TOUR DES NOIRS");
        }
    }

    public void afficherPossibilitesNoir(Pion p) {
        this.pionActive = p;
        resetPossibility();
        if(p.getCouleur().equals(Couleur.NOIR) && tourNoir) {
            int col = p.getCase().getCol();
            int row = p.getCase().getRow();

            if (this.matrice[row + 1][col - 1] == 0) {
                getCase(row + 1, col - 1).setSelectionnee(true);
            }
            if (this.matrice[row + 1][col + 1] == 0) {
                getCase(row + 1, col + 1).setSelectionnee(true);
            }
        }else {
            System.out.println("TOUR DES BLANCS");
        }
    }

    public void selectionnerCases(int i, int j, Couleur couleur){
        Pion pion = (Pion)(getCase(i, j).getComponent(0));
        if(pion.isVisible()){
            if(i-1>=0 && j-1>=0 && getCase(i-1, j-1).getComponentCount()==0){
                getCase(i-1, j-1).setSelectionnee(true);
            }
            else if(i-2>=0 && j-2>=0 && getCase(i-2, j-2).getComponentCount()==0 && !((Pion)(getCase(i-1, j-1).getComponent(0))).getCouleur().equals(couleur)){
                getCase(i-2, j-2).setSelectionnee(true);
            }
            if(i-1>=0 && j+1<10 && getCase(i-1, j+1).getComponentCount()==0){
                getCase(i-1, j+1).setSelectionnee(true);
            }
            else if(i-2>=0 && j+2<10 && getCase(i-2, j+2).getComponentCount()==0 && !((Pion)(getCase(i-1, j+1).getComponent(0))).getCouleur().equals(couleur)){
                getCase(i-2, j+2).setSelectionnee(true);
            }
        }
        else{
            if(i+1<10 && j+1<10 && getCase(i+1, j+1).getComponentCount()==0){
                getCase(i+1, j+1).setSelectionnee(true);
            }
            else if(i+2<10 && j+2<10 && getCase(i+2, j+2).getComponentCount()==0 && !((Pion)(getCase(i+1, j+1).getComponent(0))).getCouleur().equals(couleur)){
                getCase(i+2, j+2).setSelectionnee(true);
            }
            if(i+1<10 && j-1>=0 && getCase(i+1, j-1).getComponentCount()==0){
                getCase(i+1, j-1).setSelectionnee(true);
            }
            else if(i+2<10 && j-2>=0 && getCase(i+2, j-2).getComponentCount()==0 && !((Pion)(getCase(i+1, j-1).getComponent(0))).getCouleur().equals(couleur)){
                getCase(i+2, j-2).setSelectionnee(true);
            }

        }
    }

    public void deplacer(Case case1) {
        resetPossibility();
        updateMatrice(this.pionActive.getCase(), case1, 2);
        this.pionActive.getCase().removeAll();
        this.pionActive.getCase().repaint();
        case1.add(this.pionActive);
        this.pionActive.setCase(case1);

        this.tourNoir = !this.tourNoir;
    }

    private int getLigne(Case case1){
        int res=0;
        for(int i=0; i<10*10; i+=2){
            if(getCase(i).equals(case1)){
                res=i/10;
            }
        }
        return res;
    }

    private int getColonne(Case case1){
        int res=0;
        for(int i=0; i<10*10; i+=2){
            if(getCase(i).equals(case1)){
                res=i%10;
            }
        }
        return res;
    }

    private void updateMatrice(Case oldC, Case newC, int value) {
        this.matrice[oldC.getRow()][oldC.getCol()] = 0;
        this.matrice[newC.getRow()][newC.getCol()] = value;
    }
    private void resetPossibility() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                getCase(i, j).setSelectionnee(false);
            }
        }
    }
    private void afficherMatrice() {
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                System.out.print(" "+this.matrice[i][j]);
            }
            System.out.println(" ");
        }
    }

}

