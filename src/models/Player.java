package models;


public class Player {
	private String Name;
	private Couleur Color;
	private int pawnNumber;
    private int queenNumber;

    public Player()
    {
        this.pawnNumber = 20;
        this.queenNumber = 0;
    }

    public void setName( String name)
    {
        this.Name = name;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setColor( Couleur color)
    {
        this.Color = color;
    }

    public Couleur getColor()
    {
        return this.Color;
    }
    //
    // Decrement the number of pawn and return true if this
    // number reach 0, otherwise, return false
    //
    public boolean decrementPawn()
    {
        if( this.pawnNumber > 0)
        {
            this.pawnNumber--;
        }

        if( this.pawnNumber == 0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public int getPawnNumber()
    {
        return this.pawnNumber;
    }

    public void incrementQueenNumber()
    {
        this.queenNumber++;
    }

    public int getQueenNumber()
    {
        return this.queenNumber;
    }

}