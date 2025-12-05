package VechileRentingSystemLLD;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem= new CarRentalSystem();


        //Add Car's to Rental System
         carRentalSystem.addCar(new Car("Toyota","Innova","MP20PP1520",1000.00,true));
         carRentalSystem.addCar(new Car("Tata","Tigor","MP20PP1597",600.0,true));
         carRentalSystem.addCar(new Car("Suzuki","Swift","MP20LX1874",800.0,true));

        // Add Customer Details
         Customer customer1= new Customer("Mahipal Pawar","81XXXXXX19","ASDE3456");

         //Make Reservation

        LocalDate startDate= LocalDate.now();
        LocalDate endDate= startDate.plusDays(3);

        List<Car> availableCars=  carRentalSystem.searchAvailableCars("Suzuki","Swift",startDate,endDate);
        if(!availableCars.isEmpty()){
            Car selectedCar= availableCars.getFirst();
            Reservation reservation = carRentalSystem.makeReservation(customer1,selectedCar,startDate,endDate);
           if(reservation!=null){
               boolean paymentSuccess= carRentalSystem.processPayment(reservation);
               if(paymentSuccess){
                   System.out.println("Reservation Successful"+" Reservation ID :"+reservation.getReservationId());
               }else{
                   System.out.println("Payment Failed! Reservation Cancelled...");
                   carRentalSystem.cancelReservation(reservation.getReservationId());
               }
           }else{
               System.out.println("Selected Car is not Available for given dates!!!");
           }
        }else{
            System.out.println("No! Car Found for the given Criteria.");
        }
    }
}
