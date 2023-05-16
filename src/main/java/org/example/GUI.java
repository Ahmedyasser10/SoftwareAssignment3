package org.example;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GUI {
    private DataBase DB = new DataBase();
    private User user = new User();

    shoppingCart mycart = new shoppingCart() ;

    void login() {

    }


    GUI() {
        Scanner scanner = new Scanner(System.in) ;
        while (true) {
            if (!user.getstatus()) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. display Catalog");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        DB.RegisterUser(scanner);
                        break;
                    case 2:
                        user = DB.Login(scanner);
                        break;
                    case 3:
                        DB.displayCatalog();
                        break;
                    case 4:
                        DB.save();
                        System.exit(0);

                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            else {

                System.out.println("\nPlease select an option:");
                System.out.println("1. display catalog");
                System.out.println("2. add item");
                System.out.println("3. remove item ");
                System.out.println("4. update quantity ");
                System.out.println("5. make order");
                System.out.println("6. Log Out");
                System.out.println("7. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        DB.displayCatalog();
                        break;
                    case 2:
                        System.out.println("enter the item ID to add");
                        int id = scanner.nextInt();
                        System.out.println("enter the quantity you want to add ");
                        int q = scanner.nextInt();
                        Item item = DB.getItem(id) ;
                        item.setQuantity(q); // woooow
                        user.getMycart().AddItem(item );
                        break;
                    case 3:
                        System.out.println("enter the item ID to remove");
                        id = scanner.nextInt();
                        user.getMycart().removeItem(id);
                        break;
                    case 4:
                        System.out.println("enter the item ID to update");
                        id = scanner.nextInt();
                        System.out.println("enter the new quantity of the item ");
                        user.getMycart().updateQuantity(id ,scanner.nextInt() );
                        break;
                    case 5:
                        order Order = new order(user.getMycart()) ;
                        if (!Order.makeOrder(DB) ){
                            System.out.println("invalid order \nour storage can't handle your cart\nPlease Try Again");
                        }
                        else {
                            System.out.println("successful order your order will be delivered within 24 hours");
                        }
                        break;
                    case 6:
                        user.setstatus(false) ;
                        break;
                    case 7:
                        DB.save();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}