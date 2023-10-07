package YourBank;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import javax.swing.JFrame;

public class CheckBalance extends JFrame implements ActionListener {
    JButton back;
    String accNo;
    CheckBalance(String accNo){
        this.accNo=accNo;
        setLayout(null);

        back= new JButton("Back");
        back.setBounds(30,50,100,30);
        back.addActionListener(this);
        add(back);

        Connect conn =new Connect();
         int balance=0;
        try{
            ResultSet rs=conn.s.executeQuery("select * from balance where accountNo = '"+accNo+"'");
           
            while(rs.next()){
                if(rs.getString("typ").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("ammount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("ammount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("Your Balance: ");
        text.setBounds(150,250,250,30);
        text.setFont(new Font("Raleway",Font.BOLD,30));
        add(text);

        JLabel currbal=new JLabel(String.valueOf(balance));
        currbal.setBounds(400,250,150,30);
        currbal.setFont(new Font("Raleway",Font.BOLD,30));
        add(currbal);

        setSize(600, 600);
        setLocation(300, 0);
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Details(accNo).setVisible(true);
    }
    public static void main(String args[]){
        new CheckBalance("");
    }
    
}
