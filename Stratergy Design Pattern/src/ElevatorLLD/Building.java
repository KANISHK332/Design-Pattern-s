package ElevatorLLD;

import java.util.List;

public class Building {
    List<Floor> floorList;

     Building(List<Floor> floorList){
         this.floorList=floorList;
     }
    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public void addFloor(Floor nxtFloor){
         floorList.add(nxtFloor);
    }

    public void rmvFloor(Floor rmv){
         floorList.remove(rmv);
    }
}
