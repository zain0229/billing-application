
package rudransh.medical.store;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Medavail extends JFrame  implements ActionListener
{
   JFrame f;
   JButton b;
    DefaultTableModel m=new DefaultTableModel();
    JTable t=new JTable(m);
    JScrollPane sp=new JScrollPane(t);
    Connection c;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Medavail()
    {
        f=new JFrame("MEDICINE AVAILABLE");
        b=new JButton("BACK");
        f.setLayout(null);
        f.setSize(1800,1800);
        t.setOpaque(false);
        t.setBackground(Color.pink);
        sp.setBounds(40,70,1700,1700);
        f.add(sp);
        f.add(b);
        b.setBounds(1300,20,180,40);
        b.setFont(new Font("Times Roman Italic",Font.BOLD,24));
        m.addColumn("PRODUCT NAME");
        m.addColumn("PRODUCT QUANTITY");
       //    m.set
       
       t.getTableHeader().setBackground(Color.white);
       sp.setBackground(new Color(255,255,208));
       sp.getViewport().setBackground(Color.gray);
       
        f.setVisible(true);
        b.addActionListener(this);
        int r=0;
        try 
        {
         Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select pname,pquat from medicine"); 
                 rs=ps.executeQuery();
                 
                 while(rs.next())
                 {
                     m.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2)});
                     
                 }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void actionPerformed(ActionEvent g)
    {
        if(g.getSource()==b)
         {
             new Mdntyp();
             f.setVisible(false);
         }
    }
    public static void main(String args[])
    {
        Medavail t=new Medavail();
    }
    
}
