/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_p.BankingPlatform;
import java.io.ByteArrayOutputStream;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import java.io.ByteArrayInputStream;
public class QrGenerator  {
    public static ByteArrayInputStream getQr(String Details){
        ByteArrayOutputStream stream = QRCode.from(Details).to(ImageType.PNG).stream();
        byte[] imageBytes=stream.toByteArray();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
        return inputStream;
    }
}
