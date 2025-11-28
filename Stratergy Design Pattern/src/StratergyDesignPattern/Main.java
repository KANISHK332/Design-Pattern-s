package StratergyDesignPattern;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Vechile vec=new OffRoading();
        vec.drive();
        Vechile vec1=new GoodsAndService();
        vec1.drive();
    }
}