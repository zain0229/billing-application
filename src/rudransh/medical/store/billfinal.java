/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rudransh.medical.store;

import javax.swing.JOptionPane;

public class billfinal {
  
  
    public static void main(String arg[]) throws InterruptedException
    {
        prtn s=new prtn();
        s.setVisible(true);
       
        
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(10);
               s.num.setText(Integer.toString(i)+"%");
               s.bar.setValue(i);
                if (i==100) {
                    s.setVisible(false);
                    new Sellp();
                    JOptionPane.showMessageDialog(null,"PRINTING IN PROGRESS");
                
                }
                
                
            
        } 
    }
    
}

    
    

