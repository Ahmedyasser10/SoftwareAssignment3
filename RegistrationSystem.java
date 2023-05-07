import java.util.HashMap;
import java.util.Scanner;


public class RegistrationSystem {
    private static HashMap<String, User> map = new HashMap<>();

    public static void main(String argv[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Register.RegisterUser(scanner, map);
                    break;
                case 2:
                    Login.Login(scanner,map);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}