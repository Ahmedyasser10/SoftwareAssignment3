import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataBase {
    private HashMap<String, User> users = new HashMap<>();
    private HashMap< Integer, Item > items = new HashMap<>();

    public DataBase(){
        this.Load();
    }
    void Load(){
        String csvFilePath = "students.csv";

        try {
            FileReader fileReader = new FileReader(csvFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                User user = new User();
                user.SetName(data[0]);
                user.SetPassword(data[1]);
                user.setEmail(data[2]);
                user.SetUserID(data[3]);
                user.SetPhoneNumber(data[4]);
                user.SetAddress(user.getAdd().getCity(), user.getAdd().getStreet(), user.getAdd().getHouseNumber(), user.getAdd().getApartmentNumber());
                users.put(user.getName(), user);
            }

            bufferedReader.close(); //// Close the reader.

            System.out.println("Data has been retrieved from the CSV file successfully!");
        }

        catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        }

        csvFilePath = "items.csv" ;

        try {
            FileReader fileReader = new FileReader(csvFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" , ");
                Item item = new Item() ;
                item.setId(Integer.parseInt(data[0])) ;
                item.setName(data[1]);
                item.setCategory(data[2]);
                item.setBrand(data[3]);
                item.setPrice(Double.parseDouble(data[4]));
                item.setDiscountPercentage(Double.parseDouble(data[5]));
                item.setQuantity(Integer.parseInt(data[6])) ;
                items.put(item.getId() , item);
            }

            bufferedReader.close(); //// Close the reader.

            System.out.println("Data has been retrieved from the CSV file successfully!");

        }

        catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        }
    }

    public User Login(Scanner scanner) {
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
            return user ;
        } else {
            System.out.println("Username not found. Please register first.");
            return null ;
        }
    }
    public boolean checkPassword(String password){
        int length = password.length();
        String strongPasswordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return (length >=8 && password.matches(strongPasswordRegex));   ///Compare the password to the strong password.
    }
    public boolean EmailValidator(String email){
        String strongEmailRegex ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(strongEmailRegex);
    }

    public void RegisterUser(Scanner scanner) {
        System.out.println("Enter Your User Name");
        String UserName = scanner.next();
        while (users.containsKey(UserName)){
            System.out.println("Username already exists. Please choose another username.");
            UserName = scanner.next();
        }
        System.out.println("Enter Your Email");
        String Email = scanner.next();
        scanner.nextLine();
        while (!EmailValidator(Email)){
            System.out.println("Invalid Email Please try again");
            Email = scanner.nextLine();
        }
        System.out.println("Enter Your Password");
        String Password = scanner.nextLine();
        System.out.println(Password);
        while (!checkPassword(Password)){
            System.out.println("Weak Password Enter a Strong Password");
            Password = scanner.nextLine();

        }
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
        user.setEmail(Email);
        user.SetUserID(UserID);
        user.SetPassword(Password);
        user.SetPhoneNumber(PhoneNumber);
        user.SetAddress(City, Street, HouseNumber, ApartNumber);
        System.out.println(UserName);
        users.put(UserName, user);


    }

    boolean CheckDuplicate(String name){
        String csvFilePath = "students.csv";

        try {
            FileReader fileReader = new FileReader(csvFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if(name.equals(data[0]))
                    return false;
            }

            bufferedReader.close(); //// Close the reader.

            System.out.println("Data has been retrieved from the CSV file successfully!");
        }


        catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        }
        return true;
    }
    public void save(){
        String csvFilePath = "students.csv";

        try {

            FileWriter fileWriter = new FileWriter(csvFilePath, true); // true to append data to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<String, User> entry : users.entrySet()) {
                User value = entry.getValue();
                if(!CheckDuplicate(value.getName()))
                    continue;
                String rowData = value.getName() + "," + value.getPassword() + "," + value.getEmail() + "," + value.getUserID() + "," + value.getPhoneNumber() + "," + value.getAdd().getCity() + "," + value.getAdd().getStreet() + "," + value.getAdd().getHouseNumber() + "," + value.getAdd().getApartmentNumber();    // Create a string with the data separated by commas

                bufferedWriter.write(rowData);  // Write the data row to the CSV file
                bufferedWriter.newLine();

                bufferedWriter.close(); // Close the writer

                System.out.println("Data has been written to the CSV file successfully!");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file.");
            e.printStackTrace();
        }

        csvFilePath = "items.csv";

        try {

            FileWriter fileWriter = new FileWriter( csvFilePath, false) ; // false to overwrite data to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String row ="";
            for (Map.Entry<Integer, Item> entry : items.entrySet()) {
                Item v = entry.getValue() ;
                row  += String.valueOf(v.getId()) +" , " + v.getName() + " , " + v.getCategory() + " , " + v.getBrand() + " , " +
                        String.valueOf(v.getPrice()) + " , " + String.valueOf(v.getDiscountPercentage()) + " , " + String.valueOf(v.getQuantity())+'\n' ;
            }
            bufferedWriter.write(row);  // Write the data row to the CSV file
            //bufferedWriter.newLine();
            bufferedWriter.close(); // Close the writer
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file.");
            e.printStackTrace();
        }
    }
    public boolean closeOrder(shoppingCart cart){
        HashMap<Integer,Item> cartitems = cart.getItems() ;

        for (Map.Entry<Integer, Item> entry : cartitems.entrySet()){
            Item item = entry.getValue() ;
            items.get(item.getId()).updateQuantity(-item.getQuantity());
            if (items.get(item.getId()).getQuantity() < 0 ){
                items.get(item.getId()).updateQuantity(item.getQuantity());
                return false ;
            }
        }
        return true ;
    }

    public Item getItem(int id ){
        Item it = new Item()  , item = items.get(id);
        it.setQuantity(0);
        it.setBrand(item.getBrand());
        it.setCategory(item.getCategory());
        it.setName(item.getName());
        it.setPrice(item.getPrice());
        it.setDiscountPercentage(item.getDiscountPercentage());
        it.setId(id);
        return it ;
    }

}