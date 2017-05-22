import java.awt.Font;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import edu.princeton.cs.introcs.StdDraw;

public class Main {

	public static void main(String[] args) {
		
		int map [][] =
			{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,0},
			{0,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,1,4,1,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,0},
			{0,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,0},
			{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,0},
			{0,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,1,4,1,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,0},
			{0,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

		//Création de la fenêtre
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1250,690);
		StdDraw.setXscale(0,1250);
		StdDraw.setYscale(690, 0);
		
		//Lancement de la musique
		//JouerMusique();
		
		//Affiche Ecran Titre
		//JouerMusiqueAccueil();
		Ecran_Titre Ecran_titre_1 = new Ecran_Titre();
		Ecran_titre_1.Affiche_Ecran_Titre();
		
		//SET TIMER //
		Long Heure_debut = System.currentTimeMillis();
		Long Time_minute = 0l;

		Menu Menu = new Menu();
		Plateau Plateau_1 = new Plateau(map);
		Personnage Joueur1 = new Personnage(1,15);
		Personnage Joueur2 = new Personnage(19,1);
		
		//Boucle infinie
		while(true)
		{
			StdDraw.clear();
			Plateau_1.Afficher_map(map,Joueur1,Joueur2);
			// VARIABLES A AFFICHER
			
			
			
			//Bonus
			Joueur1.Affiche_bonus_Joueur1();
			Joueur2.Affiche_bonus_Joueur2();

			
			//Timer
			Long Time_seconde = (System.currentTimeMillis() - Heure_debut)/1000;
			if(Time_seconde > 59){
				Heure_debut = System.currentTimeMillis();
				Time_minute = Time_minute + 1;
			}
			//Affichage timer
			if (Time_seconde < 10 && Time_minute < 10){
				StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
			}
			else if(Time_seconde >= 10 && Time_minute < 10){
				StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
			}
			else if(Time_seconde < 10 && Time_minute >= 10){
				StdDraw.text(1150, 116,Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
			}
			else if(Time_seconde >= 10 && Time_minute >= 10){
				StdDraw.text(1150, 116,Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
			}
			
			// Verifie si les joueurs ont été touché par une explosion
			Plateau_1.Verif_Touche(map, Joueur1, Joueur2);
			
			//Affiche menu
			if (StdDraw.isKeyPressed(27)){
				
				Menu.Affiche_Menu(map,Plateau_1,Joueur1,Joueur2,Time_seconde,Time_minute);
			}
			
			//DEPLACEMENT PERSO
			
			//Joueur 1
			Joueur1.DeplacerJoueur1(Plateau_1);
			
			//COMMANDE DEVELOPPEUR ( Je la nettoie pas parce qu'elle est vou�e � �tre effac�e *niark*)
				if (StdDraw.isKeyPressed(73) && map[Joueur1.getY()-1][Joueur1.getX()] != 0){
					map[Joueur1.getY()-1][Joueur1.getX()] = 1;
				}
				if (StdDraw.isKeyPressed(76) && map[Joueur1.getY()][Joueur1.getX()+1] != 0){
					map[Joueur1.getY()][Joueur1.getX()+1] = 1;
				}
				if (StdDraw.isKeyPressed(74) && map[Joueur1.getY()][Joueur1.getX()-1] != 0){
					map[Joueur1.getY()][Joueur1.getX()-1] = 1;
				}
				if (StdDraw.isKeyPressed(75) && map[Joueur1.getY()+1][Joueur1.getX()] != 0){
					map[Joueur1.getY()+1][Joueur1.getX()] = 1;
				}
			
			
			
			//Joueur 2
			Joueur2.DeplacerJoueur2(Plateau_1);
			Joueur1.PoserBombe(Plateau_1);
			
			// A faire au propre plus tard //
			Joueur1.CompteARebourd(Plateau_1); //renommer plus tard //
			
			
			
			
			StdDraw.show();
			StdDraw.pause(50);
		}
		
		
		
	}
	/// Musique ///
	public static void JouerMusique() {
	    try {
	        AudioInputStream Musique = AudioSystem.getAudioInputStream(new File("Super_Mario_Sunshine_Music_-_Delfino_Plaza.wav").getAbsoluteFile()); // Golden_Sun_Soundtrack-_Isaac_Battle_Theme
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
}