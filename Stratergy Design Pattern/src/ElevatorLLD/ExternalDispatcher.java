package ElevatorLLD;

public class ExternalDispatcher {

    List<ElevatorController> elevatorControllerList= ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor,Direction direction){

        //We will follow even odd elevator pattern
        for(ElevatorController elevatorController:elevatorControllerList){
            int elevatorId= elevatorController.elevatorCar.id;

            if(elevatorId%2==1 && floor%2==1){
                elevatorController.submitExternalRequest(floor,direction);
            }else{
                elevatorController.submitExternalRequest(floor,direction);
            }
        }
    }
}
