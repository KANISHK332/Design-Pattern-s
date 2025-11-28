package Tic_Tac_ToeLLD;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int size;
    PlayingPeice [][] board;

    public Board(int size){
        this.size= size;
        board= new PlayingPeice[size][size];
    }

    public boolean addpeice(int i,int j,PlayingPeice playingPeice){
        if(board[i][j]!=null){
            return false;
        }
        board[i][j]=playingPeice;
        return true;
    }


    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> ans= new ArrayList<>();

        for(int i=0;i<size;i++){
          for(int j=0;j<size;j++){
              if(board[i][j]==null){
                  Pair<Integer,Integer> pair= new Pair<Integer,Integer>(i,j);
                  ans.add(pair);
              }
          }
        }
        return ans;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null){
                    System.out.print(board[i][j].peiceType.name()+"  ");
                }else{
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }

    }
}
