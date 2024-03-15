
package atm_p.BankingPlatform;

//this class use to war whenever user leave the fields empty and  some other reasons

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Warning <T extends javax.swing.JComponent>{
    public boolean isWarningVisible = false;
    public void setwarninglabel(JLabel l,String msz){
      l.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
      l.setForeground(new java.awt.Color(255, 102, 102));
      l.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
      l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/icons8-error-16.png"))); // NOI18N
      l.setIconTextGap(10);
      l.setText(msz);
      l.setVisible(true);
    }

    public Warning() {
    }
    
    Warning(T errorBox,boolean beep){
        if(beep) Toolkit.getDefaultToolkit().beep();
        errorBox.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
        
    }
    
     Warning(T errorBox,JLabel mszLabel,String msz,boolean beep){
        if(beep) Toolkit.getDefaultToolkit().beep();
        errorBox.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
        if((!mszLabel.isVisible())&& (!mszLabel.getText().isBlank())){
            mszLabel.setText(msz);
            mszLabel.setVisible(true);
        }
        else{
            setwarninglabel(mszLabel,msz);
        }
     }
     Warning(T errorBox,JLabel errorBoxIcon,JLabel mszLabel,String msz,boolean beep){
        if(beep)Toolkit.getDefaultToolkit().beep();
        errorBoxIcon.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
       errorBox.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
       if((!mszLabel.isVisible())&& (!mszLabel.getText().isBlank())){
            mszLabel.setText(msz);
            mszLabel.setVisible(true);
        }
        else{
            setwarninglabel(mszLabel,msz);
        }
       
     }
    Warning(T arr[],JLabel mszLabel,String msz,boolean beep){
        if(beep)Toolkit.getDefaultToolkit().beep();
        for(int i=0;i<arr.length;i++){
            arr[i].setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
        }
      if((!mszLabel.isVisible())&& (!mszLabel.getText().isBlank())){
            mszLabel.setText(msz);
            mszLabel.setVisible(true);
        }
        else{
            setwarninglabel(mszLabel,msz);
        }
      
    }
    public void normal(T arr[],JLabel mszLabel){
        for(int i=0;i<arr.length;i++){
            arr[i].setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
        }
       mszLabel.setVisible(false);
    }
    public static void warning(JComponent jc,boolean beep){
         if(beep) Toolkit.getDefaultToolkit().beep();
        jc.setBorder(new LineBorder(Color.red));
    }
    public static void removeWarning(JComponent jc,String color){
        if(color.equals("lightBlack")){    jc.setBorder(new LineBorder(new Color(25,31,38)));}
        else{  jc.setBorder(new LineBorder(Color.black));}
    }
//    public static void warningLabel(JLabel label , String msz,boolean beep){
//        if(beep) Toolkit.getDefaultToolkit().beep();
//        label.setText(msz);
//        label.setForeground(Color.red);
//        
//    }
    
    
}
