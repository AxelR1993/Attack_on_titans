package juego;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonidos {

	private Clip clip;
	
	
	public Clip getClip() {
		return this.clip;
	}
	
	public void startMenu()
    {       
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/sonidos/menu.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); //repetir siempre
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
    }

    public void startBatalla()
    {       
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/sonidos/opening.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); //repetir siempre
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
    }
    
    public void stop() {
    	clip.stop();
    }
    
    public void startGameover()
    {       
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/sonidos/alumina.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); //repetir siempre
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
    }
    
    public void startEnding()
    {       
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/sonidos/ending.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); //repetir siempre
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
    }
    
    public void startBoss()
    {       
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/sonidos/boss.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); //repetir siempre
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
    }
       
    
    
}   
