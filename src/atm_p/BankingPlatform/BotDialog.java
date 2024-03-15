/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package atm_p.BankingPlatform;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import atm_p.DB_Con;
import atm_p.sound.Sound;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 * @author user
 */

public class BotDialog extends javax.swing.JDialog {
    String Error="";
    static  Connection con;
    static Statement stmt;
    static PreparedStatement pstmt,DbCard,CrCard,DQrImage,CQrImage;
    String PreviousId="";
    String Id="";
    ArrayList<Integer> success;
    String customerId;
    String adminId;

    accountOpaningForm openedForm;
    UserProfileData userProfileData;
    File file;
   
    public BotDialog() {
        initComponents();
        getContentPane().setBackground(new Color(25,31,38));
    }
    public BotDialog(UserProfileData userProfileData,accountOpaningForm openedForm) {
        this.openedForm=openedForm;
        this.userProfileData=userProfileData;
        
        initComponents();
        getContentPane().setBackground(new Color(25,31,38));
        try{
            con = DB_Con.getConnection();
            stmt = con.createStatement();
            pstmt = con.prepareStatement("Insert into app.image (photo,ID,profileFormat) values(?,?,?)");
            DbCard = con.prepareStatement("Insert into app.DebitCardDetails values(?,?,?,?,?,?,?)");
            DQrImage = con.prepareStatement("update app.image set DQrcode=? where ID = ?");
            CQrImage = con.prepareStatement("update app.image set CQrcode=? where ID = ?");
            CrCard = con.prepareStatement("Insert into app.CreaditCardDetails values(?,?,?,?,?,?,?)");
            
            
        }catch(Exception e){
            showError(e.getMessage(),"Database is not connected please contact to Developer!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        msz = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Note");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 661));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(25, 31, 38));
        jPanel1.setPreferredSize(new java.awt.Dimension(661, 661));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/loading-2 (1).gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(25, 31, 38));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 281));

        bar.setForeground(new java.awt.Color(18, 239, 254));
        bar.setOpaque(true);
        bar.setString("5%");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Saving");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(715, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(25, 31, 38));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 661));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thank You!");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("For join us");

        ID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        msz.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        msz.setForeground(new java.awt.Color(0, 204, 204));
        msz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msz.setText("Please login with this customer id and signup password!");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/icons8-id-verified-16 (1).png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm_p/pictures/icons8-enter-white.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(msz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(384, 384, 384)
                                .addComponent(jLabel8)))
                        .addGap(0, 343, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(105, 105, 105)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(msz)
                .addGap(41, 41, 41))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 800, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 379, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
                try{
                    saveData(); //this thread will save tha data in database
                }catch(Exception e){
                   showError(e.getMessage(),"Unavilable to store data please contact to Developer!");
                   //Reverse code in case of any fault it will delte all the currenty saved data;
                  try{ reverse();}
                  catch(Exception m){
                      showError(m.getMessage(),"Unavilable to reverse the database!");
                  }
                }
       
        new Thread(new Runnable(){
               public void run(){
                   try{
                       if(userProfileData.CustomerType.equals("Public")){
                           for(int i = 0;i<success.size();i++){
                               if(success.get(i)>0){
                                   doTask((100/success.size())*(i+1));
                                   if(i==success.size()-1){
                                       IDShow(Id, "Please login with this customer id and signup password!");
                                   }
                               }
                               else{
                                  showError("","Unavilable to store some data please contact to Developer!");
                                   break;
                               }
                           }
                       }
                       else{
                           for(int i = 0;i<success.size();i++){
                               if(success.get(i)>0){
                                   doTask(100/success.size()*(i+1));
                                   if(i==success.size()-1){
                                       IDShow(Id, "Application has submited to Admin you can check your application status with thi admin id and signup password!");
                                   }
                               }
                               else{
                                   showError("","Unavilable to store some data please contact to Developer!");
                                   break;
                               }
                           }

                       }
                   }catch(Exception e){
                       showError(e.getMessage(),"Unavilable to store data please contact to Developer!");
                            try{ reverse();}
                       catch(Exception m){
                           showError(m.getMessage(),"Unavilable to reverse the database!");
                       }
                   }
               }
           }).start();
    };//GEN-LAST:event_formWindowOpened
    private void IDShow(String id,String message)throws Exception{
        jLabel2.setText("Saved");
        Thread.sleep(2000);
        openedForm.dispose();
        ID.setText(id);
        msz.setText(message);
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
    }
    private void showError(String error,String message){
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        openedForm.dispose();
        jLabel3.setIcon( new ImageIcon(getClass().getResource("/atm_p/pictures/icons8-error-16.png")));
        jLabel3.setForeground(Color.red);
        jLabel3.setText(error);
        msz.setText(message);
        jLabel4.setVisible(false);
        jLabel7.setVisible(false);
        ID.setVisible(false);
    }
    private String CIDGenerator()throws Exception{
        ResultSet rs= stmt.executeQuery("Select CID from app.customer where isLastAccount=true");
        System.out.println(rs.next());
        String retrievCID = rs.getString(1);
        PreviousId = retrievCID;
        stmt.executeUpdate("update app.customer set isLastAccount=false where isLastAccount=true");
        String numericID = retrievCID.substring(2);
        int ID = Integer.parseInt(numericID)+1;
        String customerId = "AS"+ID;
        return Id= customerId;
    }
    private String AIDGenerator()throws Exception{
        ResultSet rs= stmt.executeQuery("Select AID from app.admininfo where isLastAccount=true");
        rs.next();
        String retrievAID = rs.getString(1);
        PreviousId = retrievAID;
        stmt.executeUpdate("update app.admininfo set isLastAccount=false where isLastAccount=true");
        String numeriaID = retrievAID.substring(3);
        int ID = Integer.parseInt(numeriaID)+1;
        String adminId = "SAK"+ID;
        System.out.println(adminId);
        return Id= adminId;
    }
    private long AcnNGenerator(String customerId){
        String sub = customerId.substring(2);
        String longnum = "3583000100"+sub;
        return Long.parseLong(longnum);
    }
    
    private void saveData()throws Exception{
        success = new ArrayList<>();
        java.time.format.DateTimeFormatter formatter =  java.time.format.DateTimeFormatter.ofPattern("EEEE,d'th' MMMM y  HH:mm");
        java.time.LocalDateTime ldt = LocalDateTime.now();

       
        if(userProfileData.CustomerType.equals("Public")){
             customerId=CIDGenerator();
            //customer detail
           String query1="Insert into app.customer values("+"'"+customerId+"'"+","+"'"+userProfileData.UserName+"'"+","+"'"+userProfileData.Password+"'"+","+"'"+userProfileData.CustomerName+"'"+","+"'"+userProfileData.DateOfBirth+"'"+","+"'"+
                    userProfileData.Gender+"'"+","+"'"+userProfileData.MaterialStatus+"'"+","+"'"+userProfileData.Religion+"'"+","+"'"+userProfileData.UID+"'"+","+Long.parseLong(userProfileData.MobileNumber)+","+"'"+
                    userProfileData.EmailAddress+"'"+","+"'"+userProfileData.Nationality+"'"+","+"'"+userProfileData.State+"'"+","+"'"+userProfileData.City+"'"+","+Integer.parseInt(userProfileData.PinCode)+","+"'"+
                    userProfileData.PermanentAddress+"'"+","+true+","+"'"+userProfileData.ParentsName+"'"+")";
              stmt.addBatch(query1);
              
           // customer photo
            pstmt.setString(2,customerId);
            pstmt.setString(3, userProfileData.imageExtension);
            pstmt.setBinaryStream(1, userProfileData.UserImage,userProfileData.UserImage.available());
            success.add(pstmt.executeUpdate());
                
            
            //nomini
            if(userProfileData.Nomini){
            String query2="insert into app.nomini values("+"'"+customerId+"'"+","+"'"+userProfileData.NominiName+"'"+","+"'"+userProfileData.NominiRelation+"'"+","+"'"+userProfileData.NominiUID+"'"+")";
            stmt.addBatch(query2);
            }
            //DebitCardDetails
            if(userProfileData.DebitCard){
                DebitDataGenerator.debitGenerator( userProfileData.UserName);
                DbCard.setString(1, customerId);
                DbCard.setString(2, DebitDataGenerator.DCN);
                DbCard.setString(3, DebitDataGenerator.D_CVV);
                DbCard.setString(4, DebitDataGenerator.ValidFrom);
                DbCard.setString(5, DebitDataGenerator.ValidThru);
                DbCard.setString(6, userProfileData.DPIN);
                DbCard.setBoolean(7, userProfileData.DisBlocked);
                success.add(DbCard.executeUpdate());
                DQrImage.setBinaryStream(1, DebitDataGenerator.inputStream, DebitDataGenerator.inputStream.available());
                DQrImage.setString(2, customerId);
                 success.add(DQrImage.executeUpdate());
            }
            if(userProfileData.CreaditCard){
               CreaditCardGenerator.CreaditGenerator(userProfileData.UserName);
                CrCard.setString(1, customerId);
                CrCard.setString(2, CreaditCardGenerator.CCN);
                CrCard.setString(3, CreaditCardGenerator.C_CVV);
                CrCard.setString(4, CreaditCardGenerator.ValidFrom);
                CrCard.setString(5, CreaditCardGenerator.ValidThru);
                CrCard.setString(6, userProfileData.CPIN);
                CrCard.setBoolean(7, userProfileData.CisBlocked);
                success.add(CrCard.executeUpdate());
                CQrImage.setBinaryStream(1, CreaditCardGenerator.inputStream, CreaditCardGenerator.inputStream.available());
                CQrImage.setString(2, customerId);
                success.add(CQrImage.executeUpdate());
            }
            //Account details
            long accountNumber=AcnNGenerator(customerId);
            String query3 = "insert into app.account values("+"'"+customerId+"'"+","+accountNumber+","+"'"+userProfileData.AccountType+"'"+","+userProfileData.OpaningAmmount+","+"'"+userProfileData.AccountStatus+"'"+","+
                    userProfileData.CreaditCard+","+userProfileData.DebitCard+","+userProfileData.ChequeBook+","+"'"+formatter.format(ldt).toString()+"'"+","+userProfileData.Nomini+")";
                stmt.addBatch(query3);
            int arr[]=stmt.executeBatch();
            for(int j=0;j<arr.length;j++){
                 success.add(arr[j]);
            }
            
        }
        else{
            adminId =AIDGenerator();
            //admin detail
              String query="Insert into app.admininfo values("+"'"+adminId+"'"+","+"'"+userProfileData.UserName+"'"+","+"'"+userProfileData.Password+"'"+","+"'"+userProfileData.CustomerName+"'"+","+"'"+userProfileData.DateOfBirth+"'"+","+"'"+
                    userProfileData.Gender+"'"+","+"'"+userProfileData.MaterialStatus+"'"+","+"'"+userProfileData.Religion+"'"+","+"'"+userProfileData.UID+"'"+","+Long.parseLong(userProfileData.MobileNumber)+","+"'"+
                    userProfileData.EmailAddress+"'"+","+"'"+userProfileData.Nationality+"'"+","+"'"+userProfileData.State+"'"+","+"'"+userProfileData.City+"'"+","+Integer.parseInt(userProfileData.PinCode)+","+"'"+
                    userProfileData.PermanentAddress+"'"+","+userProfileData.Approved+","+true+")";
             
             int k=stmt.executeUpdate(query);
            //admin photo
             pstmt.setString(2,adminId);
            pstmt.setBinaryStream(1, userProfileData.UserImage,userProfileData.UserImage.available());
            int i=pstmt.executeUpdate();
            success.add(k);
            success.add(i);
            
        }
        stmt.close();
        pstmt.close();
        con.close();
    }
    
    ////reverse method work in case of exception
    private void reverse()throws Exception{
        
        if(userProfileData.CustomerType.equals("Public")){
            //customer detail
           Reverse.TheTable(con, "customer", "CID", customerId);
//           Statement stmt = con.createStatement();
           stmt.executeUpdate("update app.customer set isLastAccount = true where CID = "+"'"+PreviousId+"'");
            System.out.println(PreviousId+" I am try to work");
           
              
           // customer photo
            Reverse.TheTable(con, "image", "ID", customerId);
                
            
            //nomini
            if(userProfileData.Nomini){
            Reverse.TheTable(con, "nomini", "CID", customerId);
            }
            //DebitCardDetails
            if(userProfileData.DebitCard){
                Reverse.TheTable(con, "DebitCardDetails", "CID", customerId);
            }
            if(userProfileData.CreaditCard){
              Reverse.TheTable(con, "CreaditCardDetails","CID",customerId);
            }
            //Account details
            Reverse.TheTable(con, "account", "CID", customerId);
            
        }
        else{
            //admin detail
            Reverse.TheTable(con, "admininfo", "AID", adminId);
            stmt.executeUpdate("update app.admininfo set isLastAccount = true where AID = "+"'"+ID+"'");

            //admin photo
            Reverse.TheTable(con, "image","ID", adminId);
        }
    }
    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
       jLabel8.setIcon(new ImageIcon(getClass().getResource("/atm_p/pictures/icons8-enter-blue.png")));
        Sound.play("click");
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/atm_p/pictures/icons8-enter-white.png")));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked
    private void doTask(int process)throws Exception{
        Thread.sleep(400);
        bar.setValue(process);
    }
        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new BotDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JProgressBar bar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel msz;
    // End of variables declaration//GEN-END:variables
}
