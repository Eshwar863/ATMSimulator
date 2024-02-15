
package bmsystem;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JLabel pd ,religion,category,income,eq,occupation,panno,aadharno,senoircitizen,existingacc;
    JButton next;
    JTextField categorytf,incometf,occupationtf,aadharnotf,senoircitizentf,existingacctf,pannotf;
    JComboBox occupationcb,edcb,incomecb,categorycb,religioncb;
    JRadioButton syesrb,snorb,yesrb,norb;
    ButtonGroup Senoircitizenbg,exstbg;
    
    String dbformno, dbreligion;
    Signup2(String dbformno){
        this.dbformno = dbformno;
    setSize(650,800);
    setVisible(true);
    setLocation(250,10);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setTitle("SIGNUP pg 2");
        
     pd = new JLabel("Page 2 : Aditional Details");
    pd.setBounds(100, 30  , 400, 120);
    pd.setFont(new Font("Raleway",Font.BOLD,23));
    add(pd);
    
     religion = new JLabel("Religion:");
    religion.setBounds(40, 95  , 150, 120);
    religion.setFont(new Font("Raleway",Font.BOLD,18));
    add(religion);
    
    String arrreligion[]={"Hindu","Muslim","Cristian","Sikh","Other"};
    religioncb = new JComboBox(arrreligion); 
    religioncb.setBounds(250, 145,200,23);
    add(religioncb);
    
     category = new JLabel("Category:");
    category.setBounds(40, 130  , 150, 120);
    category.setFont(new Font("Raleway",Font.BOLD,18));
    add(category);
    
     String arrcategory[]={"General","OBC","ST","SC","Other"};
     categorycb = new JComboBox(arrcategory);
    categorycb.setBounds(250,180,200,23);
    add(categorycb);
    
     income = new JLabel("Income:");
    income.setBounds(40, 165  , 150, 120);
    income.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(income);
    
    String arrincome[]={"Null","1,00,000","5,00,000","8,00,000","10,00,000","10,00,000&Above"};
     incomecb = new JComboBox(arrincome);
    incomecb.setBounds(250,215,200,23);
    add(incomecb);
     eq = new JLabel("Edu Qualification:");
    eq.setBounds(40, 200, 230, 120);
    eq.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(eq);
    
    String  arred[] ={"Graduate","PostGraduate","UnderGraduate","Student","Other"};
    edcb = new JComboBox(arred);
    edcb.setBounds(250,250,200,23);
    add(edcb);
   /** male = new JRadioButton("Male");
    male.setBounds(200,250,90,23);
    add(male);
    
     female= new JRadioButton("Female");
    female.setBounds(300,250,100,23);
    add(female);
    
    ButtonGroup gendergroup = new ButtonGroup();
    gendergroup.add(male);
    gendergroup.add(female);**/
    
   occupation = new JLabel("Occupation:");
    occupation.setBounds(40,235,150,120);
    occupation.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(occupation);
    
    String  arrocupation[] ={"Salaried","Self Employed","Bussiness","Student","Other"};
   occupationcb = new JComboBox(arrocupation);
    occupationcb.setBounds(250,285,200,23);
    add(occupationcb);
    
     panno = new JLabel("PAN Number:");
    panno.setBounds(40,270,150,120);
    panno.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(panno);
    
    /** marriedrb = new JRadioButton("Married");
    marriedrb.setBounds(200,320,90,23);
    add(marriedrb);
    
   unmarriedrb = new JRadioButton("Unmarried");
    unmarriedrb.setBounds(300,320,100,23);
    add(unmarriedrb);
    
    ButtonGroup maritalbg = new ButtonGroup();
    maritalbg.add(marriedrb);
    maritalbg.add(unmarriedrb);**/
    
    pannotf = new JTextField();
    pannotf.setBounds(250,320,200,23);
    add(pannotf);
    
    
    aadharno= new JLabel("Aadhar Number:");
    aadharno.setBounds(40, 305,150, 120);
    aadharno.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(aadharno);
    
     aadharnotf = new JTextField();
    aadharnotf.setBounds(250,355,200,23);
    add(aadharnotf);
    
    senoircitizen= new JLabel("Senoir Citizen:");
    senoircitizen.setBounds(40,340,150,120);
    senoircitizen.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(senoircitizen);
    
     syesrb = new JRadioButton("Yes");
    syesrb.setBounds(250,390,90,23);
    add(syesrb);
    
    snorb = new JRadioButton("No");
    snorb.setBounds(350,390,100,23);
    add(snorb);
    
     Senoircitizenbg = new ButtonGroup();
    Senoircitizenbg.add(syesrb);
    Senoircitizenbg.add(snorb);
    
     existingacc = new JLabel("Existing Account:");
    existingacc.setBounds(40,375,185,120);
    existingacc.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(existingacc);
    
     yesrb = new JRadioButton("Yes");
    yesrb.setBounds(250,425,90,23);
    add(yesrb);
    
    norb = new JRadioButton("No");
    norb.setBounds(350,425,100,23);
    add(norb);
    
     exstbg = new ButtonGroup();
    exstbg.add(yesrb);
    exstbg.add(norb);
    /** pincode = new JLabel("Pin code:");
    pincode.setBounds(40,410,150,120);
    pincode.setFont(new Font("Raleway",Font.BOLD,18 ));
    add(pincode);
    
     pincodetf = new JTextField();
    pincodetf.setBounds(200,460,200,23);
    add(pincodetf);**/
    
    
     next= new JButton("NEXT");
    next.setBounds(150,505,100,28);
    next.setBackground(Color.WHITE);
    next.setForeground(Color.BLACK);
    next.addActionListener(this);
    add(next);}
    
    public void actionPerformed(ActionEvent ae){
   /**String dbformno dbaadharno dbpanno dbSenoircitizenbg dbexstbg dboccupation dbeduqualification dbreligion dbcategory dbincome**/
   
    String dbformno1 =dbformno;
    String dbreligion = (String) religioncb.getSelectedItem(); 
    String dbcategory = (String)categorycb.getSelectedItem();
    String dbincome  = (String)incomecb.getSelectedItem();
    String dbeduqualification = (String)edcb.getSelectedItem();
    String dboccupation = (String)occupationcb.getSelectedItem();
    String dbaadharno = aadharnotf.getText();
    String dbpanno = pannotf.getText();                         
        
    String dbSenoircitizenbg = null;
        if(syesrb.isSelected())
        {
            dbSenoircitizenbg= "Yes";
        }
        else if(snorb.isSelected())
        {
            dbSenoircitizenbg="No";
        }    
        
    String dbexstbg = null;
        if(yesrb.isSelected())
        {
            dbexstbg= "Yes";
        }
        else if(norb.isSelected())
        {
            dbexstbg="No";
        }
    
       
   try{if(dbaadharno.equals("")){
     
     JOptionPane.showMessageDialog(null, "aadhar IS REQ ");
     
     }else if(dbpanno.equals("")){
     
     JOptionPane.showMessageDialog(null, "PAN IS REQ ");
     }
   else{ Conn c =new Conn();
             String query = "insert into signuptwo values('"+dbformno1+"','"+dbreligion+"','"+dbcategory+"','"+dbincome+"','"+dbeduqualification+"','"+dboccupation+"','"+dbpanno+"','"+dbaadharno+"','"+dbSenoircitizenbg+"','"+dbexstbg+"')";
             c.s.executeUpdate(query);  
     
     
     
     } 
   
   
   //Conn c1 =new Conn();
     //   String query = "insert into signuptwo values('"+dbformno+"','"+dbreligion+"','"+dbcategory+"','"+dbincome+"','"+dbeduqualification+"','"+dboccupation+"','"+dbpanno+"','"+dbaadharno+"','"+dbSenoircitizenbg+"','"+dbexstbg+"')";
       //      c1.s.executeUpdate(query);
   
           setVisible(false);
             new Signupthree(dbformno1).setVisible(true); 
        }
     /**String dbformno dbaadharno dbpanno dbSenoircitizenbg dbexstbg dboccupation dbeduqualification dbreligion dbcategory dbincome**/
     catch(Exception e){
     System.out.println(e);
     
    }
   
    }
    
public static void main(String[] args)
    {
     new Signup2("");
     
    }}
