package YourBank;

import java.awt.Color;
import java.awt.Font;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class GetuserDetails extends JFrame implements ActionListener{
    JRadioButton savings ,current;
    JButton submit;
     long accountNo=10000000;

     String formNo;
    GetuserDetails(String formNo){
        this.formNo=formNo;
        setLayout(null);
       setSize(800,900);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.CYAN);


        JLabel l1=new JLabel("Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        l1.setBounds(300,40,300,40);
        add(l1);
         JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(150,300,200,40);
        add(type);

       

        
        savings =new JRadioButton("Savings Acccount");
        savings.setFont(new Font("Raleway",Font.BOLD,20));
        savings.setBounds(300,300,200,30);
        savings.setBackground(Color.CYAN);
        add(savings);

        current =new JRadioButton("Current Acccount");
        current.setFont(new Font("Raleway",Font.BOLD,20));
        current.setBounds(520,300,200,30);
        current.setBackground(Color.CYAN);
        add(current);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(savings);
        accountGroup.add(current);
       
        submit=new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBounds(300,400,100,40);
        add(submit);
        submit.addActionListener(this);

    }

    public void actionPerformed(ActionEvent we){
         
        String accountType=null;
        if(savings.isSelected()){
            accountType="savings";
        }
        else{
            accountType="current";
        }
        try{
            Connect c=new Connect();
            String queryacc="select * from getUser";
            ResultSet rs=c.s.executeQuery(queryacc);
          

            while(rs.next()){
                long num=Integer.parseInt(rs.getString("accountNo"));
                if(accountNo<num){
                    accountNo=num;
                }
            }

            accountNo++;
            System.out.println(accountNo);

            String querygetUser="insert into getUser values('"+formNo+"','"+accountType+"','"+accountNo+"')";
             c.s.executeUpdate(querygetUser);
           JOptionPane.showMessageDialog(null,"AccountNo"+accountNo);
           String queryLogin="insert into login values('"+formNo+"','"+accountNo+"')";
          c.s.executeUpdate(queryLogin);
          setVisible(false);
          String accNo=String.valueOf(accountNo);
          new Deposit(accNo).setVisible(true);
             accountNo++;
            
        }
        catch(Exception e){
            System.out.println(e);
        }




    }
    public static void  main(String args[]){
        new GetuserDetails("");
        
    }
    
}
