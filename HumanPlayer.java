/*
- HumanPlayer.java extends player, a type of player that requests its input
 from the user and submit the move (or play) to the gameboard.

 */

import java.util.Scanner;
import java.awt.*;
import java.util.*;
import java.lang.*;

class HumanPlayer extends player implements global
{
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(int n, String temp, board board) {
        super(n, temp, board);

    }

    @Override
    public void play( board gameBoard) {

            System.out.println("Make a move");
            gameboard.displayPlayerSelectionBoard();
            boolean move = gameBoard.makeMove(sc.nextInt(), this.symbol);
            if (!move) {
                System.out.println("Try again");
            }
    }
}