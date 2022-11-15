/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rudransh.medical.store;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import javax.swing.*;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  




class Sellp extends JFrame implements ActionListener
{
        static int id;
        //static String a;
        JFrame f;
        JButton b1,b2,b3,b4,b5,b6;
        JTextField t1,t2,t3,t4,t5,t6,t7,t8;//t6 is for bill id
       JLabel l1,l6,l2,l3,l4,l5,l7,l8,l9,l10,l11,l12;// l7 is for bill id
       JComboBox cb;
       DefaultTableModel m;
       DefaultTableModel m1;
       
       JTable t;
        JTable j;
       JScrollPane sp;
       JScrollPane sp1;
       java.sql.Connection c;
        PreparedStatement ps;
        ResultSet rs;
        
      
        
       
        
        
        Sellp()
        {
             f=new JFrame();
             m= new DefaultTableModel();
             m1= new DefaultTableModel();
             t=new JTable(m);
             t.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,22));
          
             j=new JTable(m1);
                j.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,20));
             sp=new JScrollPane(t);
             sp1=new JScrollPane(j);
	
               try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//billi.jpg")));
		}
		catch(Exception e)
		{

		}
                m1.addColumn("B ID");
                m1.addColumn("PRODUCT NAME");
                m1.addColumn("PRODUCT QUAANTITY");
                m1.addColumn("PRODUCT PRICE");
                sp1.setBackground(Color.red);
                sp1.setFont(new Font("Times Roman Italic",Font.BOLD,24));
      
             
                b1=new JButton("ADD");
                b2=new JButton("REMOVE");
                b3=new JButton("SAVE&PRINT");
                b4=new JButton("NEW");
               b5=new JButton("TOTAL SUM");
               b6=new JButton("BACK");
               
                
                
                
                
                t1=new JTextField();//cname
                t2=new JTextField();//DATE 
                t3=new JTextField();//phno
                t4=new JTextField();//docname
                t5=new JTextField();//total
                t6=new JTextField();//b id
                t7=new JTextField();//pqut
                t8=new JTextField();//pprice 
                
             
                
                l1=new JLabel("CUSTOMER NAME");
                l2=new JLabel("DATE");
                l3=new JLabel("PHN NO.");
                l4=new JLabel("DOCTOR NAME");
                l5=new JLabel("PRODUCT NAME");
                l6=new JLabel("TOTAL");
                l7=new JLabel("BILL ID");
                l8=new JLabel("RUDRANSH MEDICAL STORE");
                l8.setForeground(Color.white);
                l9=new JLabel("PRODUCT QUANTITY");
                l10=new JLabel("PRODUCT PRICE");
                l12=new JLabel();
                l11=new JLabel();
                
                
        //t.setOpaque(false);
        //t.setBackground(Color.pink);
        sp.setBounds(0,375,1800,2);
        f.add(sp);
        
        //m.addColumn("SNO.");
        //m.addColumn("PRODUCTS");
        //m.addColumn("PRODUCT QUANTITY");
        
     
                //m.addColumn("PRODUCT PRICE");
       
       
       //t.getTableHeader().setBackground(Color.white);
       //sp.setBackground(new Color(255,255,208));
       //sp.getViewport().setBackground(Color.gray);
                //String c[]={"A","b"};
               DefaultComboBoxModel m=new DefaultComboBoxModel();
               cb=new JComboBox(m);
                
                cb.setBounds(380,440,200,40);//pname
                f.add(cb);
                
                f.add(l1);
                f.add(l2);
                f.add(l3);
                f.add(l4);
                f.add(l5);
                f.add(l6);
                f.add(l7);
                f.add(l8);
                f.add(l9);
                f.add(l10);
                f.add(l12);
                
                f.add(b1);
                f.add(b2);
                f.add(b3);
                f.add(b4);
                f.add(t1);
                f.add(t2);
                f.add(t3);
                f.add(t4);
                f.add(t5);
                f.add(b5);
                f.add(b6);
                f.add(t6);
                f.add(t7);
                f.add(sp1);
                f.add(t8);
                f.add(l11);
                
                
                
                sp1.setBounds(650,420,1100,400);
                l8.setBounds(700,10,450,100);
                l8.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l1.setBounds(100,180,280,100);//cname
                l1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l2.setBounds(1100,100,280,100);//date
                l2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l3.setBounds(100,260,280,100);//phno
                l3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l4.setBounds(1100,180,280,100);//dname
                l4.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l5.setBounds(100,420,280,100);//pnAME
                l5.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                  l6.setBounds(1250,830,280,100);//total
                          l6.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                          l12.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                         
                
                //b5.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                l7.setBounds(100,100,280,100);//bill id
                l7.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l9.setBounds(100,620,280,100);//pqut
                l9.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l10.setBounds(100,520,280,100);//pprice
                l10.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                
                t1.setBounds(380,120,250,40);//billid
                t2.setBounds(380,200,250,40);//cname
                t3.setBounds(1380,120,250,40);//date
                t4.setBounds(380,280,250,40);//phnno
                t5.setBounds(1380,200,250,40);//dname
                t6.setBounds(1340,850,250,40);//total
                t7.setBounds(380,640,250,40);//pqut
                t8.setBounds(380,540,250,40);//pprice
                
            
                
                b1.setBounds(150,750,150,40);
                b3.setBounds(800,850,150,40);//nxt
                l12.setBounds(480,850,150,40);
                b4.setBounds(150,850,150,40);//NEW
                b2.setBounds(480,750,150,40);//remove
                b6.setBounds(480,850,140,40);
              
                // b5.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                 b1.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                b2.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                b3.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                b4.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                 b5.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                 b6.setFont(new Font("Times Roman Italic",Font.BOLD,16));
                //b3.setBounds(150,950,150,40);
                b5.setBounds(1000,850,150,40);
                 t1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t4.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t5.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t6.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t7.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                t8.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                cb.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                
                f.setVisible(true);
                f.setLayout(null);
                f.setSize(1800,1800);
                
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
                b4.addActionListener(this);
                b6.addActionListener(this);
                //.addActionListener(this);
                cb.addActionListener(this);
                b5.addActionListener(this);
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                LocalDateTime now = LocalDateTime.now();  
               // System.out.println(dtf.format(now));
                t3.setText(dtf.format(now));
                
                
                  try
        {
             Class.forName("com.mysql.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root",""); 
                Statement st=c.createStatement();
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
                  try
                  {
           java.sql.Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
            PreparedStatement ps=c.prepareStatement("select max(bid) from pagal");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
               
                id=rs.getInt(1);
                id++;
            }
            t1.setText(Integer.toString(id));
                
            }
            catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null, ex);
        }
        } 
        public void  Refresh()
        {
        
        t7.setText("");
        t8.setText("");
        cb.setSelectedIndex(0);
        }
        public void add()
        {
          
              //  int value=Integer.parseInt(t7.getText())*Integer.parseInt(t8.getText());
                //t6.setText(String.valueOf(value));
              // String bid=null; 
               
               
               
               
              int num1=Integer.parseInt(t7.getText());
              int num2=Integer.parseInt(t8.getText());
              int to=num1*num2;
              t6.setText(String.valueOf(to));
                
                
            
                  
        }
        public void pquatsub()
        {
            int num1=Integer.parseInt(t7.getText());
            //int num2=Integer.parseInt(t8.getText());
            
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select pquat from medicine where pname='"+cb.getSelectedItem().toString()+"'");
                ResultSet rs=ps.executeQuery();
                l12.setText(rs.getString("pquat"));
                int num2=Integer.parseInt(l12.getText());
                
                if(num2!=0)
                {
                   int q=num2-num1;
                   
                }
                
            } 
            catch (Exception e) 
            {
            }
            
        }
        
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b2)
         {
             new Mdntyp();
             f.setVisible(false);
         }
            if(e.getSource()==b5)
            {
                 try {
                     Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select Sum(total) from pagal where bid='"+t1.getText()+"'");
                ResultSet rs=ps.executeQuery();
                 while(rs.next())
                 {
                     t6.setText(Integer.toString(rs.getInt(1)));
                 }
                 JOptionPane.showMessageDialog(this,"TOTAL AMOUT IS='"+t6.getText()+"'");
                
            }
                 
                 catch(Exception ep)
                 {
                     JOptionPane.showMessageDialog(this, ep);
                 }
            }
             if (e.getSource()==b3)//next
            {
                 
                try {
                     Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select Sum(total) from pagal where bid='"+t1.getText()+"'");
                ResultSet rs=ps.executeQuery();
                 while(rs.next())
                 {
                     t6.setText(Integer.toString(rs.getInt(1)));
                 }
                 JOptionPane.showMessageDialog(this,"TOTAL AMOUT TO BE PAID IS='"+t6.getText()+"'");
                 int response=JOptionPane.showConfirmDialog(this," DO YOU WANT TO PRINT BILL  ? "," CONFIRMATION ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
                
                new billfinal();
                f.setVisible(false);
               try {   
                     Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                   ps=c.prepareStatement(" insert into pagal (bid,dop,cname,dname,phno,pname,pprice,pqut,total) values(?,?,?,?,?,?,?,?,?)");
             
                 ps.setString(1,t1.getText());
                  ps.setString(2,t3.getText());
                 ps.setString(3,t2.getText());
                 ps.setString(4,t5.getText());
                 ps.setString(5,t4.getText());
                  ps.setString(6,cb.getSelectedItem().toString());
                  ps.setString(7,t8.getText());
                 ps.setString(8,t7.getText());
                 ps.setString(9,t6.getText());
                 
                ps.executeUpdate();
                f.setVisible(false);
                new Sellp();
                JOptionPane.showMessageDialog(null,"PRINTING IN PROGRESS");
                }
                catch(Exception epp)
                {
                    JOptionPane.showMessageDialog(this, epp);
                }  
                
            }
            else
            {
              try {
                     Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement(" insert into pagal (bid,dop,cname,dname,phno,pname,pprice,pqut,total) values(?,?,?,?,?,?,?,?,?)");
             
                 ps.setString(1,t1.getText());
                  ps.setString(2,t3.getText());
                 ps.setString(3,t2.getText());
                 ps.setString(4,t5.getText());
                 ps.setString(5,t4.getText());
                  ps.setString(6,cb.getSelectedItem().toString());
                  ps.setString(7,t8.getText());
                 ps.setString(8,t7.getText());
                 ps.setString(9,t6.getText());
                 
                ps.executeUpdate();
                f.setVisible(false);
                new Sellp();
                }
                catch(Exception epp)
                {
                    JOptionPane.showMessageDialog(this, epp);
                }  
            }
            
            
                } 
                catch (Exception exp)
                {
                    JOptionPane.showMessageDialog(null, exp);
                }
                
            }
             
             
             
             
             
           if (e.getSource()==cb)//combo box
           {
                  try{
           java.sql.Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
            PreparedStatement ps=c.prepareStatement("select pprice from medicine where pname=? ");
             ps.setString(1,cb.getSelectedItem().toString());
            ResultSet rs=ps.executeQuery();
            
           while(rs.next())
            {
                t8.setText(Integer.toString(rs.getInt(1)));
        
            }
                 
            }
           
        catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null, ex);
        }
        }
            
           
           
            
           
            if (e.getSource()==b2)//remove
            {
              
                int row = j.getSelectedRow(); 
            if (row >= 0) 
            {
                 
                DefaultTableModel m1= (DefaultTableModel)j.getModel();

                String s = m1.getValueAt(row, 0).toString();

                m1.removeRow(row);

                try 
                {
                    
                    Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                    ps = c.prepareStatement("delete from pagal where bid='"+t1.getText()+"' and pname='"+cb.getSelectedItem().toString()+"' ");
                    //ps.setString(1,t1.getText());
                    //ps.setString(2,cb.getSelectedItem().toString());
                   
                    ps.executeUpdate();
                     JOptionPane.showMessageDialog(null,"deleted Successfully");
                    
                }
                catch (Exception w) 
                {
                    JOptionPane.showMessageDialog(this, w);
                }           
            }
                
            }
            
            
            
            
            if (e.getSource()==b1)//add
            {
                
                
                if((t1.getText()).equals("") || (t2.getText()).equals("") || (t3.getText()).equals("") || (t4.getText()).equals("") ||  (t5.getText()).equals(" ") || (t6.getText()).equals(" ") || (cb.getSelectedItem()).equals("SELECT MEDICINE"))
               
                {
                    JOptionPane.showMessageDialog(this," SOME FIELDS ARE MISSING ");
                    
                }
                else
                {
                   add();
                    try
                {
                 Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 
             ps=c.prepareStatement(" insert into pagal (bid,dop,cname,dname,phno,pname,pprice,pqut,total) values(?,?,?,?,?,?,?,?,?)");
             
                 ps.setString(1,t1.getText());
                  ps.setString(2,t3.getText());
                 ps.setString(3,t2.getText());
                 ps.setString(4,t5.getText());
                 ps.setString(5,t4.getText());
                  ps.setString(6,cb.getSelectedItem().toString());
                  ps.setString(7,t8.getText());
                 ps.setString(8,t7.getText());
                 ps.setString(9,t6.getText());
                 
                
                 ps.executeUpdate();
                 
                 Refresh();
                 
                 
                 
                }
                catch(Exception ep)
                {
                    JOptionPane.showMessageDialog(null, ep);
                }
                    
                    
                   
                    
                    int r=0;
                    try {
                        
                       
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select * from pagal where bid='"+t1.getText()+"'");
               
                 // ps.setString(1,t1.getText());
                 rs=ps.executeQuery();
                 m1.setRowCount(0);
                 while(rs.next())
                 {
                     m1.insertRow(r++, new Object[]{rs.getString(1),rs.getString(6),rs.getString(8),rs.getString(7)});
                     j.setFont(new Font("TImes new Roman",Font.BOLD,20));
                 }
                 
                    }
                    catch (Exception eX) 
                    {
                        JOptionPane.showMessageDialog(this, eX);
                    }
            }
            
           
            
            
            }
         if (e.getSource()==b4)//refresh
            {
               f.setVisible(false);
               new Sellp();
            }
         
         if(e.getSource()==b6)
         {
             new Mdntyp();
             f.setVisible(false);
         }
        }   
            
        
        
        public static void main(String arg[])
        {
            Sellp sp=new Sellp();
            
           
        }

   
          
}

