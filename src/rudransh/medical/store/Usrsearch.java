

package rudransh.medical.store;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAHIL SALGOTRA
 */
public class Usrsearch extends JFrame implements ActionListener
{
    JFrame f;
        JButton b1,b2,b3;
        JTextField t1;
       JLabel l1,l2,l3,l4,l5;
       Connection c;
        PreparedStatement ps;
        ResultSet rs;
          DefaultTableModel m=new DefaultTableModel();
        JTable t=new JTable(m);
        JScrollPane sp=new JScrollPane(t);
      
        Usrsearch()
        {
            
        
        
       

	
	f=new JFrame();
        try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//kl.jpg")));
		}
		catch(Exception e)
		{

		}
        sp.setBounds(450,300,1300,400);
      
      
        f.add(sp);
         t.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,22));
       
        m.addColumn("CUSTOMER NAME");
        m.addColumn("DATE");
        m.addColumn("PRODUCT NAME");
        m.addColumn("PRODUCT QUANTITY");
        m.addColumn("PRODUCT PRICE");
        
		
		t1=new JTextField();
                t1.setFont(new Font("Times Roman Italic",Font.BOLD,16));
               // ImageIcon log;
               // log = new ImageIcon("src/images/logout.png");
                b1=new JButton("SEARCH");
                 b2=new JButton("BACK");
                 b3=new JButton("RESET");
                
		l1=new JLabel("CUSTOMER NAME");
		l1.setFont(new Font("Times Roman Italic",Font.BOLD,24));
                
                b1.setBounds(1600,200,150,50);
               b2.setBounds(100,200,150,50);
               b3.setBounds(100,300,150,50);
		t1.setBounds(700,200,800,50);
		l1.setBounds(400,200,500,50);
                 b1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 b2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 b3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                
                f.add(t1);
                f.add(b1);
               
                f.add(l1);
             f.add(b2);
              f.add(b3);
            
                        
                        
               b3.addActionListener(this);
                b1.addActionListener(this);
                b2.addActionListener(this);
		l1.setForeground(Color.white);
		f.setSize(1800,1800);
		f.setVisible(true);
		f.setLayout(null);
        }      
        public void  Refresh()
        {
        
        t1.setText("");
        m.setRowCount(0);
       
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
                 ps=c.prepareStatement("select * from pagal where cname=?");
                 ps.setString(1, s1);
                 rs=ps.executeQuery();
                 
                 while(rs.next())
                 {
                     m.insertRow(r++, new Object[]{rs.getString(3),rs.getString(2),rs.getString(6),rs.getString(8),rs.getString(7)});
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
                new Loginpge();
                f.setVisible(false);
            }
            
            if(e.getSource()==b3)
            {
                Refresh();
            }
        }
       
        public static void main(String arg[])
	{
		Usrsearch u=new Usrsearch();
	}
}
