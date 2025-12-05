package VechileRentingSystemLLD;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private String reservationId;
    private Car car;
    private Customer customer;
    private Double totalPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(String reservationId,Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.reservationId= reservationId;
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice=calculatePrice();
    }


    public Double calculatePrice(){
        long totalDays= ChronoUnit.DAYS.between(startDate,endDate)+1;
            return (car.getPricePerDay()*totalDays);
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReservationId() {
        return reservationId;
    }
}
