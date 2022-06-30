package views;

import javax.swing.*;

import controllers.*;

import Listeners.*;

import models.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;



public class ControlPanel extends JFrame
{
	private JLabel labelColorPlayer2;

	private Couleur player1Color, player2Color;

	private Game game;

	private JTextField textPlayer1, textPlayer2;

	public ControlPanel(String titre, Game newGame)
	{
	      this.setSize(580,260);
	      this.setTitle(titre);
	      this.setResizable(false);
	      this.setLocationRelativeTo(null);
	      this.setLayout(null);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.game = newGame;
	      this.buildWindow();
	}

	public void ChangePlayer2Color( Couleur color) {
		if( color == Couleur.BLANC) {
			this.labelColorPlayer2.setText("Player 2 color is White");
			this.player1Color = Couleur.NOIR;
			this.player2Color = Couleur.BLANC;
		}
		else if( color == Couleur.NOIR) {
			this.labelColorPlayer2.setText("Player 2 color is Black");
			this.player1Color = Couleur.BLANC;
			this.player2Color = Couleur.NOIR;
		}
	}

	public String getPlayer1Name( )
	{
		return this.textPlayer1.getText();
	}

	public String getPlayer2Name( )
	{
		return this.textPlayer2.getText();
	}

	private void buildWindow( )
	{
		JLabel labelPlayer1 = new JLabel("Player 1 :");
		labelPlayer1.setLocation(10,10);
		labelPlayer1.setSize(120,20);
	    this.add(labelPlayer1);

		this.textPlayer1 = new JTextField(100);
		this.textPlayer1.setLocation(80,10);
		this.textPlayer1.setSize(130,20);
		this.add(this.textPlayer1);

		JLabel labelPlayer2 = new JLabel("Player 2 :");
		labelPlayer2.setLocation(300,10);
		labelPlayer2.setSize(120,20);
		this.add(labelPlayer2);

		this.textPlayer2 = new JTextField(100);
		this.textPlayer2.setLocation(370,10);
		this.textPlayer2.setSize(130,20);
	    this.add(this.textPlayer2);

		JLabel labelColorPlayer1 = new JLabel("Select player 1 color :");
		labelColorPlayer1.setLocation(10,40);
		labelColorPlayer1.setSize(200,20);
	    this.add(labelColorPlayer1);

		this.game.setColorPlayer1( Couleur.BLANC);
		this.game.setColorPlayer2( Couleur.NOIR);

		this.labelColorPlayer2 = new JLabel("Player 2 color is Black");
		this.labelColorPlayer2.setLocation(300, 100);
		this.labelColorPlayer2.setSize(200, 20);
		this.add(this.labelColorPlayer2);

		JPanel panelColorPlayer1 = this.buildPanel(10, 65);
		this.player1Color = Couleur.BLANC;
		this.player2Color = Couleur.NOIR;
	    this.add(panelColorPlayer1);

		JButton boutonAnnuler = new JButton("Cancel");
        boutonAnnuler.setLocation(180,200);
        boutonAnnuler.setSize(90,20);
	    this.add(boutonAnnuler);
		boutonAnnuler.addActionListener(new ListenerControlPanel( buttonType.CANCEL, this.game,this));

		JButton boutonOK = new JButton("OK");
	    boutonOK.setLocation(280,200);
	    boutonOK.setSize(90,20);
	    this.add(boutonOK);
		boutonOK.addActionListener(new ListenerControlPanel( buttonType.OK, this.game,this));
	}

	/*
	 * buildPanel is used to build radio button for player 1 color selection
	 */
	private JPanel buildPanel(int x, int y)
	{
		JPanel panel;
		ButtonGroup buttonColor;
		JRadioButton blanc;
		JRadioButton noir;

		panel = new JPanel();
	    panel.setLocation(x,y);
	    panel.setSize(100,80);
	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    panel.setLayout(null);

		blanc = new JRadioButton("White", true);
		noir = new JRadioButton("Black", false);

	    blanc.setLocation(5,15);
	    blanc.setSize(80,20);
	    noir.setLocation(5,40);
	    noir.setSize(80,20);

	    panel.add(blanc);
	    panel.add(noir);

		buttonColor = new ButtonGroup();
		buttonColor.add(blanc);
		buttonColor.add(noir);

		// Register listener for the radio button
		blanc.addActionListener(new ListenerControlPanel( buttonType.WHITE, this.game, this));
		noir.addActionListener(new ListenerControlPanel( buttonType.BLACK, this.game, this));

		return panel;
	}
}
