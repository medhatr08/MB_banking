package YourBank;
import java.awt.Color;

import javax.swing.*;
import java.sql.*;


public class MiniStatement extends JFrame {
    String accNo;
    MiniStatement(String accNo){
        this.accNo=accNo;
        setLayout(null);

        JLabel mini=new JLabel();
        add(mini);

        JLabel bank=new JLabel("Apna Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel acc=new JLabel();
        acc.setBounds(20,80,300,20);
        add(acc);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        int bal=0;
        try{
            Connect c=new Connect();
           ResultSet rs= c.s.executeQuery("select * from login where accountNo = '"+accNo+"'");
           while(rs.next()){
            acc.setText("AccountNumber: "+"XXXXXXX"+rs.getString("accountNo").substring(7));
           



           }
           
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            Connect conn=new Connect();
           ResultSet rs= conn.s.executeQuery("select * from balance where accountNo = '"+accNo+"'");
           mini.setText(mini.getText()+"<html>");
           while(rs.next()){
           System.out.println(rs);
            mini.setText(mini.getText()  + rs.getString("dates")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("typ") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("ammount")+"<br><br>");//&nbsp add spaces
             System.out.println(mini.getText());
            if(rs.getString("typ").equals("Deposit")){
                bal+=Integer.parseInt(rs.getString("ammount"));
            }
            else{
                bal-=Integer.parseInt(rs.getString("ammount"));
            }


           }
            mini.setText(mini.getText()+"</html>");

            balance.setText("Your current account balance is Rs "+bal);

        }
        catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);


        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20,20);
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
