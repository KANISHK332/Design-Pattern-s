package StratergyDesignPattern;

import StratergyDesignPattern.stratergy.DriveStratergy;

public class Vechile  {

    DriveStratergy vec;
    public Vechile(DriveStratergy vec){
        this.vec=vec;
    }

    public void drive(){
        vec.drive();
    }

}
