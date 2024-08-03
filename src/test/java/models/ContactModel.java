package models;
import lombok.Data;

@Data
public class ContactModel {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String country;

    public ContactModel(String firstName, String lastName, String birthDate, String email, String phone, String address1, String address2, String city, String stateProvince, String postalCode, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.stateProvince = stateProvince;
        this.postalCode = postalCode;
        this.country = country;
    }
}
