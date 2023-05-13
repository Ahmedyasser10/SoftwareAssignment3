package org.example;
class Address {
    private String city;
    private String Street;
    private int HouseNumber;
    private int ApartmentNumber;


    public int getApartmentNumber() {
        return ApartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public int getHouseNumber() {
        return HouseNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void SetApartment(int ApartmentNumber) {
        this.ApartmentNumber = ApartmentNumber;
    }

    public void SetCity(String city) {
        this.city = city;
    }

    public void SetHouseNumber(int HouseNumber) {
        this.HouseNumber = HouseNumber;
    }

    public void SetStreet(String Street) {
        this.Street = Street;
    }


}