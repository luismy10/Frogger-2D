package util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

    private Clip clip;

    public Sound(String ruta) {
        wav(ruta);
    }

    private void wav(String ruta) {
        try {
            InputStream is = Sound.class.getResourceAsStream(ruta);
            AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void audio() {
        clip.stop();
        clip.flush();
        clip.setMicrosecondPosition(0);
        clip.start();
    }

    public void music() {
        clip.stop();
        clip.flush();
        clip.setMicrosecondPosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

//	private final String fileName;
//	private Player player;
//
//	public Sound(String name) {
//		fileName = name;
//	}
//
//	public void play() {
//		new Thread() {
//			@Override
//			public void run() {
//				try {
//					FileInputStream fis;
//					fis = new FileInputStream(fileName);
//					BufferedInputStream bis = new BufferedInputStream(fis);
//					player = new Player(bis);
//					player.play();	
//				} catch (JavaLayerException | FileNotFoundException e) {
//				}
//					
//			}
//		}.start();
//	} 
//
//	public void close() {
//		if (player != null) {
//			player.close();
//		}
//	}
}
