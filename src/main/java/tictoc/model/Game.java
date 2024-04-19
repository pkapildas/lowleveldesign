package tictoc.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;

    public Game() {
        initGame();

    }

    private void initGame() {
        players = new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX();
        PlayingPieceO naught = new PlayingPieceO();
        Player player1 = new Player("Name1", cross);
        Player player2 = new Player("Name2", naught);
        players.add(player1);
        players.add(player2);
        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while (noWinner){
            Player playerTurn = players.removeFirst();
            board.printBoard();
            List<Pair> freeCelss = board.getFreeCelss();
            if(freeCelss.isEmpty()){
                noWinner =false;
                continue;
            }
            System.out.println(" Player 1 "+playerTurn.name() + "Enter row, col");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] split = s.split(",");
            int  row = Integer.valueOf (split[0]);
            int col = Integer.valueOf(split[1]);
            boolean isSuccess = board.addPiece(row,col, playerTurn.playingPiece());
            if(!isSuccess){
                System.out.println("Incorrect Position");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isThereWinner(row, col, playerTurn.playingPiece().pieceType);
            if(winner){
                return playerTurn.name();
            }


        }
        return "tie";
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType) {

        boolean rowMatch =true, colMatch=true, diagMatch =true, antiDiagMatch =true;
        for (int i =0 ; i< board.size ; ++i){
            if(board.board[row][i] == null || board.board[row][i].pieceType!=pieceType){
                rowMatch =false;
            }
        }
        for (int i =0 ; i< board.size ; ++i){
            if(board.board[i][col] == null || board.board[col][i].pieceType!=pieceType){
                colMatch =false;
            }
        }
        for (int i =0 , j=0; i< board.size ; ++i, j++){
            if(board.board[i][j] == null || board.board[i][j].pieceType!=pieceType){
                diagMatch =false;
            }
        }
        for (int i =0 , j=board.size-1; i< board.size ; ++i, j--){
            if(board.board[i][j] == null || board.board[i][j].pieceType!=pieceType){
                diagMatch =false;
            }
        }
        return  rowMatch||colMatch || diagMatch || antiDiagMatch;
    }
}
