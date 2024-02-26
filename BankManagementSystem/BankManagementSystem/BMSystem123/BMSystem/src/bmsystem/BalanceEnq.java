package bmsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class BalanceEnq extends JFrame implements ActionListener {
    JLabel l1;
    JButton b2;
    String dbcard;
    String amount;

    BalanceEnq(String dbcard) {
        this.dbcard = dbcard;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Design.png"));
        Image i2 = i1.getImage().getScaledInstance(755, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(100, 15, 755, 820);
        add(l2);
        b2 = new JButton("BACK");
        b2.setBounds(210, 303, 150, 32);
        l2.add(b2);
        b2.addActionListener(this);
        setLayout(null);
        setSize(980, 1080);
        setLocation(120, 0);
        setUndecorated(true);
        setVisible(true);

            DAO dao = new DAO();
            double amount = dao.getAmount(dbcard);

        l1 = new JLabel("AVAILABLE BALANCE :" + amount);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 21));
        l1.setBounds(155, 205, 700, 40);
        l2.add(l1);
    }

    public void actionPerformed(ActionEvent e) {
        String cardno = dbcard;

        if (e.getSource() == b2) {
            setVisible(false);
            new Transactions(cardno).setVisible(true);
        }
    }

        public static void main (String[]args){
            new BalanceEnq("");
        }

    }
