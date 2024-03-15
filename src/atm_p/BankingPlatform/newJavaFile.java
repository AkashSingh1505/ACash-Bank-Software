/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atm_p.BankingPlatform;

//import java.text.SimpleDateFormat;
import java.sql.*;
import atm_p.DB_Con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;

//import java.time.LocalDate;
//import java.util.Date;

/**
 *
 * @author user
 */
public class newJavaFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String d = formatter.format(date);
//        System.out.println(d);
//        LocalDate ddate = LocalDate.now();
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        String n =f.format(ddate);
//        System.out.println(ddate);
//        System.out.println(n);
//           try{
//                    Connection con = DB_Con.getConnection();
//                    Statement stmt =  con.createStatement();
//                    ResultSet rs = stmt.executeQuery("select CID,Password from customer where CID = 'AS321002' AND Password='0000*aaaa'");
//                    PreparedStatement pstmt = con.prepareStatement("select ? from ? where ? = ?");
//                    pstmt.setNString(1, "CID");
//                    pstmt.setString(3, "CID");
//                    pstmt.setString(2, "customer");
//                    pstmt.setString(4, "AS321011");
//                    System.out.println(pstmt.executeQuery().next());
//                    rs.next();
//                   if(!rs.getString(1).isEmpty()){
//                       System.out.println("true");
//                   }
//System.out.println(rs.next());
//                    
//                }catch(Exception e){
//                    e.printStackTrace();
//                }

           
//       private boolean SearchIDnDb(String Table,String idColumn,String ID,String psw){
//       try{
//            Connection con = DB_Con.getConnection();
//            PreparedStatement pstmt = con.prepareStatement("select "+idColumn+",Password from "+Table+" where "+idColumn+" = ? AND Password = ?");
//            pstmt.setString(1, ID);
//            pstmt.setString(2, psw);
//            if(pstmt.executeQuery().next()){
//                return true;            
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//       return false;
   }     
           
           
           
           
           
           
           
           
           
           
           
//           System.out.println(LocalDate.now());
//           System.out.println(LocalTime.now());
//        
    }
//}
