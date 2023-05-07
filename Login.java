import java.util.HashMap;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Login {
    public static void Login(Scanner scanner, HashMap<String, User> users) {
        System.out.println("Enter Your User name");
        String UserName = scanner.next();
        System.out.println("Enter Your Password");
        String Password = scanner.next();
        if (users.containsKey(UserName)) {
            User user = users.get(UserName);
            while (!(user.getPassword().equals(Password))) {
                System.out.println("Incorrect password. Please try again.");
                Password = scanner.next();
            }
            System.out.println("Login successful! Welcome, " + user.getName() + "!");
            user.Login();
        } else {
            System.out.println("Username not found. Please register first.");
        }
    }


}
