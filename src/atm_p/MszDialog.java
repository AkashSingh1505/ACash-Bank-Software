/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_p;

import java.awt.Dialog;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MszDialog {
    public static void showDialog(String type,String msz){
        if(type.equals("info")){
        JOptionPane.showMessageDialog(null, msz+"!","Error",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(MszDialog.class.getResource("/atm_p/pictures/icons8-error.png")));
        }
        else if(type.equals("warn")){
        JOptionPane.showMessageDialog(null, msz+"!","Error",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(MszDialog.class.getResource("/atm_p/pictures/icons8-error-16.png")));
        }
    }
}
