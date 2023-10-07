package YourBank;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;


public class Details extends JFrame  implements ActionListener  {
    
        Connect conn=new Connect();
       
        String detailQuery="select * from signup";
        String namesql="";
        String dobsql="";
        String phnsql="";
        String addresssql="";
        String gendersql="";
        String accNo;
       
        JButton deposit,withdraw,ministatement,checkBalance;

        Details(String accNo){
            this.accNo=accNo;
             setLayout(null);
             String accQuery="select * from login where accountNo = '"+accNo+"'";

        try{
            ResultSet rs=conn.s.executeQuery(accQuery);
            if(rs.next()){
                ResultSet rsdetail=conn.s.executeQuery(detailQuery);
            while(rsdetail.next()){
                namesql=rsdetail.getString("namefield");
                 dobsql=rsdetail.getString("dob");
                  gendersql=rsdetail.getString("gender");
                  addresssql=rsdetail.getString("address");
                   phnsql=rsdetail.getString("phn");
            }
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
        JLabel userdetail = new JLabel("User Details");
        userdetail.setFont(new Font("Raleway", Font.BOLD, 40));
        userdetail.setBounds(400, 40, 300, 50);
        add(userdetail);
         JLabel accounNo = new JLabel("AccountNo:  ");
        accounNo.setFont(new Font("Raleway", Font.ITALIC,10));
        accounNo.setBounds(400, 90, 100, 20);
        add(accounNo);
         JLabel accountfield = new JLabel(accNo);
        accountfield.setFont(new Font("Raleway", Font.ITALIC,10));
        accountfield.setBounds(450, 90, 100, 20);
        add(accountfield);


        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(200, 140, 100, 20);
        add(name);
        JLabel namedetail = new JLabel(namesql);
        namedetail.setFont(new Font("Raleway", Font.BOLD, 20));
        namedetail.setBounds(450, 140, 150, 30);
        add(namedetail);

         JLabel dob = new JLabel("DOB:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(200, 200, 100, 20);
        add(dob);
        JLabel dobdetail = new JLabel(dobsql);
        dobdetail.setFont(new Font("Raleway", Font.BOLD, 20));
        dobdetail.setBounds(450, 200, 100, 30);
        add(dobdetail);

         JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(200, 260, 100, 20);
        add(gender);
        JLabel genderdetail = new JLabel(gendersql);
        genderdetail.setFont(new Font("Raleway", Font.BOLD, 20));
        genderdetail.setBounds(450, 260, 100, 30);
        add(genderdetail);

         JLabel phn = new JLabel("Phone Number:");
        phn.setFont(new Font("Raleway", Font.BOLD, 20));
        phn.setBounds(200, 320, 200, 20);
        add(phn);
        JLabel phndetail = new JLabel(phnsql);
        phndetail.setFont(new Font("Raleway", Font.BOLD, 20));
        phndetail.setBounds(450, 320, 100, 30);
        add(phndetail);

         JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(200, 400, 100, 20);
        add(address);
        JLabel addressdetail = new JLabel(addresssql);
        addressdetail.setFont(new Font("Raleway", Font.BOLD, 20));
        addressdetail.setBounds(450, 400, 200, 30);
        add(addressdetail);


        deposit =new JButton("Deposit");
        deposit.setBounds(450,600,90,30);
        deposit.addActionListener(this);
        add(deposit);

         withdraw =new JButton("Withdraw");
        withdraw.setBounds(600,600,100,30);
        withdraw.addActionListener(this);
        add(withdraw);

         ministatement =new JButton("Ministatement");
        ministatement.setBounds(450,700,150,30);
        ministatement.addActionListener(this);
        add(ministatement);

         checkBalance =new JButton("CheckBalance");
        checkBalance.setBounds(620,700,150,30);
        checkBalance.addActionListener(this);
        add(checkBalance);




       
        setSize(850, 800);
        setLocation(350, 10);
       
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);


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
         else if(ae.getSource()==ministatement){

            setVisible(true);
            new MiniStatement(accNo).setVisible(true);
        }
         else if(ae.getSource()==checkBalance){
            setVisible(true);
            new CheckBalance(accNo).setVisible(true);

            
        }
    }

    public static void main(String args[]){
        new Details("");
    }
}
