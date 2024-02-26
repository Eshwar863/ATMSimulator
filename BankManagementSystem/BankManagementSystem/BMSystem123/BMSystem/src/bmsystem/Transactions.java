
package bmsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class Transactions extends JFrame implements ActionListener {

    JLabel l1, Dispname;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String dbcard;

    Transactions(String cardno) {
        this.dbcard = cardno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Design.png"));
        Image i2 = i1.getImage().getScaledInstance(755, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(100, 15, 755, 820);
        add(l2);


        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 20));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");
            String query = "select name from commontable where cardNo ='" + cardno + "'";
            PreparedStatement p = c.prepareStatement(query);
            ResultSet rs = p.executeQuery(query);
            if (rs.next()) {

                String dname = rs.getString("name");
                String name = dname;

                Dispname = new JLabel("Account Holder : " + name);
                Dispname.setForeground(Color.WHITE);
                Dispname.setFont(new Font("System", Font.BOLD, 20));
                Dispname.setBounds(142, 130, 250, 40);
                Dispname.setBackground(Color.WHITE);
                l2.add(Dispname);
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setLayout(null);
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(120, 0);
        setVisible(true);


        l1.setBounds(142, 195, 700, 40);
        l1.setBackground(Color.WHITE);
        l2.add(l1);


        b1.setBounds(135, 240, 150, 32);
        b1.setBackground(Color.WHITE);
        l2.add(b1);

        b2.setBounds(300, 302, 150, 32);
        b2.setBackground(Color.WHITE);
        l2.add(b2);

        b3.setBounds(135, 302, 150, 32);
        b3.setBackground(Color.WHITE);
        l2.add(b3);

        b4.setBounds(300, 240, 150, 32);
        b4.setBackground(Color.WHITE);
        l2.add(b4);

        b5.setBounds(135, 360, 150, 32);
        b5.setBackground(Color.WHITE);
        l2.add(b5);

        b6.setBounds(302, 360, 150, 32);
        b6.setBackground(Color.WHITE);
        l2.add(b6);

        b7.setBounds(220, 420, 150, 35);
        b7.setBackground(Color.WHITE);
        l2.add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


    }

    public void actionPerformed(ActionEvent ae) {
        String cardno = dbcard;
        if (ae.getSource() == b7) {
            JOptionPane.showMessageDialog(null, " Thank You");
            setVisible(false);
        }
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(cardno).setVisible(true);
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            new CashWithdrawal(dbcard).setVisible(true);
        }
        if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(dbcard).setVisible(true);
        }
        if (ae.getSource() == b4) {
            new Ministatement(cardno).setVisible(true);
        }
        if (ae.getSource() == b5) {
            JOptionPane.showMessageDialog(null, "Do you want to change your pin");
            setVisible(false);
            new PinChange(cardno).setVisible(true);
        }
        if (ae.getSource() == b6) {
            setVisible(false);
            new BalanceEnq(dbcard).setVisible(true);
        }

    }
//        double bamount = 0;
//        try{   Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sricharan123*");
//            String query = "INSERT INTO balance (cardNo,amount) VALUES (?,?)";
//            PreparedStatement p = c.prepareStatement(query);
//            p.setString(1, cardno);
//            p.setDouble(2, bamount);
//
//            int i = p.executeUpdate();
//            if (i > 0)
//                System.out.println("Success");
//            else
//                System.out.println("Invalid");
//        } catch (Exception e) {
//            e.printStackTrace();
//


        public static void main(String[] args){
        new Transactions("");
    }
}