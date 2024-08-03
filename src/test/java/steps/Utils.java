package steps;

import com.github.javafaker.Faker;
import models.ContactModel;

import java.text.SimpleDateFormat;

public class Utils {

    public ContactModel getFakerDataContact(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String birthDate = sdf.format(faker.date().birthday());
        String email = faker.internet().emailAddress();
        String phone = faker.number().digits(10);
        String address1 = faker.address().streetAddress();
        String address2 = faker.address().streetAddress();
        String city = faker.address().cityName();
        String state = faker.address().state();
        String postalCode = faker.address().zipCode();
        String country = faker.address().country();

        return new ContactModel(firstName, lastName, birthDate, email, phone, address1, address2, city, state, postalCode, country);
    }
}
