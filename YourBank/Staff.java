package YourBank;

import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

public class Staff extends JFrame implements ActionListener {
    JTextField branchTextField,userTextField;
    JPasswordField passTextField;
    JButton submit;
   Staff(){
    JLabel login=new JLabel("Login");
    login.setBounds(300,20,100,35);
   login.setFont(new Font("Osward",Font.BOLD,30));
    add(login);

    JLabel branchName=new JLabel("Branch Name: ");
    branchName.setBounds(150,100,200,30);
   branchName.setFont(new Font("Raleway",Font.BOLD,20));
    add(branchName);
    branchTextField =new JTextField();
    branchTextField.setBounds(300,105,200,20);
    add(branchTextField);

    JLabel userId=new JLabel("User Id: ");
    userId.setBounds(150,170,200,30);
    userId.setFont(new Font("Raleway",Font.BOLD,20));
    add(userId);
    userTextField =new JTextField();
    userTextField.setBounds(300,175,200,20);
    add(userTextField);

    JLabel pass=new JLabel("Password: ");
    pass.setBounds(150,230,200,30);
    pass.setFont(new Font("Raleway",Font.BOLD,20));
    add(pass);
    passTextField =new JPasswordField();
    passTextField.setBounds(300,235,200,20);
    add(passTextField);

    submit =new JButton("Submit");
    submit.setBounds(300,270,100,20);
    submit.addActionListener(this);
    add(submit);



        setLayout(null);
        setSize(800, 900);
        setVisible(true);
        setLocation(300,250);
        
    }
    public void actionPerformed(ActionEvent ae){
        Connect conn =new Connect();
      String userField=userTextField.getText();
        String passField=passTextField.getPassword().toString();
       try{
        ResultSet rs=conn.s.executeQuery("Select * from idpass where userid = "+userField+" and pass = "+passField);

            if(rs.next()){
                System.out.println(rs.getString("userid"));
                System.out.println(rs.getString("pass"));
                
                    setVisible(false);
                    new Login().setVisible(true);
                
                
            }
            else{
                    JOptionPane.showMessageDialog(null,"Incorrect User id or password");
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
       new  Staff();
    }
}
