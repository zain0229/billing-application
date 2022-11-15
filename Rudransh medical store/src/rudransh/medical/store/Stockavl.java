/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rudransh.medical.store;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


public class Stockavl extends JFrame implements ActionListener
{
    JFrame f;
    JButton b;
   
   // JPanel p;
    JLabel l;
    
    DefaultTableModel m=new DefaultTableModel();
    JTable t=new JTable(m);
    JScrollPane sp=new JScrollPane(t);
 //   JSeparator  j=new JSeparator(0);
    
     Connection c;
     PreparedStatement ps;
     ResultSet rs;
    Stockavl()
    {
        //p=new JPanel();
        f=new JFrame();
         try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//stock.jpg")));
		}
		catch(Exception e)
		{

		}
       //p.setBackground(Color.BLUE);
        l=new JLabel("STOCK AVAILABLE");
        l.setFont(new Font("Times Roman Italic",Font.BOLD,24));
        l.setForeground(Color.white);
        t.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,24));
       // j.setOrientation(SwingConstants.VERTICAL);
       
        sp.setBounds(40,300,1700,400);
        l.setBounds(100,100,300,40);
        f.add(l);
       // f.add(j);
        f.add(sp);
        m.addColumn("PRODUCT NAME");
        m.addColumn("QUANTITY");
        b=new JButton("BACK");
        b.setBounds(1600,100,150,60);
        f.add(b);
       b.addActionListener(this);
        b.setFont(new Font("Times Roman Italic",Font.BOLD,24));
        f.setSize(1800,1800);
        f.setLayout(null);
       // f.add(p);
       f.show();
     
        
         int r=0;
        try 
        {
         Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select * from medicine");
                
                 rs=ps.executeQuery();
                 
                 while(rs.next())
                 {
                     m.insertRow(r++, new Object[]{rs.getString(1),rs.getString(4)});
                     t.setFont(new Font("TImes new Roman",Font.BOLD,20));
                     t.setBorder(BorderFactory.createEmptyBorder());
                   t.setRowHeight(30);
                    // sp.setBorder(new CompoundBorder(outsideBorder, insideBorder);
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
        Stockavl l=new Stockavl();
    }
     
        
}
