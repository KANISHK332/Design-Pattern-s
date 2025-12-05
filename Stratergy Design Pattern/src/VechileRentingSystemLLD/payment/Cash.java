package VechileRentingSystemLLD.payment;

public class Cash implements PaymentProcessing{

    @Override
    public boolean processPayment(Double amount) {
        //Logic for Cash Payment
        return true;
    }
}
