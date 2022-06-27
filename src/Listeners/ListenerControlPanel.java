package Listeners;

import models.*;
import controllers.*;
import views.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListenerControlPanel implements ActionListener
{
    private ControlPanel ctrlPanel;
    private buttonType type;
    private Player player;
    private Game game;


    public ListenerControlPanel( buttonType type, Player player, ControlPanel panel)
    {
        this.ctrlPanel = panel;
        this.type = type;
        this.player = player;
    }

    public void actionPerformed(ActionEvent event)
    {
        switch (this.type)
        {
            case WHITE:
                this.ctrlPanel.ChangePlayer2Color( Couleur.NOIR);
                break;

            case BLACK:
                this.ctrlPanel.ChangePlayer2Color( Couleur.BLANC);
                break;

            case OK:
                this.ctrlPanel.dispose();

                game = new Game(    this.ctrlPanel.getPlayerName(Player.PLAYER1),
                                    this.ctrlPanel.getPlayerColor(Player.PLAYER1),
                                    this.ctrlPanel.getPlayerName(Player.PLAYER2),
                                    this.ctrlPanel.getPlayerColor(Player.PLAYER2) );
                break;

            case CANCEL:
                System.exit(0);
                break;

            default:
        }
        /*
        if ("disable".equals(event.getActionCommand())) {
        b2.setEnabled(false);
        b1.setEnabled(false);
        b3.setEnabled(true);
        } else {
        b2.setEnabled(true);
        b1.setEnabled(true);
        b3.setEnabled(false);
        }
        if( this.type == buttonType.WHITE)
        {

        } */
        //ctrlPanel.dispose();
    }
}
