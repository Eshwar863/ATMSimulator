package bmsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ministatement extends JFrame {
String cardno,date,type;
double amount;

    Ministatement(String cardno) {
        this.cardno = cardno;
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(380, 30);
        setVisible(true);
        setLayout(null);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");
            String query = "SELECT * FROM transactions";
            PreparedStatement p = c.prepareStatement(query);
            ResultSet rs = p.executeQuery(query);

            while (rs.next()) {
                String cardNo1 = rs.getString("cardNo");
                String date = rs.getString("date");
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");
                JLabel l4 = new JLabel(date+type+amount);
                l4.setFont(new Font("System", Font.BOLD, 12));
                l4.setBounds(50, 400, 400, 100);
                add(l4);
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }
        JLabel l2 = new JLabel("NAGARJUNA BANK");
        l2.setBounds(125, 30, 150, 30);
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(l2);

        JLabel l1 = new JLabel("Card No " + cardno);
        l1.setFont(new Font("System", Font.BOLD, 12));
        l1.setBounds(50, 80, 400, 100);
        add(l1);
        JLabel l3 = new JLabel("Transactions");
        l3.setFont(new Font("System", Font.BOLD, 12));
        l3.setBounds(50, 120, 400, 100);
        add(l3);



//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sricharan123*");
//            String query = "select date from transactions where cardNo ='"+cardno+"'";
//            PreparedStatement p = c.prepareStatement(query);
//            ResultSet rs= p.executeQuery(query);
//           if(rs.next()){
//               date = rs.getString("date");
//               type = rs.getString("type");
//               amount = rs.getDouble("amount");
//
//            }
//
//        }catch (Exception e){System.out.println(e);}
//

    }
    public static void main(String[] args) {
     new Ministatement("");
    }
}


