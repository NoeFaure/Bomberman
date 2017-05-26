import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musique {
	
		private static Clip clip;
		
		/// Setters and Getters ///
		public static Clip getClip() {
			return clip;
		}

		public void setClip(Clip clip) {
			Musique.clip = clip;
		}
		
		/// Fonctions ///
		public static void JouerMusiqueContinu(String Nom_musique) 
		{
		    try 
		    {
		        AudioInputStream Musique = AudioSystem.getAudioInputStream(new File(Nom_musique).getAbsoluteFile());
		        clip = AudioSystem.getClip();
		        clip.open(Musique);
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		    } 
		    catch(Exception ex) 
		    {
		        System.out.println("Une erreur est survenue lors du lancement de la musique.");
		        ex.printStackTrace();
		    }
		}
		
		public static void JouerMusique(String Nom_musique) 
		{
		    try 
		    {
		        AudioInputStream Musique = AudioSystem.getAudioInputStream(new File(Nom_musique).getAbsoluteFile());
		        clip = AudioSystem.getClip();
		        clip.open(Musique);
		        clip.loop(0);
		    } 
		    catch(Exception ex) 
		    {
		        System.out.println("Une erreur est survenue lors du lancement de la musique.");
		        ex.printStackTrace();
		    }
		}
}
