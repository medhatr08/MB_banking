package YourBank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Amount extends JFrame implements ActionListener  {
     JButton deposit,withdraw;
     String accNo;
    Amount(String accNo){
        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);
       
        //getContentPane().setBackground(Color.CYAN);
        setVisible(true);

       this.accNo=accNo;
        JLabel dewi=new JLabel("Deposit/Withdraw");
        dewi.setBounds(250,50,400,40);
        dewi.setFont(new Font("Osward",Font.BOLD,30));
        add(dewi);

         deposit =new JButton("Deposit");
         deposit.setBounds(250,200,90,30);
         deposit.addActionListener(this);
         add(deposit);

          withdraw =new JButton("Withdraw");
         withdraw.setBounds(400,200,100,30);
         withdraw.addActionListener(this);
         add(withdraw);
    }


     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==deposit){
             setVisible(false);
             new Deposit(accNo).setVisible(true);
         }
         else if(ae.getSource()==withdraw){
             setVisible(true);
             new Withdrawl(accNo).setVisible(true);

         }
     }

        public static void main(String args[]){
            new Amount("");
        }
}
