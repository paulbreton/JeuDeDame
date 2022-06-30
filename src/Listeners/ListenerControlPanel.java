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


    public ListenerControlPanel( buttonType type, Game game, ControlPanel panel)
    {
        this.ctrlPanel = panel;
        this.type = type;
        this.game = game;
    }

    public void actionPerformed(ActionEvent event)
    {
        switch (this.type)
        {
            case WHITE:
                this.ctrlPanel.ChangePlayer2Color( Couleur.NOIR);
                this.game.setColorPlayer1( Couleur.BLANC);
                this.game.setColorPlayer2( Couleur.NOIR);
                break;

            case BLACK:
                this.ctrlPanel.ChangePlayer2Color( Couleur.BLANC);
                this.game.setColorPlayer1( Couleur.NOIR);
                this.game.setColorPlayer2( Couleur.BLANC);
                break;

            case OK:
                this.ctrlPanel.dispose();
                this.game.setNamePlayer1(this.ctrlPanel.getPlayer1Name());
                this.game.setNamePlayer2(this.ctrlPanel.getPlayer2Name());
                this.game.startPlate();
                this.game.startScorePanel();
                break;

            case CANCEL:
                System.exit(0);
                break;

            default:
        }
    }
}
