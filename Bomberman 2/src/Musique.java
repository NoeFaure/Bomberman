import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musique {
	
		public static void JouerMusique(String Nom_musique) 
		{
		    try 
		    {
		        AudioInputStream Musique = AudioSystem.getAudioInputStream(new File(Nom_musique).getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(Musique);
		        clip.loop(1);
		    } 
		    catch(Exception ex) 
		    {
		        System.out.println("Une erreur est survenue lors du lancement de la musique.");
		        ex.printStackTrace();
		    }
		}
		
		public static void FinMusique()
		{
			
		}
}
