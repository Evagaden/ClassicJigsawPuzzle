package Playmusic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class sound
{
    public sound(int index) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        try {
            File file = new File("src/Sound/" + index + ".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
