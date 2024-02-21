package fackerLibrary;

import com.github.javafaker.Faker;

public class DynamicValuesFaker {

    public void dynamicFaker(){

        //Faker facker = new Facker();
        //facker fack = new facker();
        @Test
        public void dynamicValues() {

            Faker fake=new Faker();
            String fullName = fake.name().fullName();
            String firstName = fake.name().firstName();
            String email=fake.internet().emailAddress();
            String emailID=firstName+"@"+"testleaf.com";
            System.out.println(fullName+"-"+firstName+"-"+email+emailID);
            System.out.println(fullName+"-"+firstName+"-"+email+emailID);
            System.out.println(fullName+"-"+firstName+"-"+email+emailID);
            System.out.println(fullName+"-"+firstName+"-"+email+emailID);
            System.out.println(fullName+"-"+firstName+"-"+email+emailID);
            System.out.println(fullName+"-"+firstName+"-"+email+emailID);
            System.out.println(fullName+"-"+firstName+"-"+email+emailID);






        //facker


    }
}
