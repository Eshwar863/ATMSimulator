
package bmsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.awt.event.*;
public class Signup1 extends JFrame implements ActionListener {
    long ran;
    JLabel formno,name,Dob,pd,Fname,pincode,city,state,address,marital,email,gender;
    JButton next;
    JTextField pincodetf,statetf,citytf,addresstf,emailtf,Dobtf,Fnametf,nametf;
    JRadioButton male,female,unmarriedrb,marriedrb;
    Signup1(){
    
    
    setSize(650,800);
    setVisible(true);
    setLocation(250,10);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setTitle("SIGNUP pg 1");
    
    Random ranno = new Random();
    ran = Math.abs((ranno.nextLong() % 9000L) + 1000L);
    
     formno = new JLabel("APPLICATION FORM NO :"+ ran);
    formno.setBounds(45, 4, 500, 120);
    formno.setFont(new Font("Osward",Font.BOLD,28));
    add(formno);
        
     pd = new JLabel("Page 1:Personal Details");
    pd.setBounds(120, 50  , 400, 120);
    pd.setFont(new Font("Raleway",Font.BOLD,22));
    add(pd);
    
     name = new JLabel("Name:");
    name.setBounds(40, 95  , 150, 120);
    name.setFont(new Font("Raleway",Font.BOLD,18));
    add(name);
    
     nametf = new JTextField();
    nametf.setBounds(200, 145,200,23);
    add(nametf);
    
     Fname = new JLabel("Father's Name:");
    Fname.setBounds(40, 130  , 150, 120);
    Fname.setFont(new Font("Raleway",Font.BOLD,18));
    add(Fname);
    
     Fnametf = new JTextField();
    Fnametf.setBounds(200,180,200,23);
    add(Fnametf);
    
     Dob = new JLabel("Date of Birth:");
    Dob.setBounds(40, 165  , 150, 120);
    Dob.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(Dob);
     
     Dobtf = new JTextField();
    Dobtf.setBounds(200,215,200,23);
    add(Dobtf);
    
     gender = new JLabel("Gender:");
    gender.setBounds(40, 200  , 150, 120);
    gender.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(gender);
    
    male = new JRadioButton("Male");
    male.setBounds(200,250,90,23);
    add(male);
    
     female= new JRadioButton("Female");
    female.setBounds(300,250,100,23);
    add(female);
    
    ButtonGroup gendergroup = new ButtonGroup();
    gendergroup.add(male);
    gendergroup.add(female);
    /**JTextField gendertf = new JTextField();
    gendertf.setBounds(200,250,150,23);
    add(gendertf);**/
    
     email = new JLabel("Email Address:");
    email.setBounds(40,235,150,120);
    email.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(email);
    
     emailtf = new JTextField();
    emailtf.setBounds(200,285,200,23);
    add(emailtf);
    
     marital = new JLabel("Marital Status:");
    marital.setBounds(40,270,150,120);
    marital.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(marital);
     marriedrb = new JRadioButton("Married");
    marriedrb.setBounds(200,320,90,23);
    add(marriedrb);
    
   unmarriedrb = new JRadioButton("Unmarried");
    unmarriedrb.setBounds(300,320,100,23);
    add(unmarriedrb);
    
    ButtonGroup maritalbg = new ButtonGroup();
    maritalbg.add(marriedrb);
    maritalbg.add(unmarriedrb);
    /**JTextField maritaltf = new JTextField();
    maritaltf.setBounds(200,320,150,23);
    add(maritaltf);
    **/
    
     address = new JLabel("Address:");
    address.setBounds(40, 305,150, 120);
    address.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(address);
    
     addresstf = new JTextField();
    addresstf.setBounds(200,355,200,23);
    add(addresstf);
    
     city = new JLabel("City:");
    city.setBounds(40,340,150,120);
    city.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(city);
    
     citytf = new JTextField();
    citytf.setBounds(200,390,200,23);
    add(citytf);
    
     state = new JLabel("State:");
    state.setBounds(40,375,150,120);
    state.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(state);
    
     statetf = new JTextField();
    statetf.setBounds(200,425,200,23);
    add(statetf);
    
     pincode = new JLabel("Pin code:");
    pincode.setBounds(40,410,150,120);
    pincode.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(pincode);
    
     pincodetf = new JTextField();
    pincodetf.setBounds(200,460,200,23);
    add(pincodetf);
    
   
    
     next= new JButton("NEXT");
    next.setBounds(150,505,100,28);
    next.setBackground(Color.WHITE);
    next.setForeground(Color.BLACK);
    next.addActionListener(this);
    add(next);
    }
    public void actionPerformed(ActionEvent ae) {
        String dbformno = "" + ran;
        String dbname = nametf.getText();

        String dbfname = Fnametf.getText();

        /** try{
         if(dbname.equals("")){
         JOptionPane.showMessageDialog(null,"NAME IS REQ");
         }
         }
         catch(Exception e){
         System.out.println();
         }**/

        String dbDob = Dobtf.getText();
        String dbgender = null;
        if (male.isSelected()) {
            dbgender = "Male";
        } else if (female.isSelected()) {
            dbgender = "Female";
        }

        String dbemail = emailtf.getText();
        String dbmarital = null;
        if (marriedrb.isSelected()) {
            dbmarital = "Married";
        } else if (unmarriedrb.isSelected()) {
            dbmarital = "UnMarried";
        }
        String dbaddress = addresstf.getText();
        String dbcity = citytf.getText();
        String dbstate = statetf.getText();
        int dbpincode = Integer.parseInt(pincodetf.getText());
        if (dbname.equals("")) {

            JOptionPane.showMessageDialog(null, "NAME IS REQ ");

        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");
                String query = "INSERT INTO commontable(formNo, name, fatherName, DOB, gender, email, maritalStatus, address, city, state, pinCode) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement p = c.prepareStatement(query);
                p.setString(1, dbformno);
                p.setString(2, dbname);
                p.setString(3, dbfname);
                p.setString(4, dbDob);
                p.setString(5, dbgender);
                p.setString(6, dbemail);
                p.setString(7, dbmarital);
                p.setString(8, dbaddress);
                p.setString(9, dbcity);
                p.setString(10, dbstate);
                p.setInt(11, dbpincode);

                int i = p.executeUpdate();
                if (i > 0)
                    System.out.println("Success");
                else
                    System.out.println("Invalid");
                setVisible(false);
                new Signup2(dbformno).setVisible(true);

            }
            /**dbformno,dbname,dbfname,dbDob,dbgender,dbemail,dbmarital,dbaddress,dbcity,dbstate,dbpincode**/ catch (
                    Exception e) {
                System.out.println(e);
            }
        }
    }
     /**if(ae.getSource()==next)
      {
          setVisible(false);
          new Signup2().setVisible(true);
      }
    }**/     
    
    public static void main(String[] args)
    {
     new Signup1();
     
    }}
  
//formno varchar(25), namevarchar(25), fname varchar(25),Dob varchar(25), gender varchar(25), email varchar(32),marital varchar(25), address varchar(40), city varchar(25), state varchar(25),pincode varchar(25)   
// religion varchar(25), category varchar(25), income varchar(30),eduqualification varchar(30), occupation varchar(30), panno varchar(42), aadharno varchar(42), Senoircitizenbg varchar(25), exstbg varchar(25)