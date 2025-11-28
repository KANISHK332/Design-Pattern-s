package ElevatorLLD;

public class Dislplay {

    int id;
    Direction dir;

    public void setDisplay(int id,Direction dir){
        this.id=id;
        this.dir=dir;
    }

    public void showDisplay(){
        System.out.println(id);
        System.out.println(dir);
    }
}
