package org.example;
public class Payment {
    private boolean UponDelivery ;
    private boolean smartWallet ;

    Payment(boolean UponDelivery , boolean smartWallet ){
        try {
            if ( !(UponDelivery && smartWallet)) {
                this.UponDelivery = UponDelivery ;
                this.smartWallet = smartWallet ;
            }
            else
                throw new Exception("j") ;
        }
        catch (Exception e){
            System.out.println("can't pay upon delivery and with the smart wallet") ;
        }
    }
}
