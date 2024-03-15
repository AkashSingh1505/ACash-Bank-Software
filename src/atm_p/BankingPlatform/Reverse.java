/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_p.BankingPlatform;

import java.sql.*;

/**
 *
 * @author user
 */
public class Reverse {
    public static void TheTable(Connection con,String Table,String idColumn,String Id)throws Exception{
        PreparedStatement pstmt = con.prepareStatement("delete from "+"app."+Table+" where "+idColumn+" = ?");
        pstmt.setString(1, Id);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
