package views;

import models.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ScorePanel extends JFrame
{
	private Player player1, player2;
	private JLabel labelScore1, labelScore2;
	private JLabel labelPlayer1, labelPlayer2;

	public ScorePanel( Player player1, Player player2)
	{
		this.player1 = player1;
		this.player2 = player2;

	    this.setSize(450,150);
	    this.setTitle("Score");
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setLayout(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.buildScoreWindow();
	}

	public void ChangePlayersPawnNbr() {
		String text1 = "Nbr pawns = " + player1.getPawnNumber();
		String text2 = "Nbr pawns = " + player2.getPawnNumber();

		this.labelScore1.setText( text1 );
		this.labelScore2.setText( text2 );
	}


	private void buildScoreWindow()
	{
		StringBuilder textPlayer1, textPlayer2;
		String PlayColor;


		textPlayer1 = new StringBuilder("Player 1 : ");
		textPlayer1.append(this.player1.getName());
		this.labelPlayer1 = new JLabel(textPlayer1.toString());
		this.labelPlayer1.setLocation(10,10);
		this.labelPlayer1.setSize(250,20);
		this.add(this.labelPlayer1);

		textPlayer2 = new StringBuilder("Player 2 : ");
		textPlayer2.append(this.player2.getName());
		this.labelPlayer2 = new JLabel(textPlayer2.toString());
		this.labelPlayer2.setLocation(300,10);
		this.labelPlayer2.setSize(250,20);
		this.add(this.labelPlayer2);

		if( this.player1.getColor() == Couleur.BLANC)
		{
			PlayColor = "Color White";
		}
		else
		{
			PlayColor = "Color Black";
		}
		JLabel colorPlayer1 = new JLabel(PlayColor);
		colorPlayer1.setLocation(10,50);
		colorPlayer1.setSize(250,20);
		this.add(colorPlayer1);

		if( this.player2.getColor() == Couleur.BLANC)
		{
			PlayColor = "Color White";
		}
		else
		{
			PlayColor = "Color Black";
		}
		JLabel colorPlayer2 = new JLabel(PlayColor);
		colorPlayer2.setLocation(300,50);
		colorPlayer2.setSize(250,20);
		this.add(colorPlayer2);


		this.labelScore1 = new JLabel("Nbr pions = 20");
		this.labelScore1.setLocation(10,100);
		this.labelScore1.setSize(250,20);
	    this.add(this.labelScore1);

		this.labelScore2 = new JLabel("Nbr pions = 20");
		this.labelScore2.setLocation(300,100);
		this.labelScore2.setSize(250,20);
		this.add(this.labelScore2);
	}

}
