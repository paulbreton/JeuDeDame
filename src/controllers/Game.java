package controllers;

import models.*;
import views.*;
import javax.swing.*;

public class Game  {

    private Player player1, player2;
    private Couleur Player1Color, Player2Color;
    private ScorePanel score_panel;
    private JFrame framePlate;
    private ControlPanel ctrlPan;


    public Game( )
    {
        this.player1 = new Player();
        this.player2 = new Player();
        this.ctrlPan = new ControlPanel("Jeu de dames", this);
        this.ctrlPan.setVisible(true);
    }

    public void setColorPlayer1( Couleur color)
    {
        this.player1.setColor(color);
    }

    public void decPawnWhite()
    {
        if( this.player1.getColor() == Couleur.BLANC) {
            this.player1.decrementPawn();
        }
        else {
            this.player2.decrementPawn();
        }
        this.score_panel.ChangePlayersPawnNbr();
    }

    public void decPawnBlack()
    {
        if( this.player1.getColor() == Couleur.NOIR) {
            this.player1.decrementPawn();
        }
        else {
            this.player2.decrementPawn();
        }
        this.score_panel.ChangePlayersPawnNbr();
    }

    public void setNamePlayer1( String name)
    {
        this.player1.setName(name);
    }

    public void setColorPlayer2( Couleur color)
    {
        this.player2.setColor(color);
    }

    public void setNamePlayer2( String name)
    {
        this.player2.setName(name);
    }

    public void startPlate()
    {
        this.framePlate = new JFrame();

        this.framePlate.setSize(600, 600);
        this.framePlate.setLocationRelativeTo(null);
        this.framePlate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.framePlate.add(new Plate(this));
        this.framePlate.setVisible(true);
    }

    public void startScorePanel()
    {
        this.score_panel = new ScorePanel( this.player1, this.player2);
        this.score_panel.setVisible(true);
    }
}
