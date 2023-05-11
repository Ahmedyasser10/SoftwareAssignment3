import java.util.HashMap;
public class shoppingCart {
    private int ID;
    private HashMap<Integer,Item>items = new HashMap<Integer, Item>() ;
    public int getID() {return ID ; }
    public void setID(int ID) {this.ID = ID;}

    shoppingCart(int id){this.ID = id;}
    shoppingCart(){}
    public void AddItem(Item item) {
        if (items.containsKey(item.getId())){
            items.get(item.getId()).updateQuantity(item.getQuantity()) ;
        }
        else
            items.put(item.getId() ,item) ;
    }
    public void removeItem(int id ){
        items.remove(id) ;
    }

    public HashMap<Integer,Item> getItems(){ return items ;}

    public void updateQuantity( int id , int newQuantity) {
        items.get(id).setQuantity(newQuantity);
    }
}
