/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_p.pictures;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Icon{
    public static  void setIcon(JLabel Label,String name){
        Label.setIcon(new ImageIcon(Icon.class.getResource("/atm_p/pictures/"+name)));
    }
}
