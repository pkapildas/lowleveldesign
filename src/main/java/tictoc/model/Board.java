package tictoc.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }
     List<Pair> getFreeCelss(){
        List<Pair> free = new ArrayList<>();
        for(int i =0; i< size ;++i){
        for(int j =0; j< size ;++j) {
            if (board[i][j] != null) {
                Pair pair = new Pair(i, j);
                free.add(pair);
            }
        }
        }

        return free;
     }

    public void printBoard() {

    }
}
