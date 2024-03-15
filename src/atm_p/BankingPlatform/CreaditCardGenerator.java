/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_p.BankingPlatform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class CreaditCardGenerator {
     static String CCN,C_CVV,ValidFrom,ValidThru;
   static java.io.InputStream inputStream=null;
    public static void CreaditGenerator(String UserName){
        DateTimeFormatter uniqueNO = DateTimeFormatter.ofPattern("'5'MMyyyyHHmmssMS");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
           LocalDateTime t = LocalDateTime.now(); 
       
        CCN = uniqueNO.format(t).toString();
        C_CVV= CCN.substring(11,14);
        ValidFrom =formatter.format(t).toString();
        ValidThru = formatter.format(t.plusYears(3));
        String details=CCN+ValidFrom+ValidThru+C_CVV+UserName;
       inputStream = QrGenerator.getQr(details);
      
    }
}
