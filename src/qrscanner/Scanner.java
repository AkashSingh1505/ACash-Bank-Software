/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qrscanner;

import atm_p.ATM_Platform.Menu;
import atm_p.Main;
import atm_p.pictures.Icon;
import atm_p.sound.Sound;
import com.formdev.flatlaf.FlatDarkLaf;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_highgui;
import java.awt.Color;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import splashscreen.LogoIcon;

/**
 *
 * @author Akash singh
 */
public class Scanner extends javax.swing.JFrame {
     static int camNumber =0;
     static Scanner canvas ;
     static String decodeMsz=null;
     static Thread webcam;
     static opencv_highgui.CvCapture capture;
     static Clip creaditWarn=null,blockedWarn=null;
   
    public Scanner() {
        initComponents();
        
        new LogoIcon().setLogo(this);
        setTitle("QR_Scanner");
        setResizable(false);
        setExtendedState(Scanner.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public  static  void scan(){
        Sound.play("Scanned");
        canvas = new Scanner();
        canvas.setVisible(true);
         startWebcam();
    }
    private static void startWebcam(){
        
          webcam = new Thread(){
            public void run(){
            capture = opencv_highgui.cvCreateCameraCapture(camNumber);
                try{
                    if(!capture.isNull()){
                        msz.setVisible(true);
                        opencv_highgui.cvSetCaptureProperty(capture,opencv_highgui.CV_CAP_PROP_FRAME_WIDTH,imgHolder.getWidth());
                        opencv_highgui.cvSetCaptureProperty(capture,opencv_highgui.CV_CAP_PROP_FRAME_HEIGHT, imgHolder.getHeight());
                        opencv_core.IplImage grabbedImage = opencv_highgui.cvQueryFrame(capture);
                        while(canvas.isVisible() && (grabbedImage=opencv_highgui.cvQueryFrame(capture))!=null){
                            canvas.show(grabbedImage.getBufferedImage());
                            try{
                                    String Msz=DecodeQR.decode(grabbedImage.getBufferedImage());
                                    if(!Msz.isBlank()){
                                        Sound.play("Scanned");
                                        if(Cust_Ident.searchCust(Msz)){
                                            if(Cust_Ident.card=="DC"){
                                                if(creaditWarn!=null){creaditWarn.stop();}
                                                if(blockedWarn!=null){blockedWarn.stop();}
                                                if(!Cust_Ident.isblocked){
                                                    opencv_highgui.cvReleaseCapture(capture);
                                                    new Menu(Cust_Ident.CID,Cust_Ident.PIN,Cust_Ident.con).setVisible(true);
                                                    canvas.dispose();
                                                }
                                                else{
                                                    if(blockedWarn!=null){blockedWarn.stop();}
                                                    if(creaditWarn!=null){creaditWarn.stop();}
                                                    blockedWarn=Sound.play("cardBlockedSpeech");
                                                    msz.setText("Blocked !");
                                                    msz.setForeground(Color.white);
                                                    Icon.setIcon(msz, "icons8-box-important-22.png");
                                                }
                                            }
                                            else{
                                                Cust_Ident.card=null;
                                                if(creaditWarn!=null){creaditWarn.stop();}
                                                if(blockedWarn!=null){blockedWarn.stop();}
                                                creaditWarn=Sound.play("CreaditWarnSpeech");
                                                msz.setText("Sorry !");
                                                msz.setForeground(Color.white);
                                                Icon.setIcon(msz, "icons8-box-important-22.png");
                                            }
                                        }
                                        else{
                                            Icon.setIcon(msz, "icons8-error-16.png");
                                            msz.setText("Invalid Card!");
                                            msz.setForeground(Color.red);
                                        }
                                    }
                            }catch(Exception e){
                                     msz.setText("Show your QR Code!");
                                     msz.setForeground(Color.white);
                                     Icon.setIcon(msz, "icons8-qr-code-20.png");
                            }
                        }
                    }
                }catch(Exception e){
                    camNumber++;
                    System.out.println(camNumber);
                    if(camNumber<5){
                        startWebcam();
                    }
                    msz.setVisible(true);
                    Icon.setIcon(msz, "icons8-box-important-22.png");
                    msz.setText("No Camera Detected !");
                    
                }
            }
        };
         webcam.start();
    }
    private void show(java.awt.image.BufferedImage img){
        java.awt.Image scaledimg = img.getScaledInstance(imgHolder.getWidth(), imgHolder.getHeight(),java.awt.Image.SCALE_SMOOTH);
        imgHolder.setIcon(new javax.swing.ImageIcon(scaledimg));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        imgHolder = new javax.swing.JLabel();
        msz = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        imgHolder.setBackground(new java.awt.Color(28, 28, 28));
        imgHolder.setOpaque(true);

        msz.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        msz.setForeground(new java.awt.Color(255, 255, 255));
        msz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/icons8-qr-code-20.png"))); // NOI18N
        msz.setText("Show your QR Code!");
        msz.setIconTextGap(10);
        msz.setVisible(false);

        jLayeredPane1.setLayer(imgHolder, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(msz, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(imgHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(msz, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(imgHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(402, Short.MAX_VALUE)
                    .addComponent(msz, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void doTask()throws Exception{
        Thread.currentThread().wait();
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
      
    }//GEN-LAST:event_formWindowClosing

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
      opencv_highgui.cvReleaseCapture(capture);
    }//GEN-LAST:event_formWindowIconified

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
       startWebcam();
    }//GEN-LAST:event_formWindowDeiconified

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        FlatDarkLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Scanner().setVisible(true);
//            }
//        });
           scan();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel imgHolder;
    private javax.swing.JLayeredPane jLayeredPane1;
    private static javax.swing.JLabel msz;
    // End of variables declaration//GEN-END:variables
}
