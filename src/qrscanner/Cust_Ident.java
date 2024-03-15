
package qrscanner;
//steps for customer identification for atm process

import atm_p.DB_Con;
import java.sql.*;
public class Cust_Ident {
    public static String CID="";
    public static Connection con=null;
    public static String card=null;
    public static String PIN=null;
    public static boolean isblocked=false;
    public static boolean searchCust(String qrdata){
        if(qrdata.length()>=29){
            String cardNumber = qrdata.substring(0, 16);
            try{
                Connection conn = DB_Con.getConnection();
                con=conn;
                boolean isDC = searching(cardNumber,"DEBITCARDDETAILS","DCN",con);
                boolean isCC = searching(cardNumber,"CREADITCARDDETAILS","CCN",con);
                if(isDC==false && isCC ==false){
                    
                    return false;
                }
                else if(isDC){
                    card="DC";
                    isblocked=isBlocked("DEBITCARDDETAILS", "isBlocked", con,"CID");
                    if(!isblocked){
                            CID=getCID(cardNumber,"DEBITCARDDETAILS" , "CID", con, "DCN");
                            PIN=getPIN( "DEBITCARDDETAILS", "PIN", con, "CID");
                    }
                    
                    return true;
                }
                else if(isCC){
                    card="CC";
                    CID=getCID(cardNumber,"CREADITCARDDETAILS" , "CID", con, "CCN");
                    return true;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return false;
        }
        else{
            return false;
        }
    }
    private static boolean searching(String cardNumber,String Table,String tupple,Connection con)throws Exception{
        PreparedStatement pstmt = con.prepareStatement("select "+tupple+" from app."+Table+" where "+tupple+" = ?");
        pstmt.setString(1, cardNumber);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){return true;}
        return false;
    }
    private static String getCID(String cardNumber,String Table,String tupple,Connection con,String cardType)throws Exception{
        PreparedStatement pstmt = con.prepareStatement("select "+tupple+" from app."+Table+" where "+cardType+" = ?");
        pstmt.setString(1, cardNumber);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return rs.getString(1);
        }
        return "";
    }
    private static String getPIN(String Table,String tupple,Connection con,String cid)throws Exception{
        PreparedStatement pstmt = con.prepareStatement("select "+tupple+" from app."+Table+" where "+cid+" = ?");
        pstmt.setString(1, CID);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return rs.getString(1);
        }
        return "";
    }
    private static boolean isBlocked(String Table,String tupple,Connection con,String cid)throws Exception{
        PreparedStatement pstmt = con.prepareStatement("select "+tupple+" from app."+Table+" where "+cid+" = ?");
        pstmt.setString(1, CID);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            isblocked= rs.getBoolean(1);
        }
        return isblocked;//we did not allows those cards which have no datat in isBlocked column
    }
}
