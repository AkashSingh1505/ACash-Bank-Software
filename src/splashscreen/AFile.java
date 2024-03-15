
package splashscreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import javax.swing.JLabel;


/**
 *
 * @author Akash
 */
public class AFile {
//    static String feedback=null;
    static JLabel l=null;
     static void copy(String src,String targ,JLabel ll){
            l=ll;
            File Src = new File(src);
            File Targ = new File(targ);
            
        if(Src.exists()){
            // Copy directory and file recursuvely
                
                AFile file = new AFile();
                file.copyDir(Src,Targ);
                l.setText("Load Successfully");
        }
        else{
                l.setText("Source file is not exist");
        }
    }
    public void copyDir(File src,File dest){
        if(src.isDirectory()){
          // copy directory
                    if(!dest.exists()){
                        dest.mkdir();
                        l.setText("Directory copied from " + src + "  to "
						+ dest);
                    }
            // list all the directory contents
            String fileList[] = src.list();
            for(String fileName:fileList){
                File srcSubFile=new File(src, fileName);
                File targSubFile=new File(dest, fileName);
                // recursive copy
               copyDir(srcSubFile, targSubFile);
            }
            
        }
        else{
            // If file, then copy it
            copyFile(src,dest);

        }
//        System.out.println(feedback);
      
    }
    private void copyFile(File src,File targ){
        try{
        java.nio.file.Path srcPath = java.nio.file.Paths.get(src.getPath());
        java.nio.file.Path targPath = java.nio.file.Paths.get(targ.getPath());
        java.nio.file.Files.copy(srcPath, targPath);
        l.setText("File copied from " + src + " to " + targ);
//            System.out.println(feedback);
        }catch(Exception e){
            l.setText(e.getMessage());
//            System.out.println(feedback);
        }
    }
}
