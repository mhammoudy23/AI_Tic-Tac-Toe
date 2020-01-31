/*
- player.java is an abstract class that maintains a
 design that every player has a symbol (X or O), a name,
  and an abstract play(board gameboard) method. It also maintains a
  reference to the game board for players to examine and make their move.


 */

public abstract class player {
     int symbol;
    String name;
    board gameboard;

    public abstract void play(board gameboard);

    public player(int symbol,String name, board gameboard){
        this.symbol=symbol;
        this.name=name;
        this.gameboard=gameboard;
    }
    @Override
    public String toString() {
        return this.name;
    }

}

