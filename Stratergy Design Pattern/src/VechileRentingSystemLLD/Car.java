package VechileRentingSystemLLD;

public class Car {

    private String make;
    private String model;
    private String numberPlate;
    private Double pricePerDay;
    private Boolean isAvailable;

    public Car(String make,String model,String numberPlate,Double pricePerDay,Boolean isAvailable){
        this.make=make;
        this.model=model;
        this.pricePerDay=pricePerDay;
        this.numberPlate=numberPlate;
        this.isAvailable=true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
