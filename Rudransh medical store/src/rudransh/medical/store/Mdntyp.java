package rudransh.medical.store;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Mdntyp extends JFrame implements ActionListener
{
	JFrame f=new JFrame();
        JLabel l1;
	JMenuBar mbar;
	JMenu m,p,q,r,s;
	JMenuItem m1,m3,m4,m5,m6,m7,m8;
	
	Mdntyp()
	{
try
{
	f.setContentPane(new JLabel(new ImageIcon("src/images//rat.jpg")));
}
catch(Exception e)
{

}
                                     l1=new JLabel("Register a new Admin");  
		m=new JMenu("MEDICINE");
		p=new JMenu("SALES RECORD");
		q=new JMenu("ABOUT");
                r=new JMenu("SALES");
                s=new JMenu("STOCK");
          
		
		mbar=new JMenuBar();
		f.setJMenuBar(mbar);
                
		mbar.add(m);
		mbar.add(p);
		mbar.add(q);
		mbar.add(r);
                mbar.add(s);
                
                
		m.setFont(new Font("Times New Roman",Font.BOLD,20));
                m.setIcon(new ImageIcon("src/images//srs.jpg"));
		p.setFont(new Font("Times New Roman",Font.BOLD,20));
                p.setIcon(new ImageIcon("src/images//ou.jpg"));
		q.setFont(new Font("Times New Roman",Font.BOLD,20));
                q.setIcon(new ImageIcon("src/images//ts.png"));
                r.setFont(new Font("Times New Roman",Font.BOLD,20));
                r.setIcon(new ImageIcon("src/images//srs.jpg"));
                s.setFont(new Font("Times New Roman",Font.BOLD,20));
                s.setIcon(new ImageIcon("src/images//srs.jpg"));
                
                m1=new JMenuItem("Medicine");	
                m1.setIcon(new ImageIcon("src/images//rss.jpg"));
                m1.setFont(new Font("Times New Roman",Font.BOLD,20));
                m.add(m1);
                m.addSeparator();
                
		
                
		
		m4=new JMenuItem("Sales Report");
                m4.setFont(new Font("Times New Roman",Font.BOLD,20));
                m4.setIcon(new ImageIcon("src/images//iso.png"));
                p.add(m4);
		p.addSeparator();
                
		m5=new JMenuItem("Search By Date");
                m5.setFont(new Font("Times New Roman",Font.BOLD,20));
                m5.setIcon(new ImageIcon("src/images//os.png"));
                p.add(m5);
		
		m6=new JMenuItem("About Software");
                 m6.setFont(new Font("Times New Roman",Font.BOLD,20));
                 m6.setIcon(new ImageIcon("src/images//abt.png"));
                q.add(m6);
                
                m7=new JMenuItem("Sell");
                m7.setFont(new Font("Times New Roman",Font.BOLD,20));
                m7.setIcon(new ImageIcon("src/images//sell.jfif"));
                r.add(m7);
                
                m8=new JMenuItem("Stock Available");
                m8.setFont(new Font("Times New Roman",Font.BOLD,20));
                 m8.setIcon(new ImageIcon("src/images//stocks.jpg"));
                s.add(m8);
		f.add(l1);
		 l1.setBounds(1400,20,500,60);
                 l1.setForeground(Color.BLACK);
                  l1.setFont(new Font("Times Roman Italic",Font.BOLD,30));
		m1.addActionListener(this);
		//m2.addActionListener(this);
                m4.addActionListener(this);
                m5.addActionListener(this);
                m6.addActionListener(this);
                m7.addActionListener(this);
                m8.addActionListener(this);
                //r.addActionListener(this);
                 l1.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent  e)
{
    if(e.getSource()==l1)
    {
      new Register();
      f.setVisible(false);
    }
}
        });
		f.setSize(1800,1800);
		f.setVisible(true);
		f.setLayout(null);
	}
        
public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==m1)
		{
			new Search();
                        f.setVisible(false);
		}
		
                if(e.getSource()==m8)
                {
                    
                    new Stockavl();
                    f.setVisible(false);
                }
              
                if (e.getSource()==m7) 
                {
                new Sellp();
                f.setVisible(false);
            }
                if(e.getSource()==m4)
                {
                    new salesrp();
                    f.setVisible(false);
                }
                if(e.getSource()==m5)
                {
                    new salesrdt();
                    f.setVisible(false);
                }
                if (e.getSource()==m6) 
                {
               
             new aboutsoftware();
               f.setVisible(false);
            }
	
	}
public static void main(String arg[])
	{
		Mdntyp m=new Mdntyp();
                                    //aboutsoftwr s=new aboutsoftwr();
		
	}
}