import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import edu.princeton.cs.introcs.StdDraw;

public class Main {

	public static void main(String[] args) {
		
		//Création de la fenêtre
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1250,690);
		StdDraw.setXscale(0,1250);
		StdDraw.setYscale(690, 0);
		
		//Lancement de la musique
		JouerMusique();
		
		//Affiche Ecran Titre
		//JouerMusiqueAccueil();
		Ecran_Titre Ecran_titre_1 = new Ecran_Titre();
		Ecran_titre_1.Affiche_Ecran_Titre();
		
		Jeu Partie_1 = new Jeu();
		Partie_1.Jouer();
		
	}
	
	
	/// Musique ///
	public static void JouerMusique() {
	    try {
	        AudioInputStream Musique = AudioSystem.getAudioInputStream(new File("Bande_son_1.wav").getAbsoluteFile()); // Golden_Sun_Soundtrack-_Isaac_Battle_Theme
	        Clip clip = AudioSystem.getClip();
	        clip.open(Musique);
	        clip.loop(5);
	    	} 
	    catch(Exception ex) 
	    {
	        System.out.println("Une erreur est survenue lors du lancement de la musique.");
	        ex.printStackTrace();
	    }
	}
	
	public static void JouerMusiqueAccueil() {
	    try {
	        AudioInputStream Musique = AudioSystem.getAudioInputStream(new File("Bomberman - Accueil.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(Musique);
	        clip.loop(5);
	    	} 
	    catch(Exception ex) 
	    {
	        System.out.println("Une erreur est survenue lors du lancement de la musique.");
	        ex.printStackTrace();
	    }
	}
	
	public static void Play_Sound(String Nom_musique) {
	    try {
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
	
}