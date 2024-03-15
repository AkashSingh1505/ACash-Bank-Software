
package atm_p.BankingPlatform;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;

public class DebitDataGenerator {
   static String DCN,D_CVV,ValidFrom,ValidThru;
   static java.io.InputStream inputStream=null;
    public static void debitGenerator(String UserName){
        DateTimeFormatter uniqueNO = DateTimeFormatter.ofPattern("'15'ddMMyyyyHHmmss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
           LocalDateTime t = LocalDateTime.now(); 
       
        DCN = uniqueNO.format(t).toString();
        D_CVV= DCN.substring(11,14);
        ValidFrom =formatter.format(t).toString();
        ValidThru = formatter.format(t.plusYears(7));
        String details=DCN+ValidFrom+ValidThru+D_CVV+UserName;
       inputStream = QrGenerator.getQr(details);
       
    }
}

