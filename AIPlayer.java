import java.util.*;
import java.lang.*;


class AIPlayer extends player implements global
{
    public AIPlayer(int n, String s ,board gameBoard) {
        super(n, s, gameBoard);
    }

    @Override
    public void play( board board) {
        int legal = this.randomLegal();
        board.makeMove(legal, this.symbol);
        System.out.println(this.name + "placed an "+this.symbol+"at"+ legal+"");
    }
    private int randomLegal() {
        Random ran = new Random();
        int bound = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.gameboard.blocks[i][j].getState() == 0) {
                    arr[bound++] = 3 * i + 1 + j;
                }
            }
        }
        return arr[ran.nextInt(bound)];
    }

    private int senseLoss() {
        int n;
        if (this.symbol == 1) {
            n = 2;
        }
        else {
            n = 1;
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.gameboard.blocks[i][j].getState() == 0) {
                    int n2 = 0;
                    if (this.gameboard.blocks[0][j].getState() == n) {
                        ++n2;
                    }
                    if (this.gameboard.blocks[1][j].getState() == n) {
                        ++n2;
                    }
                    if (this.gameboard.blocks[2][j].getState() == n) {
                        ++n2;
                    }
                    if (n2 == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n3 = 0;
                    if (this.gameboard.blocks[i][0].getState() == n) {
                        ++n3;
                    }
                    if (this.gameboard.blocks[i][1].getState() == n) {
                        ++n3;
                    }
                    if (this.gameboard.blocks[i][2].getState() == n) {
                        ++n3;
                    }
                    if (n3 == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n4 = 0;
                    if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                        if (this.gameboard.blocks[0][2].getState() == n) {
                            ++n4;
                        }
                        if (this.gameboard.blocks[1][1].getState() == n) {
                            ++n4;
                        }
                        if (this.gameboard.blocks[2][0].getState() == n) {
                            ++n4;
                        }
                        if (n4 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                    int n5 = 0;
                    if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
                        if (this.gameboard.blocks[0][0].getState() == n) {
                            ++n5;
                        }
                        if (this.gameboard.blocks[1][1].getState() == n) {
                            ++n5;
                        }
                        if (this.gameboard.blocks[2][2].getState() == n) {
                            ++n5;
                        }
                        if (n5 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private int senseWin() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.gameboard.blocks[i][j].getState() == 0) {
                    int n = 0;
                    if (this.gameboard.blocks[0][j].getState() == this.symbol) {
                        ++n;
                    }
                    if (this.gameboard.blocks[1][j].getState() == this.symbol) {
                        ++n;
                    }
                    if (this.gameboard.blocks[2][j].getState() == this.symbol) {
                        ++n;
                    }
                    if (n == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n2 = 0;
                    if (this.gameboard.blocks[i][0].getState() == this.symbol) {
                        ++n2;
                    }
                    if (this.gameboard.blocks[i][1].getState() == this.symbol) {
                        ++n2;
                    }
                    if (this.gameboard.blocks[i][2].getState() == this.symbol) {
                        ++n2;
                    }
                    if (n2 == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n3 = 0;
                    if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                        if (this.gameboard.blocks[0][2].getState() == this.symbol) {
                            ++n3;
                        }
                        if (this.gameboard.blocks[1][1].getState() == this.symbol) {
                            ++n3;
                        }
                        if (this.gameboard.blocks[2][0].getState() == this.symbol) {
                            ++n3;
                        }
                        if (n3 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                    int n4 = 0;
                    if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
                        if (this.gameboard.blocks[0][0].getState() == this.symbol) {
                            ++n4;
                        }
                        if (this.gameboard.blocks[1][1].getState() == this.symbol) {
                            ++n4;
                        }
                        if (this.gameboard.blocks[2][2].getState() == this.symbol) {
                            ++n4;
                        }
                        if (n4 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                }
            }
        }
        return 0;
    }



}
