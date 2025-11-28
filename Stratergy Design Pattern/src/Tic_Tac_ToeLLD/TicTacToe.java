package Tic_Tac_ToeLLD;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame() {
        players = new LinkedList<>();
        gameBoard = new Board(3);
        PlayingPeiceX crossPeice = new PlayingPeiceX();
        PlayingPeiceO noughtsPeice = new PlayingPeiceO();

        Player player1 = new Player("P1", crossPeice);
        Player player2 = new Player("P2", noughtsPeice);

        players.add(player1);
        players.add(player2);
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();

            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }
            // read User Input
            System.out.println("Player:" + playerTurn.getName() + "Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            Integer inputRow = Integer.valueOf(values[0]);
            Integer inputColumn = Integer.valueOf(values[1]);

            // place the peice
            boolean peiceAddedSuccessfully = gameBoard.addpeice(inputRow, inputColumn, playerTurn.getPlayingPeice());
            if (!peiceAddedSuccessfully) {
                System.out.println("Incorrect Position Please Try Again!! ");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playingPeice.peiceType);
            if (winner) {
                return playerTurn.getName();
            }
        }
        return "tie";
    }

    private boolean isThereWinner(Integer inputRow, Integer inputColumn, PeiceType peiceType) {

        boolean rowMatch= true;
        boolean colMatch= true;
        boolean diagonalMatch= true;
        boolean antiDiagonalMatch= true;

        for(int i=0;i< gameBoard.size;i++){
            if(gameBoard.board[i][inputColumn]==null || gameBoard.board[i][inputColumn].peiceType!=peiceType){
                colMatch=false;
                break;
            }
        }
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[inputRow][i]==null || gameBoard.board[inputRow][i].peiceType!=peiceType){
                rowMatch=false;
                break;
            }
        }

        for(int i=0,j=0;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].peiceType!=peiceType){
                diagonalMatch=false;
                break;
            }
        }
        for(int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].peiceType!=peiceType){
                antiDiagonalMatch=false;
                break;
            }
        }
      return rowMatch||colMatch||diagonalMatch||antiDiagonalMatch;
    }

}

