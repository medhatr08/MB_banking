package YourBank;

import java.util.Scanner;
class User{
    private int accNo;
    public User(int accNo){
       this.accNo=accNo;
    }
    public int getAccNo(){
        return accNo;
    }

}
class Transaction{
    private int balance;
    public Transaction(){
       balance=1000;
    }
    void depositBalance(int amt){
        balance+=amt;
    }
    void withdrawBalance(int amt){
        if(balance>amt)
        balance-=amt;
        else{
            System.out.println("Cannot withdraw");
        }

    }
    public int getBalance(){
        return balance;
    }

}

public class Bank {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Exist/New User/Staff");
        Boolean b = true;
        String s = sc.nextLine();
        while (b) {
           
            if (s.equals("exist") || s.equals("Exist") ) {
                 System.out.println(s);
                System.out.println("Account No");
                int accountNo=sc.nextInt();
                User user=new User(accountNo);
                //System.out.println("Deposit/Withdraw/Check");
               
                  Transaction t=new Transaction();
                  Boolean b1=true;
                  while(b1){
                  System.out.println("Deposit/Withdraw/Check");
                   String work=sc.next();
                if(work=="Deposit" || work=="deposit"){
                    int amt=sc.nextInt();
                   t.depositBalance(amt);
                  
                }
                else if(work=="Withdraw" || work=="withdraw"){
                     int amt=sc.nextInt();
                     t.withdrawBalance(amt);
                     
                }
                else if(work.equals("Checkbalance")){
                    b1=false;
                    System.out.println(t.getBalance());
                }
            }


                b = false;
            } else if (s == "New User" || s == "new user" || s == "New user" || s == "new User") {
                b = false;
            } else if (s == "Staff" || s == "staff") {
                b = false;
            }
        }

    }
}