package rudransh.medical.store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
class Register extends JFrame implements ActionListener
{
	JFrame f;
	JTextField t1,t2,t3;
        JPasswordField t4;
        JButton b1,b2;
	JLabel l1,l2,l3,l4;
        Connection c =null;
        PreparedStatement ps=null;
        ResultSet rs;
	Register()
	{
		f=new JFrame();
		try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//gh.jpg")));
		}
		catch(Exception e)
		{

		}
                t1=new JTextField();
                
                l1=new JLabel("FIRST NAME");
                l1.setForeground(Color.black);
                l2=new JLabel("LAST NAME");
                l2.setForeground(Color.black);
                l3= new JLabel("USER NAME");
                l3.setForeground(Color.black);
                l4=new JLabel("PASSWORD");
                l4.setForeground(Color.black);
       
                
                b1=new JButton("REGISTER");
                 b1.setFont(new Font("Times Roman Italic",Font.BOLD,22));
                b2=new JButton("BACK");
                 b2.setFont(new Font("Times Roman Italic",Font.BOLD,22));
              
                
                t1=new JTextField();
                t1.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                t2=new JTextField();
                t2.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                t3=new JTextField();
                t3.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                t4=new JPasswordField();
                t4.setFont(new Font("Times Roman Italic",Font.BOLD,16));
               
		
                l2.setFont(new Font("Times Roman Italic",Font.BOLD,15));
                l3.setFont(new Font("Times Roman Italic",Font.BOLD,15));
                l4.setFont(new Font("Times Roman Italic",Font.BOLD,15));
                
		f.add(t1);  
		f.add(l1);
                f.add(l2);
                f.add(l3);
                f.add(l4);
               
                f.add(t1);
                f.add(t2);
                f.add(t3);
                f.add(t4);
             
                f.add(b1);
                f.add(b2);
             
                l1.setBounds(600,100,150,50);
                l2.setBounds(600,250,150,50);
                l3.setBounds(600,400,150,50);
                l4.setBounds(600,550,150,50);
                
                l2.setFont(new Font("Times Roman Italic",Font.BOLD,24));
                 l1.setFont(new Font("Times Roman Italic",Font.BOLD,24));
                l3.setFont(new Font("Times Roman Italic",Font.BOLD,24));
                l4.setFont(new Font("Times Roman Italic",Font.BOLD,24));
		t1.setBounds(800,100,250,50);
                t2.setBounds(800,250,250,50);
                t3.setBounds(800,400,250,50);
                t4.setBounds(800,550,250,50);
              
                b1.setBounds(200,800,250,50);
                b2.setBounds(200,900,250,50);
            
                b1.addActionListener(this);
                b2.addActionListener(this);
		

		f.setSize(1800,1800);
		f.setVisible(true);
		f.setLayout(null);
	}
        public void Refresh() 
        {  
        t1.setText("");  
        t2.setText("");  
        t3.setText(""); 
        t4.setText("");
        }
         public void actionPerformed(ActionEvent e)
        {
         String s1=t1.getText();
         String s2=t2.getText();
         String s3=t3.getText();
         String s4=t4.getText();
         
         if(e.getSource()==b1)
        {
       
           if((t1.getText()).equals("") || (t2.getText()).equals("") || (t3.getText()).equals("") || (t4.getText()).equals(""))
        {
           JOptionPane.showMessageDialog(null," SOME FIELDS ARE MISSING !");
        }
           else
        {   
          try
        {
       Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
       ps=c.prepareStatement("insert into users(fname,lname,uname,upass) values(?,?,?,?)");
       ps.setString(1,s1);
       ps.setString(2, s2);
       ps.setString(3, s3);
       ps.setString(4,t4.getText());
       ps.executeUpdate();
       JOptionPane.showMessageDialog(this,"YOU ARE REGISTERED SUCCESSFULLY  ");
       Refresh();
       new Loginpge();
       }
       catch(Exception ep)
       {
          JOptionPane.showMessageDialog(null,ep);
       }
       }
       }
        
         if(e.getSource()==b2)
         {
             new Mdntyp();
             f.setVisible(false);
         }
        }
        public static void main(String arg[])
	{
		Register a1=new Register();
	}
}