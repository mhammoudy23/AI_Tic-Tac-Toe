/*
- block.java a block represents a playable cell and maintains a
state attribute that is either EMPTY, occupied by X, or occupied by O) .
By default it is EMPTY, would require setState,
getState, and a toString where EMPTY is just a blank space.
 */

class block implements global {
    int state;

    public block() {
        this.state = 0;
    }

    public boolean setState(int state) {
        if (this.isValidState(state)) {
            this.state = state;
            return true;
        }
        return false;
    }

    public int getState() {
        return this.state;
    }

    public boolean isValidState(int st) {
        return st == 2 || st == 1;
    }

    @Override
    public String toString() {
        if (this.state == 0) {
            return " ";
        }
        if (this.state == 1) {
            return "X";
        }
        return "O";
    }
}