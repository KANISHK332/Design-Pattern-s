package Tic_Tac_ToeLLD;

public class Main {
    public static void main(String[] args) {
        TicTacToe game= new TicTacToe();
        game.initializeGame();
        System.out.println("Winner of Game is: "+game.startGame());
    }
}
