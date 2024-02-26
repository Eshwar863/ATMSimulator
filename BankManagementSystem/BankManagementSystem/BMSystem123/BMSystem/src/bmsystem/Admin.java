package bmsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Admin extends JFrame{
    JTextField pincodetf,statetf,citytf,addresstf,emailtf,Dobtf,Fnametf,nametf;
    JLabel formno,name,Dob,pd,Fname,pincode,city,state,address,marital,email,gender;

    JLabel  religion,category,income,eq,occupation,panno,aadharno,senoircitizen,existingacc;
    JButton next;
    JTextField categorytf,incometf,occupationtf,aadharnotf,senoircitizentf,existingacctf,pannotf;
    JComboBox occupationcb,edcb,incomecb,categorycb,religioncb;
    JRadioButton syesrb,snorb,yesrb,norb;
    ButtonGroup Senoircitizenbg,exstbg;
    JRadioButton male,female,unmarriedrb,marriedrb;
    Admin(){setSize(650,800);
    setVisible(true);
    setLocation(370,10);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setTitle("ADMIN");


        name = new JLabel("Name:");
        name.setBounds(40, 5  , 150, 120);
        name.setFont(new Font("Raleway",Font.BOLD,18));
        add(name);

        nametf = new JTextField();
        nametf.setBounds(200, 55,200,23);
        add(nametf);

        Fname = new JLabel("Father's Name:");
        Fname.setBounds(40, 40  , 150, 120);
        Fname.setFont(new Font("Raleway",Font.BOLD,18));
        add(Fname);

        Fnametf = new JTextField();
        Fnametf.setBounds(200,90,200,23);
        add(Fnametf);

        Dob = new JLabel("Date of Birth:");
        Dob.setBounds(40, 75  , 150, 120);
        Dob.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(Dob);

        Dobtf = new JTextField();
        Dobtf.setBounds(200,125,200,23);
        add(Dobtf);

        email = new JLabel("Email Address:");
        email.setBounds(40,110,150,120);
        email.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(email);

        emailtf = new JTextField();
        emailtf.setBounds(200,160,200,23);
        add(emailtf);


        address = new JLabel("Address:");
        address.setBounds(40, 140,150, 120);
        address.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(address);

        addresstf = new JTextField();
        addresstf.setBounds(200,195,200,23);
        add(addresstf);

        city = new JLabel("City:");
        city.setBounds(40,175,150,120);
        city.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(city);

        citytf = new JTextField();
        citytf.setBounds(200,225,200,23);
        add(citytf);

        state = new JLabel("State:");
        state.setBounds(40,205,150,120);
        state.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(state);

        statetf = new JTextField();
        statetf.setBounds(200,255,200,23);
        add(statetf);

        pincode = new JLabel("Pin code:");
        pincode.setBounds(40,240,150,120);
        pincode.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(pincode);

        pincodetf = new JTextField();
        pincodetf.setBounds(200,290,200,23);
        add(pincodetf);
        religion = new JLabel("Religion:");
        religion.setBounds(40, 275  , 150, 120);
        religion.setFont(new Font("Raleway",Font.BOLD,18));
        add(religion);

        String arrreligion[]={"Hindu","Muslim","Cristian","Sikh","Other"};
        religioncb = new JComboBox(arrreligion);
        religioncb.setBounds(200, 325,200,23);
        add(religioncb);

        category = new JLabel("Category:");
        category.setBounds(40, 310  , 150, 120);
        category.setFont(new Font("Raleway",Font.BOLD,18));
        add(category);

        String arrcategory[]={"General","OBC","ST","SC","Other"};
        categorycb = new JComboBox(arrcategory);
        categorycb.setBounds(200,360,200,23);
        add(categorycb);

        income = new JLabel("Income:");
        income.setBounds(40, 345  , 150, 120);
        income.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(income);

        String arrincome[]={"Null","1,00,000","5,00,000","8,00,000","10,00,000","10,00,000&Above"};
        incomecb = new JComboBox(arrincome);
        incomecb.setBounds(200,395,200,23);
        add(incomecb);
        eq = new JLabel("Edu Qualification:");
        eq.setBounds(40, 380, 230, 120);
        eq.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(eq);

        String  arred[] ={"Graduate","PostGraduate","UnderGraduate","Student","Other"};
        edcb = new JComboBox(arred);
        edcb.setBounds(200,430,200,23);
        add(edcb);

        occupation = new JLabel("Occupation:");
        occupation.setBounds(40,415,150,120);
        occupation.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(occupation);

        String  arrocupation[] ={"Salaried","Self Employed","Bussiness","Student","Other"};
        occupationcb = new JComboBox(arrocupation);
        occupationcb.setBounds(200,465,200,23);
        add(occupationcb);

        panno = new JLabel("PAN Number:");
        panno.setBounds(40,450,150,120);
        panno.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(panno);


        pannotf = new JTextField();
        pannotf.setBounds(200,500,200,23);
        add(pannotf);


        aadharno= new JLabel("Aadhar Number:");
        aadharno.setBounds(40, 485,150, 120);
        aadharno.setFont(new Font("Raleway",Font.BOLD,18 ));
        add(aadharno);

        aadharnotf = new JTextField();
        aadharnotf.setBounds(200,535,200,23);
        add(aadharnotf);



    }
public static void main(String[] args){
    new Admin();
}
}
