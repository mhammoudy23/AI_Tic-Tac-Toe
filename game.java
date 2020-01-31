/*
- game.java contains a game board and two players, playerX and playerO.
 It manages the iteration with the players. First by getting the player names,
 does a coin toss to decide the turn and allows each player to take
  a turn and make a move.
 It finally announces the winner/draw when the game ends.
 */


import java.util.Random;
import java.util.Scanner;

class game implements global {
    private boolean done;
    private board gameBoard;
    private player px;
    private player po;
    private int turn;

    Random ran = new Random();
    Scanner sc = new Scanner(System.in);



    public game() {
        this.done=false;
        this.gameBoard = new board();
        this.turn = ran.nextInt(2) + 1;
        System.out.println("WELCOME TO MIKE HAMMOUD'S TIC-TAC-TOE GAME!!");
        System.out.println("GAME MODE:\n 1)Multiplayer\n2)vs.AI");
        int opt = sc.nextInt();
        if(opt == 1){
            System.out.println("Please enter the first players name");
            String p1 = sc.next();
            System.out.println("Please enter the second players name");
            String p2 = sc.next();
            this.px = new HumanPlayer(1, p1, this.gameBoard);
            this.po = new HumanPlayer(2, p2, this.gameBoard);
        }else {
            System.out.println("Please enter the Human players name");
            String p1 = sc.next();
            System.out.println("Please enter the AI players name");
            String p2 = sc.next();
            this.px = new HumanPlayer(1, p1, this.gameBoard);
            this.po = new AIPlayer(2, p2, this.gameBoard);
        }

    }

    public void start() {
        int i = 0;
        this.turn = ran.nextInt(2) + 1;
        if (this.turn == 1) {
            System.out.println(""+this.px.name+" Won the toss");
        }
        else {
            System.out.println(""+this.po.name+" Won the toss");
        }
        while (i == 0) {
            if (this.turn == 1) {
                System.out.println("" + this.px.name + " Turn");
                this.px.play(this.gameBoard);
            }
            else {
                System.out.println("" + this.po.name + " Turn");
                this.po.play(this.gameBoard);
            }
            if (this.gameBoard.getState() != 0) {
                i = 1;
            }
            if (i == 0) {
                if (this.turn == 1) {
                    this.turn = 2;
                }
                else {
                    this.turn = 1;
                }
            }
        }
        this.gameBoard.displayBoard();
        if (this.gameBoard.getState() == 3) {
            System.out.println(" Draw ");
        }
        else if (this.turn == 1) {
            System.out.println("WINNER " + this.px);
        }
        else {
            System.out.println("WINNER " + this.px);
        }
    }

}