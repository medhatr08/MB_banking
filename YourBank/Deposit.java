package YourBank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
     JTextField ammountTextField;
     JButton deposit,back;
     String accNo;
    Deposit(String accNo){
        this.accNo=accNo;
        setLayout(null);

        JLabel text=new JLabel("Ammount you want to deposit:");
        text.setBounds(100,200,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        add(text);

         ammountTextField=new JTextField();
        ammountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        ammountTextField.setBounds(450,200,250,25);
        add(ammountTextField);

         back =new JButton("Back");
    back.setBounds(450,300,100,30);
        add(back);
        back.addActionListener(this);
        
        deposit =new JButton("Deposit");
        deposit.setBounds(600,300,100,30);
        add(deposit);
        deposit.addActionListener(this);

       


        
        setSize(700, 600);
        setLocation(300, 0);
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=ammountTextField.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the ammount");
            }
            else{
                Connect conn=new Connect();
                String query="insert into balance values('"+accNo+"', '"+date+"', 'Deposit', '"+number+"')";
                try{
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Succesfully");
                setVisible(false);
                new Details(accNo).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

        }
        else {
            setVisible(false);
            new Details(accNo).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Deposit("");
    }
}
