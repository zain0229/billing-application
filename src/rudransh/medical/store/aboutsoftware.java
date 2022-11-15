/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rudransh.medical.store;

import java.awt.Font;
import java.awt.*;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;



public class aboutsoftware extends JFrame implements ActionListener
{
   
   Label l1;
   TextArea ta;
   Button b;
    aboutsoftware()
    {
       
    l1=new Label("ABOUT SOFTWARE"); 
    b=new Button("BACK");
    b.setForeground(Color.BLACK);
    l1.setBounds(650,50,350,50);  
    b.setBounds(1200,50,150,50);
    b.setFont(new Font("Times New Roman",Font.BOLD,24));
    l1.setFont(new Font("Times New Roman",Font.BOLD,28));
    ta=new TextArea("By using Medical store management system, the orders can be easily tracked and the report acts as a proof.\nThe orders will be taken systematically and will be saved safely in the database rather than manually through paper work.\nIt requires less time and space to save the order details\nThis software helps you to track all products of medical shop moreover it's a medical shop accounting software,\nThis project is used mainly for medical store to maintain the details of medical store such as stock and account.");  
    ta.setBounds(100,200,1300,500);  
  ta.setFont(new Font("Times New Roman",Font.BOLD,20));
    add(l1);
    add (b);
    add(ta);
    b.addActionListener(this);
    setSize(1500,1000);  
    setLayout(null);  
    setVisible(true); 
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            new Mdntyp();
            setVisible(false);
        }
        
    }
    public static void main(String arg[])
    {
        aboutsoftware s=new aboutsoftware();
    }
}

