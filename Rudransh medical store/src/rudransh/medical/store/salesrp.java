
package rudransh.medical.store;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class salesrp  extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l;
    JButton b;
    DefaultTableModel m=new DefaultTableModel();
    JTable t=new JTable(m);
    JScrollPane sp=new JScrollPane(t);
    
    
     Connection c;
     PreparedStatement ps;
     ResultSet rs;
    salesrp()
    {
        f=new JFrame();
        try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//stt.jpg")));
		}
		catch(Exception e)
		{

		}
        l=new JLabel("SALES REPORT");
        l.setFont(new Font("Times New Roman",Font.BOLD, 20));
        l.setBounds(100,50,200,40);
       b=new JButton("BACK");
         b.setFont(new Font("Times New Roman",Font.BOLD, 20));
        sp.setBounds(100,100,1600,900);
        m.addColumn("B ID");
        m.addColumn("Date of Purchase");
        m.addColumn("Customer Name");
         m.addColumn("Doctors Name");
         m.addColumn("Phone No.");
         m.addColumn("Product Name");
         m.addColumn("Product Price");
         m.addColumn("Product Quantity");
         m.addColumn("Total");
         b.setBounds(1500,50,140,40);
          t.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,22));
          f.add(sp);
          f.add(l);
          f.add(b);
          b.addActionListener(this);
          f.setLayout(null);
          f.setVisible(true);
           f.setSize(1800,1800);
        
         int r=0;
        try 
        {
         Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select * from pagal");
                
                 rs=ps.executeQuery();
                 
                 while(rs.next())
                 {
                     m.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
                     t.setFont(new Font("TImes new Roman",Font.BOLD,20));
                     t.setBorder(BorderFactory.createEmptyBorder());
                    t.setRowHeight(30);
                   
                 }
        } 
        catch (Exception ep) 
        {
            JOptionPane.showMessageDialog(null, ep);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            new Mdntyp();
            f.setVisible(false);
        }
    }
    public static void main(String arg[])
    {
        salesrp r= new salesrp();
    }
    
}
