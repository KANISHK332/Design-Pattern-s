package ElevatorLLD;

public class ElevatorCar {
    int id;
    int currentFloor;
    ElevatorState elevatorState;
    Direction direction;
    InternalButtons internalbuttons;
    ElevatorDoor elevatorDoor;
    Dislplay dislplay;

    public ElevatorCar(){
     dislplay= new Dislplay();
     internalbuttons= new InternalButtons();
     elevatorState= ElevatorState.IDLE;
     direction= Direction.UP;
     elevatorDoor=new ElevatorDoor();
     currentFloor=0;

    }

    public void showDisplay(){
       dislplay.showDisplay();
    }

    public void pressButton(int destination){
        internalbuttons.pressButton(destination,this);
    }

    public  void setDislplay(){
        this.dislplay.setDisplay(currentFloor,direction);
    }

    boolean moveElevator(Direction dir,int destinationFloor){
        int startFloor= currentFloor;

        if(dir.equals(Direction.UP)){
            for(int i=startFloor;i<=destinationFloor;i++){
                this.currentFloor=startFloor;
                setDislplay();
                showDisplay();
                if(i==destinationFloor) return true;
            }
        }

        if(dir.equals(Direction.DOWN)){
            for(int i=startFloor;i>=destinationFloor;i--){
                this.currentFloor=startFloor;
                setDislplay();
                showDisplay();
                if(i==destinationFloor) return true;
            }
        }
        return false;
    }


}
