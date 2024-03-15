
package atm_p.sound;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.Clip;

public class Sound {
    public static Clip play(String track){
        try{
//            java.io.File file = new java.io.File(Sound.class.getResource("/atm_p/sound/"+track+".wav").toURI());
            InputStream audioSrc = Sound.class.getResourceAsStream("/atm_p/sound/"+track+".wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            javax.sound.sampled.AudioInputStream audioinputstram = javax.sound.sampled.AudioSystem.getAudioInputStream(bufferedIn);
            javax.sound.sampled.Clip clip = javax.sound.sampled.AudioSystem.getClip();
            clip.open(audioinputstram);
            clip.start();
            return clip;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Unable to play Sound track");
        }
        return null;
    }
    
}
