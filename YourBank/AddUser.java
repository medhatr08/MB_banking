package YourBank;

import java.awt.Color;
import java.awt.Font;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;

public class AddUser extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, dobTextField, emailTextField, phnTextField, addressTextField;
    JButton next;
    JRadioButton male, female;

    AddUser() {
        setLayout(null);
        setTitle("Apna Bank");
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000);

        JLabel formNo = new JLabel("Application Form No. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 30));
        formNo.setBounds(210, 20, 600, 40);
        add(formNo);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(140, 150, 150, 30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        nameTextField.setBounds(310, 150, 300, 30);
        add(nameTextField);

        JLabel dob = new JLabel("DOB:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(140, 200, 150, 30);
        add(dob);
        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        dobTextField.setBounds(310, 200, 300, 30);
        add(dobTextField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(140, 250, 150, 30);

        add(gender);
        male = new JRadioButton("Male");

        male.setBounds(310, 250, 70, 30);
        male.setBackground(Color.CYAN);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(400, 250, 90, 30);
        female.setBackground(Color.CYAN);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel phnNo = new JLabel("Phone Number:");
        phnNo.setFont(new Font("Raleway", Font.BOLD, 20));
        phnNo.setBounds(140, 300, 200, 30);
        add(phnNo);
        phnTextField = new JTextField();
        phnTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        phnTextField.setBounds(310, 300, 300, 30);
        add(phnTextField);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(140, 350, 150, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        emailTextField.setBounds(310, 350, 300, 30);
        add(emailTextField);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(140, 400, 150, 30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        addressTextField.setBounds(310, 400, 300, 30);
        add(addressTextField);

        next = new JButton("Next");
        next.setBounds(310, 470, 100, 30);
        add(next);
        next.addActionListener(this);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.CYAN);

    }

    public void actionPerformed(ActionEvent we) {
        String formNo=String.valueOf(random);
        String name=nameTextField.getText();
        String dob=dobTextField.getText();
        String email= emailTextField.getText();
        String phn= phnTextField.getText();
        String address= addressTextField.getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }
        else {
            gender="female";
        }
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else{
                Connect c=new Connect();
                String query="insert into signup values('"+formNo+"','"+name+"','"+ dob+"','"+ email+"','"+ gender+"','" +address+"','" +phn+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new GetuserDetails(formNo).setVisible(true);

            }
        }
        catch(Exception e){
            System.out.println(e);
        }



    }

    public static void main(String args[]) {
        new AddUser();

    }

}
