
package splashscreen;

import java.awt.Image;
import java.awt.Toolkit;

public class LogoIcon {
    java.util.List<java.awt.Image> images = new java.util.ArrayList<java.awt.Image>();
    javax.swing.ImageIcon logo16 = new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/TaskbarLogo/LogoIcon16.png"));
    javax.swing.ImageIcon logo32 = new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/TaskbarLogo/LogoIcon32.png"));
    javax.swing.ImageIcon logo40 = new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/TaskbarLogo/LogoIcon40.png"));
    javax.swing.ImageIcon logo50 = new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/TaskbarLogo/LogoIcon50.png"));
    public  void setLogo(javax.swing.JFrame window){
        images.add(logo16.getImage());
//        images.add(logo20.getImage());
        images.add(logo32.getImage());
//        images.add(logo35.getImage());
//        images.add(logo45.getImage());
        window.setIconImages(images);
    }
}
