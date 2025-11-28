package ElevatorLLD;

public class Floor {
    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber,ExternalDispatcher externalDispatcher){
        this.floorNumber=floorNumber;
        this.externalDispatcher=externalDispatcher;
    }

    public void pressButton(Direction direction){
        externalDispatcher.submitExternalRequest(floorNumber,direction);
    }
}
