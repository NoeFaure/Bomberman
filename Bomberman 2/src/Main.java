
import edu.princeton.cs.introcs.StdDraw;

public class Main {

	public static void main(String[] args) {
		
		//Création de la fenêtre
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1250,690);
		StdDraw.setXscale(0,1250);
		StdDraw.setYscale(690, 0);
		
		//Musique Ecran Titre
		//Musique.JouerMusique("Bomberman - Accueil.wav");
		
		//Lancement de la musique
		//Musique.JouerMusique("Golden_Sun_Soundtrack-_Isaac_Battle_Theme.wav");
		
		//Création des personnages
		Personnage Joueur1 = new Personnage(1,15);
		Joueur1.setSkin("Bomberman Perso 1.png");
		
		Personnage Joueur2 = new Personnage(19,1);
		Joueur2.setSkin("Bomberman Perso 2.png");
		
		Ecran_Titre Ecran_titre_2 = new Ecran_Titre();
		Ecran_titre_2.Affiche_Ecran_Titre(Joueur1,Joueur2);
		
	}
}