
package rudransh.medical.store;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class salesrdt extends JFrame implements ActionListener
{
    JFrame  f;
   
    JLabel l;
    JTextField t;
    JButton b,b1;
     Connection c;
     PreparedStatement ps;
     ResultSet rs;
     
     DefaultTableModel m=new DefaultTableModel();
    JTable tb=new JTable(m);
    JScrollPane sp=new JScrollPane(tb);
    salesrdt()
    {
        f=new JFrame();
        try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//pq.jpg")));
		}
		catch(Exception e)
		{

		}
        l=new JLabel("DATE");
        l.setForeground(Color.white);
        l.setFont(new Font("Times New Roman",Font.BOLD,22));
        t=new JTextField();
        t.setFont(new Font("Times New Roman",Font.BOLD,22));
        b=new JButton("SEARCH");
          b.setFont(new Font("Times New Roman",Font.BOLD,22));
        b1=new JButton("BACK");
          b1.setFont(new Font("Times New Roman",Font.BOLD,22));
          l.setBounds(100,100,150,40);
          t.setBounds(250,100,150,40);
          b.setBounds(500,100,150,40);
          b1.setBounds(1500,100,150,40);
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                LocalDateTime now = LocalDateTime.now();  
               t.setText(dtf.format(now));
               
               sp.setBounds(100,300,1600,900);
        m.addColumn("B ID");
        m.addColumn("Date of Purchase");
        m.addColumn("Customer Name");
         m.addColumn("Doctors Name");
         m.addColumn("Phone No.");
         m.addColumn("Product Name");
         m.addColumn("Product Price");
         m.addColumn("Product Quantity");
         m.addColumn("Total");
        
          tb.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,22));
          f.add(sp);
               
                f.add(b);
                f.add(b1);
                f.add(t);
                f.add(l);
                b1.addActionListener(this);
                b.addActionListener(this);
                f.setSize(1800,1800);
                f.setLayout(null);
                f.setVisible(true);
    }
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()==b)
         {
             int r=0;
        try 
        {
         Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select * from pagal where dop=?");
                 ps.setString(1,t.getText());
                
                 rs=ps.executeQuery();
                 
                 while(rs.next())
                 {
                     m.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
                     tb.setFont(new Font("TImes new Roman",Font.BOLD,20));
                    // tb.setBorder(BorderFactory.createEmptyBorder());
                    tb.setRowHeight(30);
                   
                 }
        } 
        catch (Exception ep) 
        {
            JOptionPane.showMessageDialog(null, "NO DATA FOUND");
        }
         }
         if(e.getSource()==b1)
         {
             new Mdntyp();
             f.setVisible(false);
         }
     }
     
     public static void main(String arg[])
     {
         salesrdt s=new salesrdt();
     }
    
}
