package ElevatorLLD;

public class InternalButtons {

    InternalDispatcher internalDispatcher= new InternalDispatcher();
    int buttonSelected;

    void pressButton(int destination,ElevatorCar elevatorCar){
        internalDispatcher.submitInternalRequest(destination,elevatorCar);
    }
}
