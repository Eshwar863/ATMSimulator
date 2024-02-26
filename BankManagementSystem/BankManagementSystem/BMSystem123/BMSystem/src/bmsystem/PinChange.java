package bmsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class PinChange extends JFrame implements ActionListener {
    JTextField t1,t3,t2;
    JButton b1,b2;
    JLabel l1,l3,l4,l5;
    String cardno;

    PinChange(String cardno){
        this.cardno=cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Design.png"));
        Image i2 = i1.getImage().getScaledInstance(755, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(100, 15, 755 , 820);
        add(l2);
        l1 = new JLabel("Pin Change :");
        l1.setForeground(Color.WHITE);
        l4 = new JLabel("Re-enter PIN");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("System", Font.BOLD, 16));

        l5= new JLabel("Current Pin");
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("System", Font.BOLD, 16));

        l3 = new JLabel("New PIN");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 16));


        l1.setFont(new Font("System", Font.BOLD, 25));
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 22));
        b2 = new JButton("CONFORM");
        setLayout(null);
        l1.setBounds(110,205,700,40);
        l2.add(l1);
        l5.setBounds(110,250,120,40);
        l2.add(l5);
        l3.setBounds(110,300,120,40);
        l2.add(l3);
        l4.setBounds(110,350,120,40);
        l2.add(l4);
        t1.setBounds(260,260,120,25);
        l2.add(t1);
        t2.setBounds(260,310,120,25);
        l2.add(t2);
        t3.setBounds(260,360,120,25);
        l2.add(t3);
        b2.setBounds(260,415,120,32);
        l2.add(b2);

        b1 = new JButton("BACK");
        b1.setBounds(260,465,120,32);

        l2.add(b1);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);
        setSize(960,1080);
        setUndecorated(true);
        setLocation(120,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        String cardno1 = cardno;
        String pinno = t1.getText();
        String newpinno = t2.getText();
        String repinno = t3.getText();
        if(newpinno.equals(repinno)){

        }else{
            JOptionPane.showMessageDialog(null, "New PIN Does not Matches with re-entered PIN");
        }
        if (e.getSource() == b2) {
            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Current PIN");
            }
            else if (t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter New PIN");
            }
           else if (t3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
            }
        else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");
                String query = "UPDATE commontable SET  pinNo = ? WHERE  cardNo ='"+cardno+"'";
                PreparedStatement p = c.prepareStatement(query);
                p.setString(1, newpinno);
                int i = p.executeUpdate();
                if (i > 0)
                    System.out.println("Success");
                else
                    System.out.println("Invalid");
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully" );
                setVisible(false);
                new Transactions(cardno).setVisible(true);
                } catch (Exception s) {
                    System.out.print(s);
                }
            }

            }
        if (e.getSource() == b1) {
            setVisible(false);
            new Transactions(cardno).setVisible(true);
        }}

        public static void main (String[]args){
            new PinChange("");
        }
    }
