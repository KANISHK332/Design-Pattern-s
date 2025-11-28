package StratergyDesignPattern.stratergy;

public class Normal implements DriveStratergy {

    @Override
    public void drive() {
        System.out.println("This is Normal Driving Mode!!");
    }
}
