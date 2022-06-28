package views;

import javax.swing.*;

import Listeners.*;

import models.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;



public class ControlPanel extends JFrame
{
	private JLabel labelColorPlayer2;

	private Couleur player1Color, player2Color;

	private JTextField textPlayer1, textPlayer2;

	public ControlPanel(String titre)
	{
	      this.setSize(580,260);
	      this.setTitle(titre);
	      this.setResizable(false);
	      this.setLocationRelativeTo(null);
	      this.setLayout(null);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	public String getPlayerName( Player player)
	{
		if( player == Player.PLAYER1)
		{
			return this.textPlayer1.getText();
		}
		else
		{
			return this.textPlayer2.getText();
		}
	}

	public Couleur getPlayerColor( Player player)
	{
		if( player == Player.PLAYER1)
		{
			return this.player1Color;
		}
		else
		{
			return this.player2Color;
		}
	}

	private void buildWindow()
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

		this.labelColorPlayer2 = new JLabel("Player 2 color is Black");
		this.labelColorPlayer2.setLocation(300, 100);
		this.labelColorPlayer2.setSize(200, 20);
		this.add(this.labelColorPlayer2);

		JPanel panelColorPlayer1 = this.buildPanel(10, 65, Player.PLAYER1, Couleur.BLANC);
		this.player1Color = Couleur.BLANC;
		this.player2Color = Couleur.NOIR;
	    this.add(panelColorPlayer1);

		JButton boutonAnnuler = new JButton("Cancel");
        boutonAnnuler.setLocation(180,200);
        boutonAnnuler.setSize(90,20);
	    this.add(boutonAnnuler);
		boutonAnnuler.addActionListener(new ListenerControlPanel( buttonType.CANCEL, Player.PLAYER1,this));

		JButton boutonOK = new JButton("OK");
	    boutonOK.setLocation(280,200);
	    boutonOK.setSize(90,20);
	    this.add(boutonOK);
		boutonOK.addActionListener(new ListenerControlPanel( buttonType.OK, Player.PLAYER1,this));
	}

	private JPanel buildPanel(int x, int y, Player player, Couleur color)
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

		if( color == Couleur.BLANC)
		{
			blanc = new JRadioButton("White", true);
			noir = new JRadioButton("Black", false);
		}
		else
		{
			blanc = new JRadioButton("White", false);
			noir = new JRadioButton("Black", true);
		}

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
		blanc.addActionListener(new ListenerControlPanel( buttonType.WHITE, player, this));
		noir.addActionListener(new ListenerControlPanel( buttonType.BLACK, player, this));

		return panel;
	}
}
