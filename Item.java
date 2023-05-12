package org.example;
public class Item {
    private int id ;
    private String name ;
    private String Category ;
    private String Brand ;
    private double price ;
    private double DiscountPercentage ;
    private int quantity ;
    public Item(){}
    public Item(int id, String name, String Category, String Brand , double price, double DiscountPercentage, int quantity ){
        this.id = id;
        this.name = name;
        this.Category = Category;
        this.Brand = Brand;
        this.price = price;
        this.DiscountPercentage = DiscountPercentage  ;
        this.quantity = quantity;

    }
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public String getCategory() {return this.Category;}
    public void setCategory(String category) {this.Category = category;}
    public String getBrand(){return this.Brand;}
    public void setBrand(String brand) {this.Brand = brand;}
    public double getPrice(){return this.price; }
    public void setPrice(double price) {this.price = price ;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public double getDiscountPercentage() {return DiscountPercentage;}

    public void setDiscountPercentage(double discountPercentage) {DiscountPercentage = discountPercentage;}
    public void updateQuantity(int q){this.quantity += q ; }
}
