/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_p.BankingPlatform;

import javax.swing.ImageIcon;




public class ImageHelper {
    java.awt.Image image=null;
    static String imageFormat;
   public java.awt.Image getImage(java.sql.Connection con,String Id,String picName){
      try{
        java.sql.PreparedStatement pstmt = con.prepareStatement("select "+picName+" from app.image where ID = ?");
        java.sql.PreparedStatement p = con.prepareStatement("select profileFormat from app.image where ID = ?");
        p.setString(1, Id);
        
         pstmt.setString(1, Id);
         java.sql.ResultSet r = p.executeQuery();
         if(r.next()){imageFormat = r.getString(1);}
         else{
             System.out.println("Unable to find picture format");
         }
        java.sql.ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            java.sql.Blob b =  rs.getBlob(1);
            java.io.InputStream stream =b.getBinaryStream();
            image = javax.imageio.ImageIO.read(stream);
            return image;
        }
        
      }catch(Exception e){
          System.out.println("Unable to fatch QrCode");
      }
       System.out.println();
       return image;
    }
}
