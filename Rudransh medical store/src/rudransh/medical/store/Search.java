package rudransh.medical.store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;

 public class Search extends JFrame implements ActionListener
{
	JFrame f;
	JTextField t1;
	JButton b1,b2,b3,b4,b5;
	JLabel l1;
        DefaultTableModel m=new DefaultTableModel();
        JTable t=new JTable(m);
        JScrollPane sp=new JScrollPane(t);
      
        
        
        Connection c;
        PreparedStatement ps;
        ResultSet rs;
	Search()
	{
	f=new JFrame();
        try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//ttt.jpg")));
		}
		catch(Exception e)
		{

		}
        sp.setBounds(450,300,1300,400);
        sp.setBackground(Color.red);
      
        f.add(sp);
         t.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,22));
       
        m.addColumn("PRODUCT NAME");
        m.addColumn("COMPANY NAME");
        m.addColumn("PRODUCT CATEGORY");
        m.addColumn("PRODUCT QUAANTITY");
        m.addColumn("PRODUCT PRICE");
        
		
		t1=new JTextField();
                t1.setFont(new Font("Times Roman Italic",Font.BOLD,16));
               // ImageIcon log;
               // log = new ImageIcon("src/images/logout.png");
                b1=new JButton("SEARCH");
                b2=new JButton("INSERT MEDICINE");
                b3= new JButton("UPDATE MEDICINE");
                b4=new JButton("DELETE MEDICINE");
                b5=new JButton("BACK");
		l1=new JLabel("MEDICINE NAME");
		l1.setFont(new Font("Times Roman Italic",Font.BOLD,24));
                
                b1.setBounds(1600,200,150,50);
                b2.setBounds(150,400,250,50);
                b3.setBounds(150,500,250,50);
                b4.setBounds(150,600,250,50);
                b5.setBounds(150,700,250,50);
		t1.setBounds(700,200,800,50);
		l1.setBounds(400,200,200,50);
                 b1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 b2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 b3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 b4.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 b5.setFont(new Font("Times Roman Italic",Font.BOLD,18));
		f.add(t1);
		f.add(b1);
                f.add(b2);
                f.add(b3);
                f.add(b4);
                f.add(b5);
                f.add(l1);
              // f.add(tb1);
              
            
                        
                        
                b2.addActionListener(this);
                b3.addActionListener(this);
                b4.addActionListener(this);
                b1.addActionListener(this);
                b5.addActionListener(this);
                
		
              //  tb1.setBounds(100,1600,1500,1500);
                //tb1.setVisible(true);
		l1.setForeground(Color.white);
		
                
		f.setSize(1800,1800);
		f.setVisible(true);
		f.setLayout(null);
                
	}
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
               
            {
                 String s1= t1.getText();
                int r=0;
        try 
        {
         Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select * from medicine where pname=?");
                 ps.setString(1, s1);
                 rs=ps.executeQuery();
                 
                 while(rs.next())
                 {
                     m.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
                      t.setFont(new Font("TImes new Roman",Font.BOLD,20));
                   
                    t.setRowHeight(30);

                 }
        } 
        catch (Exception ep) 
        {
            JOptionPane.showMessageDialog(null, ep);
        }
            }
            
            
            if(e.getSource()==b2)
            {
                new insert();
                f.setVisible(false);
            }
            if(e.getSource()==b3)
            {
                new update();
                f.setVisible(false);
            }
            if(e.getSource()==b4)
            {
                new delete();
                f.setVisible(false);
               
            }
            if(e.getSource()==b5)
         {
             new Mdntyp();
             f.setVisible(false);
         }
        }
	public static void main(String arg[])
	{
		Search a1=new Search();
	}
}