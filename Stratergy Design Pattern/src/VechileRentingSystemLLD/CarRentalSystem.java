package VechileRentingSystemLLD;

import VechileRentingSystemLLD.payment.Cash;
import VechileRentingSystemLLD.payment.PaymentProcessing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalSystem {

    private Map<String,Car> cars;
    private Map<String,Reservation> reservation;
    private PaymentProcessing paymentProcessing;


    public CarRentalSystem(){
        cars= new ConcurrentHashMap<>();
        reservation= new ConcurrentHashMap<>();
        paymentProcessing= new Cash();
    }

    // Adding a Car
    public void addCar(Car car){
        cars.put(car.getNumberPlate(),car);
    }

    //Removing a Car
    public void removeCar(String numberPlate){
        cars.remove(numberPlate);
    }

    // Check if car's booking is not present on the requested date
    boolean isCarAvailable(Car car, LocalDate startDate,LocalDate endDate){
        for(Reservation res: reservation.values()){
            //How equals work at object level
            if(res.getCar().equals(car)){
                if(startDate.isBefore(res.getEndDate()) && endDate.isAfter(res.getStartDate())){
                    return false;
                }
            }
        }
        return true;
    }

   // It will give list of all available cars
    public List<Car> searchAvailableCars(String make,String model,LocalDate startDate,LocalDate endDate){
        List<Car> availableCars= new ArrayList<>();

        for(Car car:cars.values()){
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.getAvailable() && isCarAvailable(car,startDate,endDate)){
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    //Function Used to make reservation of a CAR
    public  Reservation makeReservation(Customer customer,Car car,LocalDate startDate,LocalDate endDate){
        if(isCarAvailable(car,startDate,endDate)){
        String reservationId= generateId();
        Reservation reservations= new Reservation(reservationId,car,customer,startDate,endDate);
        car.setAvailable(false);
        reservation.put(reservationId,reservations);
        return reservations;
        }
        return null;
    }

    // When Customer cancel the request
    public void cancelReservation(String reservationId){
        Reservation reservation1= reservation.remove(reservationId);
        if(reservation1!=null){
            reservation1.getCar().setAvailable(true);
        }
    }


    //Final Step  Payment Process
    public boolean processPayment(Reservation reservation1){
        return paymentProcessing.processPayment(reservation1.getTotalPrice());
    }

    private String generateId() {
        return "RES"+ UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

}
