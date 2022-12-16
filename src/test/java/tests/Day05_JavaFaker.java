package tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    /*
   For data-driven tests, we need test data.
   Test Data: username, password, URL, address, test environment etc.

    Where do you get your test data from?
    BA - Business Analyst or any other team member e.g.
    Test Lead
    Manual Tester
    Developer
    From DATABASE
    From API(documentation)
    Mock data/Fake data --> Java Faker

    Java Faker creates data randomly.

     */
    @Test
    public void javaFakerTest(){
        // 1st step: Create Faker Object
        Faker faker = new Faker();

        // 2nd step: Create fake data
        // generating firstname
         String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        // generating lastname
        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        // generating username
        String username = faker.name().username();
        System.out.println("username = " + username);

        // generating title
        String title = faker.name().title();
        System.out.println("title = " + title);

        // generating fullAddress
        String fullAddress = faker.address().fullAddress();
        System.out.println("fullAddress = " + fullAddress);

        // generating cellPhone
        String cellPhone = faker.phoneNumber().cellPhone();
        System.out.println("cellPhone = " + cellPhone);

        // generating numberBetween
        int numberBetween = faker.number().numberBetween(1,8);
        System.out.println("numberBetween = " + numberBetween);

        // You can have some fun as well
        System.out.println(faker.funnyName().name());



    }
}
