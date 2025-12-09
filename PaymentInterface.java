package Practice;
import java.util.Scanner;

abstract class CustomerDetails{
    String CustomerName;
    String mailid;
    long PhNum;

    CustomerDetails(String CustomerName,String mailid,long PhNum){
        this.CustomerName = CustomerName;
        this. mailid =mailid;
        this.PhNum = PhNum;
    }

    abstract void printdetails();

    void customer_info(){
        System.out.println("\n\nCustomer Information : ");
        System.out.println("Name - " + CustomerName + "\nMail ID - " + mailid + "\nMobile Number - " + PhNum);
    }
}

interface TransactionDetails{
    void transaction();
    void getdetails();
}


class CardPayment extends CustomerDetails implements TransactionDetails{
    Scanner sc = new Scanner(System.in);
    String username;
    double cardnum;
    String expiry;
    int cvv;
    int otp;
    double AmountToPay;

    CardPayment(String CustomerName,String mailid,long PhNum, double AmountToPay){
        super(CustomerName, mailid, PhNum);
        this.AmountToPay = AmountToPay;
    }

    public void getdetails(){
        System.out.print("Enter Card Holder Name : ");
        username = sc.nextLine();
        System.out.print("Enter Card Number : ");
        cardnum = sc.nextDouble();
        System.out.print("Enter Expiry Number in the form MM/YY : ");
        expiry = sc.nextLine();
        sc.next();
        System.out.print("Enter Card CVV : ");
        cvv = sc.nextInt();
        System.out.print("Enter OTP : ");
        otp = sc.nextInt();
        System.out.println();
    }
    public void transaction(){
        System.out.println("OrderID - CD2311003020114");
        System.out.print("Total bill amount paid - " + AmountToPay + "\n");
        System.out.print("Payment Type - Card" );
    }

    void printdetails(){
        System.out.println("\n\n******TRANSACTION DETAILS******");
        System.out.println();
        transaction();
        customer_info();
        System.out.println("\n!!!! AMOUNT PAID SUCCESSFULLY !!!!");

    }
}

class UPIPayment extends CustomerDetails implements TransactionDetails{
    Scanner sc = new Scanner(System.in);
    String upiID;
    int upin;
    double AmountToPay;

    UPIPayment(String CustomerName,String mailid,long PhNum, double AmountToPay){
        super(CustomerName, mailid, PhNum);
        this.AmountToPay = AmountToPay;
    }

    public void getdetails(){
        System.out.print("Enter UPI ID : ");
        upiID = sc.nextLine();
        System.out.print("Enter UPI pin : ");
        upin = sc.nextInt();
    }

    public void transaction(){
        System.out.println("OrderID - UP2311003020114");
        System.out.print("Total bill amount paid - " + AmountToPay + "\n");
        System.out.print("Payment Type - UPI" );
    }

    void printdetails(){
        System.out.println("\n\n******TRANSACTION DETAILS******");
        System.out.println();
        transaction();
        customer_info();
        System.out.println("\n!!!! AMOUNT PAID SUCCESSFULLY !!!!");
    }
}

class WalletPayment extends CustomerDetails implements TransactionDetails{
    Scanner sc =new Scanner(System.in);
    int Walletname;
    long LinkedNumber;
    int otp;
    double AmountToPay;

    WalletPayment(String CustomerName,String mailid,long PhNum, double AmountToPay){
        super(CustomerName, mailid, PhNum);
        this.AmountToPay = AmountToPay;
    }

    public void getdetails(){
        System.out.print("Enter Wallet Provider (1.Apple Pay 2.Google Pay 3.Amazon Pay): ");
        Walletname = sc.nextInt();
        if(Walletname == 1){
            System.out.print("Enter mobile number linked to Apple Pay : ");
        }
        else if(Walletname == 2){
            System.out.print("Enter mobile number linked to Google Pay : ");
        }
        else{
            System.out.print("Enter mobile number linked to Amazon Pay : ");
        }
        LinkedNumber = sc.nextLong();
        System.out.print("Enter OTP : ");
        otp = sc.nextInt();
    }

    public void transaction(){
        System.out.println("OrderID - WL2311003020114");
        System.out.print("Total bill amount paid - " + AmountToPay + "\n");
        if(Walletname == 1){
            System.out.print("Payment Type - Apple Pay" );
        }
        else if(Walletname == 2){
            System.out.print("Payment Type - Google Pay" );
        }
        else{
            System.out.print("Payment Type - Aamazon Pay" );
        }
    }

    void printdetails(){
        System.out.println("\n\n******TRANSACTION DETAILS******");
        System.out.println();
        transaction();
        customer_info();
        System.out.println("\n!!!! AMOUNT PAID SUCCESSFULLY !!!!");
    }

}

public class PaymentInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("******WELCOME TO ELITE PAYMENT GATEWAY******");
        System.out.print("Enter Customer Name : ");
        String CustomerName = sc.nextLine();
        System.out.print("\nEnter Customer Email-Id : ");
        String mailid = sc.nextLine();
        System.out.print("\nEnter Customer Phone Number : ");
        long PhNum = sc.nextLong();
        System.out.print("\nEnter Amount to Pay : ");
        double AmountToPay = sc.nextDouble();
        System.out.print("Enter payment type (1.Card Payment / 2.UPI Payment / 3.Wallet Payment) : ");
        int paytype = sc.nextInt();

        if(paytype == 1){
            CardPayment C = new CardPayment(CustomerName, mailid, PhNum, AmountToPay);
            C.getdetails();
            C.printdetails(); 
        }
        else if(paytype == 2){
            UPIPayment U = new UPIPayment(CustomerName, mailid, PhNum, AmountToPay);
            U.getdetails();
            U.printdetails();
        }else if(paytype == 3){
            WalletPayment W = new WalletPayment(CustomerName, mailid, PhNum, AmountToPay);
            W.getdetails();
            W.printdetails();  
        }
        else{
            System.out.println("Invalid Payment Type !!!");
        }
    
    }
}
