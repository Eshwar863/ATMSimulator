package bmsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class CashWithdrawal extends JFrame implements ActionListener {
    String cardno;
    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    CashWithdrawal(String cardno){
        this.cardno=cardno;
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Design.png"));
    Image i2 = i1.getImage().getScaledInstance(755, 820, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l2 = new JLabel(i3);
        l2.setBounds(100, 15, 755 , 820);
    add(l2);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("Withdraw");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(130,205,700,40);
        l2.add(l1);

        t1.setBounds(138,260,320,25);
        l2.add(t1);

        b1.setBounds(210,305,150,32);
        l2.add(b1);

        b2.setBounds(210,358,150,32);
        l2.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);
        setSize(980,1080);
        setLocation(120,0);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e) {
        String cardnodeposit = cardno;
        String type ="Withdrawal";
        java.util.Date date =new Date();
        if(e.getSource()==b2){
            setVisible(false);
            new Transactions(cardno).setVisible(true);
        }if(e.getSource()==b1) {
            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
            } else {
                try {
                    DAO dao = new DAO();
                    double dbamount = dao.getAmount(cardno);
                    double withdrawMoney = Double.parseDouble(t1.getText());
                    if(dbamount<withdrawMoney){
                        JOptionPane.showMessageDialog(null, " Insufficient Balance ");
                    }else {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");

                    dao.updateBalance(cardno,dbamount-withdrawMoney);

                    String query = "INSERT INTO Transactions (cardNo, date, type, amount) VALUES (?, ?, ?, ?)";
                    PreparedStatement p = c.prepareStatement(query);
                    p.setString(1, cardnodeposit);
                    p.setString(2, String.valueOf(date));
                    p.setString(3, type);
                    p.setDouble(4, withdrawMoney);


                    int i = p.executeUpdate();
                    if (i > 0)
                        System.out.println("Success in");
                    else {
                        System.out.println("Invalid");
                    }

                    JOptionPane.showMessageDialog(null, withdrawMoney + "  Withdrawn Successfully ");

                    }
                    setVisible(false);
                    new Transactions(cardno).setVisible(true);
                } catch (Exception s) {
                    System.out.print(s);
                }

//                double bamount = Double.parseDouble(null);
//                bamount = bamount - amount;
//                try{   Class.forName("com.mysql.cj.jdbc.Driver");
//                    Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sricharan123*");
//                    String query = "update balance set amount = bamount where cardNo=" + cardnodeposit + ";";
//                    PreparedStatement p = c.prepareStatement(query);
//                    p.setDouble(1, bamount);
//
//                    int i = p.executeUpdate();
//                    if (i > 0)
//                        System.out.println("Success");
//                    else
//                        System.out.println("Invalid");
//                } catch (Exception ae) {
//                    ae.printStackTrace();
//                }
            }


        }
    }

    public static void main(String[] args){
        new CashWithdrawal("");
    }}




