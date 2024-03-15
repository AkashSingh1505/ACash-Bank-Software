
package qrscanner;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class DecodeQR {
    public static String decode(java.awt.image.BufferedImage image) throws NotFoundException{
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        com.google.zxing.Result resultObj = new MultiFormatReader().decode(binaryBitmap);
        return resultObj.getText();
    }
}
