/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rudransh.medical.store;


public class RudranshMedicalStore {
    
    
    

    public static void main(String[] args) {
       
        Splashsc s=new Splashsc();
        s.setVisible(true);
       
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);
               s.num.setText(Integer.toString(i)+"%");
               s.bar.setValue(i);
                if (i==100) 
                {
                    s.setVisible(false);
                    new Loginpge();
                  
                
                }
                
                
            }
        } catch (Exception e) {
        }
    }
    
}
