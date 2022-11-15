package rudransh.medical.store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Choice.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class update extends JFrame implements ActionListener
{
	JFrame f;
	JTextField t2,t3;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
                    JComboBox cb;
                    
                    java.sql.Connection c;
        PreparedStatement ps;
        ResultSet rs;
        Statement st;
        
        
	update()
	{
		f=new JFrame();
		try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//logpg.jpg")));
		}
		catch(Exception e)
		{

		}
		cb=new JComboBox();
		l1=new JLabel("PRODUCT NAME");
                l2=new JLabel("NEW PRICE");
                l3=new JLabel("NEW QUANYTITY");
                b1=new JButton("lOGOUT");
                b2=new JButton("BACK");
                b3=new JButton("UPDATE");
                l4=new JLabel();
                l5=new JLabel();
                l6=new JLabel();
                l7=new JLabel();
                l8=new JLabel();
                l9=new JLabel();
                
                
                
                t2=new JTextField();
                
                t3=new JTextField();
               
                l4=new JLabel(new ImageIcon("src/images//rss.jpg"));
                l5=new JLabel(new ImageIcon("src/images//pr.png"));
                l6=new JLabel(new ImageIcon("src/images//qu.png"));
                l7=new JLabel(new ImageIcon("src/images//logo.jpg"));
                l8=new JLabel(new ImageIcon("src/images//back.png"));
                l9=new JLabel(new ImageIcon("src/images//up.jpg"));
               
               
                l1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                b1.setFont(new Font("Times Roman Italic",Font.BOLD,22));
                b2.setFont(new Font("Times Roman Italic",Font.BOLD,22));
                b3.setFont(new Font("Times Roman Italic",Font.BOLD,22));
                t2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 cb.setFont(new Font("Times Roman Italic",Font.BOLD,18));
           
                f.add(l1);
                f.add(l3);
                f.add(cb);
                f.add(t2);
                f.add(t3);
                f.add(l2);
                f.add(b1);
                f.add(b2);
                f.add(b3);
                
                f.add(l4);
                f.add(l5);
                f.add(l6);
                f.add(l7);
                f.add(l8);
                f.add(l9);
              
                l1.setBounds(600,100,300,50);
                l2.setBounds(600,250,300,50);
                l3.setBounds(600,400,300,50);
                
                cb.setBounds(800,110,250,50);
                t2.setBounds(800,250,250,50);
                t3.setBounds(800,400,250,50);
                
                b1.setBounds(200,600,250,50);
                b2.setBounds(200,700,250,50);
                b3.setBounds(1200,250,250,50);
                
                l4.setBounds(450,100,150,50);
                l5.setBounds(450,250,150,50);
                l6.setBounds(450,400,150,50);
                l7.setBounds(50,600,150,50);
                l8.setBounds(50,700,150,50);
                l9.setBounds(1450,250,150,50);
                
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);              
                cb.addActionListener(this);
		//l1.setForeground(Color.black);

		f.setSize(1800,1800);
		f.setVisible(true);
		f.setLayout(null);
                           try
        {
             Class.forName("com.mysql.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root",""); 
                st=c.createStatement();
                String s="select pname from medicine";
                rs=st.executeQuery(s);
                cb.addItem("SELECT MEDICINE");
                while(rs.next())
                {
                    
                    cb.addItem(rs.getString("pname"));
                }
        }
        catch(Exception f)
        {
            
        }
	}
        public void  Refresh()
        {
        
        t2.setText("");
        t3.setText("");
        cb.setSelectedIndex(0);
        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                new Loginpge();
                f.setVisible(false);
            }
            if(e.getSource()==b2)
            {
                new Search();
               f.setVisible(false);
            }
            
            if(e.getSource()==cb)
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
            ps=c.prepareStatement("select pprice,pquat from medicine where pname=? ");
             ps.setString(1,cb.getSelectedItem().toString());
        
            ResultSet rs=ps.executeQuery();
            
           while(rs.next())
            {
               t2.setText(Integer.toString(rs.getInt(1)));
                t3.setText(Integer.toString(rs.getInt(2)));
            }
                 
            }
           
        catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null, ex);
        }
            }
            
            if(e.getSource()==b3)
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
           ps=c.prepareStatement("update medicine set pprice='"+t2.getText()+"',pquat='"+t3.getText()+"' where pname='"+cb.getSelectedItem().toString()+"' ");
          ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Price and Quantity Updated Successfully");
        Refresh();
           
                 
            }
           
        catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null, ex);
        }
                
            }
            
             
        }
	public static void main(String arg[])
	{
		update a1=new update();
	}
}