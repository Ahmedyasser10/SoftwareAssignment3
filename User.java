public class User {
    private String name;
    private String Email;
    private String UserID;
    private String PhoneNumber;
    private String Password;
    private Address Add;

    private boolean LoggedIn;

    public User() {
        LoggedIn = false;
        Add = new Address();
    }

    public void Login(){
        LoggedIn = true;
    }
    public void SetName(String name) {
        this.name = name;
    }

    public void SetUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void SetPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void SetPassword(String UserPassword) {
        this.Password = UserPassword;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return Password;
    }

    public Address getAdd() {
        return Add;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getUserID() {
        return UserID;
    }

    public String getEmail() {
        return Email;
    }

    public void SetAddress(String city, String Street, int HouseNumber, int ApartmentNumber) {
        Add.SetCity(city);
        Add.SetApartment(ApartmentNumber);
        Add.SetStreet(Street);
        Add.SetHouseNumber(HouseNumber);
    }


}
