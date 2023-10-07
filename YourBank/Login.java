package YourBank;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import javax.swing.*;

//Actionlistener is impemented to make the button working
public class Login extends JFrame implements ActionListener {
  JButton login, signup;
  JTextField userField;
  JPasswordField passField;
  
  Login() {
    
    setTitle("Apna Bank");// to set title of frame
    setSize(800, 550);// to make the frame give dimensions in setSize() function
    getContentPane().setBackground(Color.CYAN);
    // to getall the frame and set the color;

    setVisible(true);// as automatically frame is hidden,to show use this

    setLocation(300, 250);// to set location from left and top to open acc to us

    setLayout(null);

    JLabel text = new JLabel("Welcome to Apna Bank");
    text.setFont(new Font("Osward", Font.BOLD, 33));
    text.setBounds(200, 50, 400, 50); // to add the text in frame
    getContentPane().add(text);

    JLabel accountNo = new JLabel("AccountNo");
    accountNo.setFont(new Font("Raleway", Font.BOLD, 20));
    accountNo.setBounds(70, 160, 200, 50); // to add the text in frame
    getContentPane().add(accountNo);

    // JTextField userField=new JTextField();//to build textField
    // userField.setBounds(300,160,250,30);
    // getContentPane().add(userField);
    userField = new JTextField();
    userField.setBounds(290, 165, 260, 30);
    getContentPane().add(userField);
    // userField.setVisible(true);

    login = new JButton("SIGN IN");
    login.setBounds(300, 300, 100, 30);
    login.addActionListener(this);
    getContentPane().add(login);

    signup = new JButton("ADD USER");
    signup.setBounds(450, 300, 100, 30);
    signup.addActionListener(this);
    getContentPane().add(signup);

  }

  public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == signup) {
      setVisible(false);
      new AddUser().setVisible(true);
    } else if (ae.getSource() == login) {
      Connect conn=new Connect();
      String accNo=userField.getText();
      String loginQuery="select * from login where accountNo = '"+accNo+"'";
      try{
        ResultSet rs=conn.s.executeQuery(loginQuery);
        if(rs.next()){
          
          ResultSet rs1=conn.s.executeQuery("select *from idpass where role = staff ");
           setVisible(false);
          if(rs1.next()){
          
           new Details(accNo).setVisible(true);
          }
          else{
            new Amount(accNo).setVisible(true);
          }
        }
        else{
          JOptionPane.showMessageDialog(null,"Incorrect Account No");
        }
      }
      catch(Exception e){
        System.out.println(e);
      }

    }

  }

  public static void main(String args[]){
    new Login();
            
    }

}
