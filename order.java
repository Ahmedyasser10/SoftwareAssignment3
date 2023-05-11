import java.util.Map;

public class order {
    private shoppingCart cart ;
    private boolean status ;
    private int id ;
    public order(shoppingCart cart ){
        this.cart = cart ;
        this.status = false ;
    }

    public void cancelOrder (){
        this.cart = null ;
        this.status = false ;
    }
    public boolean makeOrder(DataBase DB){
        this.status =true ;
        return DB.closeOrder(cart) ;
    }


}
