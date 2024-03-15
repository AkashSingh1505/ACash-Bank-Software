/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_p.BankingPlatform;

/**
 *
 * @author user
 */
public class RetriveFromDb {
    public static java.sql.ResultSet getData(java.sql.Connection con,String TableName,String id)throws Exception{
        java.sql.PreparedStatement pstmt = con.prepareStatement("select * from "+"app."+TableName+" where CID = ?");
        pstmt.setString(1, id);
        java.sql.ResultSet rs = pstmt.executeQuery();
        return rs;
        
    }
}
