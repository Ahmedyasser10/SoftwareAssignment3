import java.util.HashMap;
import java.util.Scanner;

public class Register {
    public static void RegisterUser(Scanner scanner, HashMap<String, User> users) {
        System.out.println("Enter Your User Name");
        String UserName = scanner.next();
        while (users.containsKey(UserName)){
            System.out.println("Username already exists. Please choose another username.");
            UserName = scanner.next();
        }
        System.out.println("Enter Your Password");
        String Password = scanner.next();
        System.out.println("Enter Your ID");
        String UserID = scanner.next();
        System.out.println("Enter Your Phone Number");
        String PhoneNumber = scanner.next();
        System.out.println("Enter Your City");
        String City = scanner.next();
        System.out.println("Enter Your House Number");
        int HouseNumber = scanner.nextInt();
        System.out.println("Enter Your Apartment Number");
        int ApartNumber = scanner.nextInt();
        System.out.println("Enter Your Street ");
        String Street = scanner.next();
        User user = new User();
        user.SetName(UserName);
        user.SetUserID(UserID);
        user.SetPassword(Password);
        user.SetPhoneNumber(PhoneNumber);
        user.SetAddress(City, Street, HouseNumber, ApartNumber);
        System.out.println(UserName);
        users.put(UserName, user);
    }

}
