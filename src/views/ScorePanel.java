package views;

import Listeners.ListenerControlPanel;
import models.Couleur;
import models.Player;
import models.buttonType;

import javax.swing.*;
import java.awt.*;


public class ScorePanel extends JFrame
{
	private String player1Name, player2Name;
	private Couleur player1Color, player2Color;
	private JLabel labelScore1, labelScore2;

	public ScorePanel( String name1, Couleur color1, String name2, Couleur color2)
	{
		this.player1Name = name1;
		this.player1Color = color1;
		this.player2Name = name2;
		this.player2Color = color2;

	    this.setSize(450,150);
	    this.setTitle("Score");
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setLayout(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.buildScoreWindow();
	}

	public void ChangePlayerScore( int score1, int score2) {
		String text1 = "Score = " + score1;
		String text2 = "Score = " + score2;

	}

	private void buildScoreWindow()
	{
		StringBuilder textPlayer1, textPlayer2;
		String PlayColor;
		textPlayer1 = new StringBuilder("Player 1 : ");
		textPlayer1.append(this.player1Name);
		JLabel labelPlayer1 = new JLabel(textPlayer1.toString());
		labelPlayer1.setLocation(10,10);
		labelPlayer1.setSize(250,20);
	    this.add(labelPlayer1);

		textPlayer2 = new StringBuilder("Player 2 : ");
		textPlayer2.append(this.player2Name);
		JLabel labelPlayer2 = new JLabel(textPlayer2.toString());
		labelPlayer2.setLocation(300,10);
		labelPlayer2.setSize(250,20);
		this.add(labelPlayer2);

		if( player1Color == Couleur.BLANC)
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

		if( player2Color == Couleur.BLANC)
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


		this.labelScore1 = new JLabel("Score = 0");
		this.labelScore1.setLocation(10,100);
		this.labelScore1.setSize(250,20);
	    this.add(this.labelScore1);

		this.labelScore2 = new JLabel("Score = 0");
		this.labelScore2.setLocation(300,100);
		this.labelScore2.setSize(250,20);
		this.add(this.labelScore2);


	}

}
