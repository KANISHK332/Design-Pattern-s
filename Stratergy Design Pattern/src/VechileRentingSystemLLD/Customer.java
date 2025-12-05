package VechileRentingSystemLLD;

public class Customer {

    private String name;
    private String contactInfo;
    private String licenseNo;

    public Customer(String name, String contactInfo, String licenseNo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.licenseNo = licenseNo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }
}
