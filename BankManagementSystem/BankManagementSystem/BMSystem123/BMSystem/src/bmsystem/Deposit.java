package bmsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin,dbcard;

    Deposit(String dbcard){
        this.dbcard= dbcard;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Design.png"));
        Image i2 = i1.getImage().getScaledInstance(755, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(100, 15, 755 , 820);
        add(l2);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(142,205,700,40);
        l2.add(l1);

        t1.setBounds(138,260,320,25);
        l2.add(t1);

        b1.setBounds(210,305,150,32);
        l2.add(b1);

        b2.setBounds(210,358,150,32);
        l2.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,1080);
        setUndecorated(true);
        setLocation(120,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String cardnodeposit = dbcard;
        String type ="Deposit";

        java.util.Date date =new Date();

        if (ae.getSource() == b2) {
            setVisible(false);
            new Transactions(dbcard).setVisible(true);
        }

        if(ae.getSource()==b1){

            try{
                DAO dao = new DAO();
                double currentAmount = dao.getAmount(dbcard);
                double amount = Double.parseDouble(t1.getText());
                dao.updateBalance(cardnodeposit, amount + currentAmount);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");
                String query = "INSERT INTO Transactions (cardNo, date, type, amount) VALUES (?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(query);
                p.setString(1, cardnodeposit);
                p.setString(2, String.valueOf(date));
                p.setString(3, type);
                p.setDouble(4, amount);


                int i = p.executeUpdate();
                if (i > 0)
                    System.out.println("Success");
                else
                    System.out.println("Invalid");


                JOptionPane.showMessageDialog(null, amount +"  Deposited Successfully ");
                setVisible(false);
                new Transactions(dbcard).setVisible(true);
        }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid double value");
            }
            catch(Exception e){
                System.out.print(e);
            }
        }

//     try{
//         String t = t1.getText();
//         double amount1 = Double.parseDouble(t);
//         double bamount =0;
//         bamount = bamount + amount1;
//         Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sricharan123*");
//        String query = "update balance set amount = bamount where cardNo=" + cardnodeposit + ";";
//        PreparedStatement p = c.prepareStatement(query);
//        p.setDouble(1, bamount);
//
//            int i = p.executeUpdate();
//            if (i > 0)
//                System.out.println("Success");
//            else
//                System.out.println("Invalid");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
