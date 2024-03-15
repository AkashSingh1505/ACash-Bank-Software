/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package splashscreen;

import atm_p.DB_Con;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ALogoDialog extends javax.swing.JDialog {

    /**
     * Creates new form ALogoDialog
     */
    public ALogoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(Color.white);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        Bar = new splashscreen.ProgressBarCustom();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/AppLogo.jpg"))); // NOI18N

        Bar.setBackground(new java.awt.Color(255, 255, 255));
        Bar.setForeground(new java.awt.Color(0, 0, 0));

        status.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(204, 204, 204));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 private  boolean isFirstLoad(){
        try{
            if(!Files.exists(Paths.get("C:\\ProgramData\\ACash\\DO_NOT_TOUCH_ME.txt"))){
                new File("C:\\ProgramData\\ACash").mkdir();
                FileOutputStream create = new FileOutputStream("C:\\ProgramData\\ACash\\DO_NOT_TOUCH_ME.txt");
                return true;
            }
        }catch(Exception e){
            status.setText(e.getMessage());
        }
        return false;
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher(){
            public boolean dispatchKeyEvent(KeyEvent e){
                if(e.getKeyCode()==18 || e.getKeyCode()==115){
                    return true;
                }
                return false;
                
            }
        });
        
        
        boolean firstload=isFirstLoad();
        new Thread(new Runnable(){
            public void run(){
                try{
                    
                    if(firstload){
                        doTask("First Load...",10);  
                        System.out.println("i am in");
                        doTask("It will take some extra time than usual !",20);
                        doTask("It will take some extra time than usual !",30);
                        Files.copy(Paths.get("C:\\Program Files (x86)\\ACash\\ACash_Bank"), Paths.get("C:\\ProgramData\\ACash\\ACash_Bank"),StandardCopyOption.REPLACE_EXISTING);
                        doTask("Loading Logs...",40);
                        AFile.copy("C:\\Program Files (x86)\\ACash\\ACash_Bank\\log", "C:\\ProgramData\\ACash\\ACash_Bank\\log",status);
                        doTask("Loading Seg()...",50);
                        AFile.copy("C:\\Program Files (x86)\\ACash\\ACash_Bank\\seg0", "C:\\ProgramData\\ACash\\ACash_Bank\\seg0",status);
                        doTask("Loading temps...",60);
                        AFile.copy("C:\\Program Files (x86)\\ACash\\ACash_Bank\\tmp", "C:\\ProgramData\\ACash\\ACash_Bank\\tmp",status);
                        doTask("Loading Db.lck...",70);
                        Files.copy(Paths.get("C:\\Program Files (x86)\\ACash\\ACash_Bank\\db.lck"), Paths.get("C:\\ProgramData\\ACash\\ACash_Bank\\db.lck"),StandardCopyOption.REPLACE_EXISTING);
                        doTask("Loading Text...",80);
                        Files.copy(Paths.get("C:\\Program Files (x86)\\ACash\\ACash_Bank\\README_DO_NOT_TOUCH_FILES.txt"), Paths.get("C:\\ProgramData\\ACash\\ACash_Bank\\README_DO_NOT_TOUCH_FILES.txt"),StandardCopyOption.REPLACE_EXISTING);
                        doTask("Loading Service_Properties...",90);
                        Files.copy(Paths.get("C:\\Program Files (x86)\\ACash\\ACash_Bank\\service.properties"), Paths.get("C:\\ProgramData\\ACash\\ACash_Bank\\service.properties"),StandardCopyOption.REPLACE_EXISTING);
                        doTask("Connacting database...",100);
                        doTask("Done"+100+"%",100);
                        dispose();
                    }
                    else{
                        doTask("Connacting database...",10);
                        doTask("Connacting database..."+10+"%",20);
                        doTask("Connacting database..."+20+"%",30);
                        DB_Con.getConnection();

                        doTask("Connacting database..."+30+"%",60);
                        doTask("Connacting database..."+60+"%",90);
                        doTask("Connacting database..."+90+"%",100);
                        doTask("Done"+100+"%",100);
                        dispose();
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unable to Connect with database","Error",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/atm_p/pictures/icons8-error.png")));
                System.exit(0);
                }
            }
        }).start();
    }//GEN-LAST:event_formWindowOpened
    
    private void doTask(String task,int progress)throws Exception{
       
        
        status.setText(task);
        Thread.sleep(1000);
        Bar.setValue(progress);
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ALogoDialog dialog = new ALogoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private splashscreen.ProgressBarCustom Bar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}