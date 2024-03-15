
package atm_p;
import java.net.InetAddress;
import java.sql.*;


public class DB_Con {
     static String url="";
    public static Connection getConnection()throws Exception{
            url ="jdbc:derby:C:\\ProgramData\\ACash\\ACash_Bank";
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = DriverManager.getConnection(url,"client","8441881405");
            return con;
            
//            }
            
    }
//    String Hostname ="";
//    private  String isFirstLoad(){
//        try{
//            Hostname=InetAddress.getLocalHost().getHostName();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return Hostname;
//    }
    
}
