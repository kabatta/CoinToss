package sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	public void playSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
			new File("./src/268930__sfx4animation__coin-rotation.wav").getAbsoluteFile());
		    Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	public synchronized void playSound1() 
    {
            new Thread(new Runnable() 
            {
                // The wrapper thread is unnecessary, unless it blocks on the
                // Clip finishing; see comments.
                public void run() 
                {
                    try
                    {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream("./src/268930__sfx4animation__coin-rotation.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(inputStream);
                        clip.start(); 
                    } 
                    catch (Exception e) 
                    {
                        System.err.println(e.getMessage());
                    }
                }
            });;
        }

}