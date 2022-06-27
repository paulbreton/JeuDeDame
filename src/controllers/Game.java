package controllers;

import models.*;
import views.*;
import javax.swing.*;

public class Game  {

    private String Player1Name, Player2Name;
    private Couleur Player1Color, Player2Color;
    private ScorePanel score_panel;

    public Game( String name1, Couleur color1, String name2, Couleur color2)
    {
        JFrame f = new JFrame();

        this.Player1Name = name1;
        this.Player1Color = color1;
        this.Player2Name = name2;
        this.Player2Color = color2;

        f.setSize(600, 600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Plate());
        f.setVisible(true);


        score_panel = new ScorePanel( this.Player1Name, this.Player1Color, this.Player2Name, this.Player2Color);
        score_panel.setVisible(true);
    }
}
