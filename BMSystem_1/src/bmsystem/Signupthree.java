
package bmsystem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener{
    JButton cancelb,submitb;
    JLabel app,acctype,cardnol,pinnol,subpinnol,subcardnol,servicesl,cardnotf,pinnotf;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JRadioButton savingsrb,currentsrb,FDrb,RDrb;
    ButtonGroup acctypebg;
    String dbformno1;
    Signupthree(String dbformno){
         this.dbformno1 = dbformno;
    setLayout(null);
    setSize(800,780);
    setVisible(true);
    setLocation(200,15);
    getContentPane().setBackground(Color.WHITE);
    
    
    app= new JLabel("Page 3: Account Details");
    app.setBounds(200, 50, 500, 50);
    app.setFont(new Font("Oswards",Font.BOLD,30));
    add(app);
   
    acctype = new JLabel("Account Type:");
    acctype.setBounds(125,100,200,50);
    acctype.setFont(new Font("Oswards",Font.BOLD,25));
    add(acctype);
    
    savingsrb = new JRadioButton("Savings Account");
    savingsrb.setBounds(155,160,125,30);
    savingsrb.setFont(new Font("Raleway",Font.BOLD,12));
    savingsrb.setBackground(Color.WHITE);
    savingsrb.setForeground(Color.BLACK);
    add(savingsrb);
    
    currentsrb = new JRadioButton("Current Account");
    currentsrb.setBounds(155,200,125,30);
    currentsrb.setFont(new Font("Raleway",Font.BOLD,12));
    currentsrb.setBackground(Color.WHITE);
    currentsrb.setForeground(Color.BLACK);
    add(currentsrb);
    
    FDrb = new JRadioButton("Fixed Deposit Account");
    FDrb.setBounds(310,160,180,30);
    FDrb.setFont(new Font("Raleway",Font.BOLD,12));
    FDrb.setBackground(Color.WHITE);
    FDrb.setForeground(Color.BLACK);
    add(FDrb);
    
    RDrb = new JRadioButton("Recurring Deposit Account");
    RDrb.setBounds(310,200,200,30);
    RDrb.setFont(new Font("Raleway",Font.BOLD,12));
    RDrb.setBackground(Color.WHITE);
    RDrb.setForeground(Color.BLACK);
    add(RDrb);
    
    acctypebg = new ButtonGroup();
    acctypebg.add(savingsrb);
    acctypebg.add(currentsrb);
    acctypebg.add(FDrb);
    acctypebg.add(RDrb);
    
    
    cardnol = new JLabel("Card Number ");
    cardnol.setBounds(125,250,200,50);
    cardnol.setFont(new Font("Oswards",Font.BOLD,25));
    add(cardnol);
    
    subcardnol = new JLabel("your 16 digit card no");
    subcardnol.setBounds(140,270,200,50);
    subcardnol.setFont(new Font("Oswards",Font.BOLD,10));
    add(subcardnol);
    cardnotf = new JLabel("XXXX-XXXX-XXXX-");
    cardnotf.setBounds(320,266,300,22);
    cardnotf.setFont(new Font("Oswards",Font.BOLD,23));
    add(cardnotf);
    
    pinnol = new JLabel("PIN Number ");
    pinnol.setBounds(125,320,200,50);
    pinnol.setFont(new Font("Oswards",Font.BOLD,25));
    add(pinnol);
    
    subpinnol = new JLabel("your 4 digit pin no");
    subpinnol.setBounds(140,340,200,50);
    subpinnol.setFont(new Font("Oswards",Font.BOLD,10));
    add(subpinnol);
    
    pinnotf = new JLabel("XXXX");
    pinnotf.setBounds(320,335,200,22);
    pinnotf.setFont(new Font("Oswards",Font.BOLD,23));
    add(pinnotf);
    
    servicesl = new JLabel("Services Required");
    servicesl.setBounds(125,390,250,50);
    servicesl.setFont(new Font("Oswards",Font.BOLD,25));
    add(servicesl);
    
    c4 = new JCheckBox("ATM");
    c4.setBounds(155,450,80,30);
    c4.setFont(new Font("Raleway",Font.BOLD,12));
    c4.setBackground(Color.WHITE);
    c4.setForeground(Color.BLACK);
    add(c4);
    
    c1 = new JCheckBox("Internet Banking ");
    c1.setBounds(155,500,125,30);
    c1.setFont(new Font("Raleway",Font.BOLD,12));
    c1.setBackground(Color.WHITE);
    c1.setForeground(Color.BLACK);
    add(c1);
    
    c2 = new JCheckBox("Mobile Banking");
    c2.setBounds(460,450,150,30);
    c2.setFont(new Font("Raleway",Font.BOLD,12));
    c2.setBackground(Color.WHITE);
    c2.setForeground(Color.BLACK);
    add(c2);
    
    c3 = new JCheckBox("Email & Sms Alerts");
    c3.setBounds(310,450,150,30);
    c3.setFont(new Font("Raleway",Font.BOLD,12));
    c3.setBackground(Color.WHITE);
    c3.setForeground(Color.BLACK);
    add(c3);
    
    c5 = new JCheckBox("Cheque Book");
    c5.setBounds(310,500,120,30);
    c5.setFont(new Font("Raleway",Font.BOLD,12));
    c5.setBackground(Color.WHITE);
    c5.setForeground(Color.BLACK);
    add(c5);
    
    c6 = new JCheckBox("E-Statement");
    c6.setBounds(460,500,150,30);
    c6.setFont(new Font("Raleway",Font.BOLD,12));
    c6.setBackground(Color.WHITE);
    c6.setForeground(Color.BLACK);
    add(c6);
    
    submitb= new JButton("Submit");
    submitb.setBounds(210,590,100,30);
    submitb.setBackground(Color.WHITE);
    submitb.setForeground(Color.BLACK);
    submitb.addActionListener(this);
    add(submitb);
    cancelb= new JButton("Cancel");
    cancelb.setBounds(350,590,100,30);
    cancelb.setBackground(Color.WHITE);
    cancelb.addActionListener(this);
    cancelb.setForeground(Color.BLACK);
    
    add(cancelb);
    }
    
        public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==submitb){
              String dbformno2 = dbformno1;
          String dbAccountType = null;
          if(savingsrb.isSelected()){
             dbAccountType ="Savings Account";
          } 
          else if(currentsrb.isSelected()){
             dbAccountType ="Currents Account";}
          else if(FDrb.isSelected()){
             dbAccountType ="Fixed Deposit Account";}
           else if(RDrb.isSelected()){
             dbAccountType ="Recurring Deposit Account";}
          
          
          Random random = new Random();
          String dbcardnor = "" + Math.abs((random.nextLong() % 90000000)+5040936000000000L);
          String dbpinnor = "" + Math.abs((random.nextLong() % 9000L)+1000L);
          
          String dbfacility = "  ";
         if(c1.isSelected()){
             dbfacility= dbfacility+"Internet Banking";
         }
         else if(c2.isSelected()){
             dbfacility= dbfacility+"Mobile Banking";
         }
         else if(c3.isSelected()){
             dbfacility= dbfacility+"Email & Sms Alerts";
         }
         else if(c4.isSelected()){
             dbfacility= dbfacility+"ATM ";
         }
         else if(c5.isSelected()){
             dbfacility= dbfacility+"Cheque Book";
         }
         else if(c6.isSelected()){
             dbfacility= dbfacility+"E-Statement";
         }
         try{
     
     
         
         Conn con1 = new Conn();
         String query = "insert into signupthree values( '"+dbformno2+"','"+dbAccountType+"','"+dbcardnor+"','"+dbpinnor+"','"+dbfacility+"')";
         String querylogin = "insert into login values('"+dbformno2+"', '"+dbcardnor+"','"+dbpinnor+"')";
         
         con1.s.executeUpdate(query);
         con1.s.executeUpdate(querylogin);
         
         
         JOptionPane.showMessageDialog(null, " Card no: " + dbcardnor + "\n Pinno: "+ dbpinnor ); 
         
         
         
         setVisible(false);
         new Login().setVisible(true);
         }
         catch(Exception e){
         System.out.println(e);}
          }
        else if(ae.getSource()==cancelb){
        setVisible(false);
        }
        }

public static void main (String [] args){
new Signupthree("");
}
}
