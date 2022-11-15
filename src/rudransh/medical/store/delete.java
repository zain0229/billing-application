package rudransh.medical.store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

class delete extends JFrame implements ActionListener
{
	JFrame f;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
        Connection c;
        PreparedStatement ps;
        ResultSet rs;
	delete()
	{
		f=new JFrame();
		try
		{
			f.setContentPane(new JLabel(new ImageIcon("src/images//mn.jpg")));
		}
		catch(Exception e)
		{

		}
		t1=new JTextField();
		l1=new JLabel("PRODUCT NAME");
                l2=new JLabel("COMPANY NAME");
                l3= new JLabel("PRODUCT CATEGORY");
		l4=new JLabel("PRODUCT QUANTITY");
                l5=new JLabel("PRODUCT PRICE");
               
                l6=new JLabel();
                l7=new JLabel();
                l8=new JLabel();
                l9=new JLabel();
                l10=new JLabel();
                l11=new JLabel();
                l12=new JLabel();
                l13=new JLabel();
                l14=new JLabel();
                b1=new JButton("lOGOUT");
                b2=new JButton("BACK");
                b3=new JButton("DELETE");
                b4=new JButton("SEARCH");
                b1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                b2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                b3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                b4.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                
                t1=new JTextField();
                t2=new JTextField();
                t3=new JTextField();
                t4=new JTextField();
                t5=new JTextField();
                 t1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                  t2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                   t3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                    t4.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                     t5.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                 l1.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l2.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l3.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l4.setFont(new Font("Times Roman Italic",Font.BOLD,18));
                l5.setFont(new Font("Times Roman Italic",Font.BOLD,18));
               l6=new JLabel(new ImageIcon("src/images//rss.jpg"));
               l7=new JLabel(new ImageIcon("src/images//ou.jpg"));
               l8=new JLabel(new ImageIcon("src/images//cat.jpg"));
               l9=new JLabel(new ImageIcon("src/images//qu.png"));
               l10=new JLabel(new ImageIcon("src/images//pr.png"));
               l11=new JLabel(new ImageIcon("src/images//logo.jpg"));
               l12=new JLabel(new ImageIcon("src/images//back.png"));
               l13=new JLabel(new ImageIcon("src/images//dele.jpg"));
               l14=new JLabel(new ImageIcon("src/images//os.png"));
		f.add(t1);
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
                f.add(l11);
                f.add(l12);
                f.add(l13);
                f.add(l14);
                f.add(t1);
                f.add(t2);
                f.add(t3);
                f.add(t4);
                f.add(t5);
                f.add(b1);
                f.add(b2);
                f.add(b3);
                f.add(b4);
		l1.setBounds(600,100,300,50);
                l2.setBounds(600,250,300,50);
                l3.setBounds(600,400,300,50);
                l4.setBounds(600,550,300,50);
		l5.setBounds(600,700,300,50);
                l6.setBounds(480,100,150,50);
                l7.setBounds(480,250,150,50);
                l8.setBounds(480,400,150,50);
                l9.setBounds(480,550,150,50);
                l10.setBounds(480,700,150,50);
                l11.setBounds(50,800,150,50);
                l12.setBounds(50,900,150,50);
                l13.setBounds(1350,900,150,50);
                l14.setBounds(1350,800,150,50);
		t1.setBounds(800,100,250,50);
                t2.setBounds(800,250,250,50);
                t3.setBounds(800,400,250,50);
                t4.setBounds(800,550,250,50);
                t5.setBounds(800,700,250,50);
                b1.setBounds(200,800,250,50);
                b2.setBounds(200,900,250,50);
                b3.setBounds(1500,900,200,50);
                b4.setBounds(1500,800,200,50);
                b1.addActionListener(this);
                b2.addActionListener(this);
                b4.addActionListener(this);
                b3.addActionListener(this);
                

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
        t5.setText("");
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
            if(e.getSource()==b3)
            {
               String s1=t1.getText(); 
           int response1=JOptionPane.showConfirmDialog(this," DO YOU WANT TO DELETE ? "," CONFIRMATION ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response1==JOptionPane.YES_OPTION)
            {
                try
                {
                  
                 Class.forName("com.mysql.jdbc.Driver");
                 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("Delete from medicine where pname=?");
               ps.setString(1, s1);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULLY");
                Refresh();
                int response=JOptionPane.showConfirmDialog(this," DO YOU WANT TO DELETE MORE  ? "," CONFIRMATION ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
                
                JOptionPane.showMessageDialog(this," FILL THE MEDICINE NAME ");
                
            }
                
                }
                catch(ClassNotFoundException | SQLException ep)
                {
                    JOptionPane.showMessageDialog(this, ep);
                }
                
                
            }
            else
            {
                Refresh();
            }
           
                 
                
            }
             if(e.getSource()==b4)
            {
                 String s1=t1.getText();
                 if((t1.getText()).equals(""))
        {
           JOptionPane.showMessageDialog(null," PLEASE PROVIDE THE MEDICINE NAME !");
           
        }
                 else
                 {
                 try
                {
                 Class.forName("com.mysql.jdbc.Driver");
                 c=  DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_str","root","");
                 ps=c.prepareStatement("select * from medicine where pname=?");
                 ps.setString(1,s1);
                rs=ps.executeQuery();
                if(rs.next())
                {
                    t1.setText(rs.getString("pname"));
                    t2.setText(rs.getString("cname"));
                    t3.setText(rs.getString("pcat"));
                    t4.setText(rs.getString("pquat"));
                    t5.setText(rs.getString("pprice"));
                }
                else
                {
                    JOptionPane.showMessageDialog(this," NO MEDICINE FOUND ");
                    Refresh();
                }
                }
                catch(Exception ep)
                {
                    JOptionPane.showMessageDialog(this, ep);
                }
            }}
           
                
        }
	public static void main(String arg[])
	{
		delete a1=new delete();
}
}