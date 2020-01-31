/*
- board.java a board has or contains 9 blocks in a 2D array (3x3)
 that shapes the game space of tic-tac-toe. It also maintains an internal
 state which can be one of the following: EMPTY (the initial state of the board),
  X (X claims a win), Y (Y claims a win), or DRAW (where neither X nor Y can claim a
   win and no further moves are possible). The board has the key methods makeMove( )
    that is called by a player making a move and getState() or updateState() that updates
    the state of the board after every move. It checks for a win or a draw when they occur.
     Note that the board instantiates and maintains all the blocks.
 */

class board implements global
{
    public block[][] blocks;
    private int state;

    public board() {
        this.state = 0;
        this.blocks = new block[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.blocks[i][j] = new block();
            }
        }
    }


    private int checkCol( int n) {
        if (this.blocks[0][n].getState() != 0 && this.blocks[0][n].getState() == this.blocks[1][n].getState() && this.blocks[1][n].getState() == this.blocks[2][n].getState()) {
            return this.blocks[0][n].getState();
        }
        return 0;
    }

    private int checkDiagonals() {
        if (this.blocks[0][0].getState() != 0 && this.blocks[0][0].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][2].getState()) {
            return this.blocks[0][0].getState();
        }
        if (this.blocks[0][2].getState() != 0 && this.blocks[0][2].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][0].getState()) {
            return this.blocks[0][2].getState();
        }
        return 0;
    }
    private int checkDraw() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.blocks[i][j].getState() == 0) {
                    return 0;
                }
            }
        }
        return 3;
    }
    private int checkRow( int n) {
        if (this.blocks[n][0].getState() != 0 && this.blocks[n][0].getState() == this.blocks[n][1].getState() && this.blocks[n][1].getState() == this.blocks[n][2].getState()) {
            return this.blocks[n][0].getState();
        }
        return 0;
    }

    public void displayBoard() {
        for(int i = 0; i<3;i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("" + this.blocks[i][j] +"");

                if(j!=2){
                    System.out.print("|");

                }
                else {
                    System.out.print("\n");
                }
            }
        }

    }
    public void displayPlayerSelectionBoard() {
        int i = 1;
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 3; ++k) {
                System.out.print((this.blocks[j][k].getState() == 0) ? Integer.valueOf(i) : this.blocks[j][k]);
                ++i;
                if (k != 2) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
    }

    public boolean makeMove( int n,  int state) {
        int n2 = 0;
        int n3 = 0;
        if (n < 1 || n > 9) {
            return false;
        }
        if (n == 1) {
            n2 = 0;
            n3 = 0;
        }
        if (n == 2) {
            n2 = 0;
            n3 = 1;
        }
        if (n == 3) {
            n2 = 0;
            n3 = 2;
        }
        if (n == 4) {
            n2 = 1;
            n3 = 0;
        }
        if (n == 5) {
            n2 = 1;
            n3 = 1;
        }
        if (n == 6) {
            n2 = 1;
            n3 = 2;
        }
        if (n == 7) {
            n2 = 2;
            n3 = 0;
        }
        if (n == 8) {
            n2 = 2;
            n3 = 1;
        }
        if (n == 9) {
            n2 = 2;
            n3 = 2;
        }
        if (this.blocks[n2][n3].getState() == 0) {
            this.blocks[n2][n3].setState(state);
            return true;
        }
        return false;
    }

    public int getState() {
        return this.updateState();
    }

    public int updateState() {
        int state = this.checkRow(0) + this.checkRow(1) + this.checkRow(2) + this.checkCol(0) + this.checkCol(1) + this.checkCol(2) + this.checkDiagonals();
        if (state != 0) {
            this.state = state;
        }
        else {
            this.state = this.checkDraw();
        }
        return this.state;
    }
}