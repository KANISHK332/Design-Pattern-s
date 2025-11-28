package Tic_Tac_ToeLLD;

public class Player {
    public String name;
    public  PlayingPeice playingPeice;
    public Player(String name,PlayingPeice playingPeice){
        this.name= name;
        this.playingPeice=playingPeice;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public PlayingPeice getPlayingPeice(){
        return playingPeice;
    }
    public void setPlayingPeice(PlayingPeice playingPeice){
        this.playingPeice=playingPeice;
    }
}
