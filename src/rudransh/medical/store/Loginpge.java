  package rudransh.medical.store;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import rudransh.medical.store.Mdntyp;
class Loginpge extends JFrame implements ActionListener
{
        JFrame f;
        JButton b2;
        JTextField t1;
        JPasswordField t2;
       JLabel l1,l2,l3,l4,l5;
       Connection c;
        PreparedStatement ps;
        ResultSet rs;
        
	Loginpge()
{
	f=new JFrame();
      
	try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//fpg.jpg")));
		}
	catch(Exception e)
		{
			
		}
	b2=new JButton("LOGIN");
	//b1=new JButton("REGISTER");
	l1=new JLabel("USERNAME");
	l1.setForeground(Color.black);
	l2=new JLabel("PASSWORD");
	l2.setForeground(Color.black);
        l5=new JLabel("Login as a user");
	l5.setForeground(Color.black);
        l5.setFont(new Font("Times Roman Italic",Font.BOLD,24));
        l5.setBounds(1360,650,200,60);
	//b1.setBounds(1350,650,200,60);
	t1=new JTextField();
        t2=new JPasswordField();
       	t2.setBounds(1500,400,140,60);
        f.add(t2);
	f.setSize(1800,1800);
	f.add(b2);
         b2.setFont(new Font("Times Roman Italic",Font.BOLD,22));
	b2.setBounds(1350,550,200,60);
	f.add(l1);
	//f.add(b1);
      //  b1.setFont(new Font("Times Roman Italic",Font.BOLD,22));
	l1.setBounds(1300,200,180,90);
                    
                  l1.setFont(new Font("Times Roman Italic",Font.BOLD,24));
                  l3=new JLabel(new ImageIcon("src/images//srs.png"));
                  l3.setBounds(1200,200,80,80);
                  f.add(l2);
	l2.setBounds(1300,400,140,90);
                  l2.setFont(new Font("Times Roman Italic",Font.BOLD,24));
                  l4=new JLabel(new ImageIcon("src/images//rsr.jpg"));
                  l4.setBounds(1200,400,80,80);
                  f.add(l3);
                  f.add(l4);
	f.add(t1);
        f.add(l5);
          t1.setFont(new Font("Times Roman Italic",Font.BOLD,16));
        t2.setFont(new Font("Times Roman Italic",Font.BOLD,16));
        t2.setEchoChar('*');
	t1.setBounds(1500,200,140,60);
	b2.addActionListener(this);
        l5.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent  e)
{
    if(e.getSource()==l5)
    {
      new Usrsearch();
      f.setVisible(false);
    }
}
        });
       // b1.addActionListener(this);
	f.setLayout(null);
        f.setVisible(true);
}

public void actionPerformed(ActionEvent p)
{
  
      /* if(p.getSource()==b1)
        {
            int response=JOptionPane.showConfirmDialog(this," DO YOU WANT TO REGISTER ? "," CONFIRMATION ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
                new Register();
                JOptionPane.showMessageDialog(this," FILL THE REQUIRED DETAILS IN THE FIELDS");
                
                
            }
          
            
        
        }*/
        if(p.getSource()==b2)
        {
            String s1=t1.getText();
            String s2 = t2.getText();
       if((t1.getText()).equals("") || (t2.getText()).equals("") )
        {
           JOptionPane.showMessageDialog(null," SOME FIELDS ARE MISSING !");
        }
       else
       {
          try
                {
                 Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 
             ps=c.prepareStatement("select count(*) from users where uname=? and upass=?");
                 ps.setString(1,t1.getText());
                 ps.setString(2,t2.getText());
                
                rs= ps.executeQuery(); 
                rs.next();
                int cnt=rs.getInt(1);
                if(cnt==1)
                {
                    f.setVisible(false);
                      new  Mdntyp();
                      JOptionPane.showMessageDialog(this,"YOU ARE AUNTHICATED");
                      
                }
                               
                else
                {
                    JOptionPane.showMessageDialog(this," YOU ARE NOT A VALID USER ");
                }
                 
             }
             catch(Exception ep)
             {
                 JOptionPane.showMessageDialog(this,ep );
             }  
       }
               
            
        }
        
        
    }

        

	public static void main(String arg[])
	{
		Loginpge fr=new Loginpge();
	}	
}

