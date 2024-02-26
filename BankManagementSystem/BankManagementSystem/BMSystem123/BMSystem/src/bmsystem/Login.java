    
package bmsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;   
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{    
    JLabel Atm,card,pin;
    JButton clear,signup,signin;
    JTextField cardtf;
    JPasswordField pintf;
  Login()
  {   setTitle("ATM");
      setLayout(null);
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));  
     Image i2 = i1.getImage().getScaledInstance(80,80,80);
     ImageIcon i3=new ImageIcon(i2);   
      JLabel label=new JLabel(i3);
      label.setBounds(80, 80, 80, 80);
      add(label);
      
      getContentPane().setBackground(Color.WHITE);
      
      ImageIcon s1= new ImageIcon(ClassLoader.getSystemResource("icon/secured.png"));  
      Image s2 = s1.getImage().getScaledInstance(30,30,30);
      ImageIcon s3=new ImageIcon(s2);   
      JLabel la=new JLabel(s3);
      la.setBounds(685, 350, 80, 80);
      add(la);
      
       JLabel Atm = new JLabel("WELCOME TO ATM");
      Atm.setFont(new Font("Osward",Font.BOLD,38));
      Atm.setBounds(185,100,400,50);
      add(Atm);

       card = new JLabel("Card no :");
      card.setFont(new Font("Raleway",Font.BOLD,30));
      card.setBounds(185,160,150,50);
      add(card);
      
       pin = new JLabel("PIN         :");
      pin.setFont(new Font("Raleway",Font.BOLD,30));
      pin.setBounds(185,220,150,50);
      add(pin);
      
       cardtf=new JTextField();
      cardtf.setBounds(320,172,160,30); 
      add(cardtf);
      
      pintf=new JPasswordField();
      pintf.setBounds(320,233,160,30); 
      add(pintf);
      
      signin =new JButton("SIGN IN");
      signin.setBounds(220,280,100,30);
      signin.setBackground(Color.WHITE);
      signin.setForeground(Color.BLACK);
      signin.addActionListener(this);
      add(signin);
      
       signup =new JButton("SIGN UP");
      signup.setBounds(360,280,100,30);
      signup.setBackground(Color.WHITE);
      signup.setForeground(Color.BLACK);
      signup.addActionListener(this);
      add(signup);
      
       clear =new JButton("CLEAR");
      clear.setBounds(290,320,100,30);
      clear.setBackground(Color.WHITE);
      clear.setForeground(Color.BLACK);
      clear.addActionListener(this);
      add(clear);
      
      /*JButton icon =new JButton("");
      icon.setBounds(695, 365, 15, 15);
      icon.setBackground(Color.WHITE);
      icon.setForeground(Color.BLACK);
      add(icon);*/
      
      setSize(800,480);
      setVisible(true);
      setLocation(250,120);
  }
  public void actionPerformed(ActionEvent ae ){
      String dbcard = null;
      String dname = new String();
      int dbpin = 0;
      if(ae.getSource()==clear)
      {
          cardtf.setText("");
          pintf.setText("");
      }
      else if(ae.getSource()==signup)
      {
        setVisible(false);
        new Signup1().setVisible(true);  
      }
    else if(ae.getSource()==signin)

  {
        String cardno = cardtf.getText();
        int  pinno = Integer.parseInt(pintf.getText());
        try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");
      String query = "select *from commontable where cardNo ='"+cardno+"' and  pinNo = '"+pinno+"'";
      PreparedStatement p = c.prepareStatement(query);
      ResultSet rs = p.executeQuery(query);
      if(rs.next()){
          dbcard = rs.getString("cardNo");
          dbpin =rs.getInt("pinNo");

      }
            try{
                String query1 = "select name from commontable where cardNo ='"+cardno+"'";
            PreparedStatement p1 = c.prepareStatement(query1);
            ResultSet rsname = p1.executeQuery(query1);
            if(rsname.next()){
                dbcard = rs.getString("cardNo");
                dname = rs.getString("name");

            }}
            catch(Exception e){System.out.println(e);}



            try{
      if(cardno.equals(dbcard)&& pinno ==  dbpin){


          setVisible(false);
          new Transactions(dbcard).setVisible(true);}

      else{
          JOptionPane.showMessageDialog(null, " In correct Card or Pin number " );
      }

      }
      catch(Exception e){
          System.out.println("Success");
      }
        }

        catch (Exception e){

        }
  }

//         Conn conn =new Conn();
//         String querylogin = "select *from login where dbcardnor='"+cardno+"'and dbpinnor = '"+pinno+"'";
//         try{ ResultSet rs= conn.s.executeQuery(querylogin);
//         if(rs.next()){
//             setVisible(false);
//         new Transactions().setVisible(true);
//        }
//         else{
//         JOptionPane.showMessageDialog(null, " In correct Card or Pin number " );
//         }
//         }
//        catch(Exception e){
//        System.out.println(e);
//        }
//
//      }
  }
    public static void main(String[] args)
    {
     new Login();
    }
}
