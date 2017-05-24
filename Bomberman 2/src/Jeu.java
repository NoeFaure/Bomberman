import java.awt.Font;
import edu.princeton.cs.introcs.StdDraw;

/*Tentative de rassemblement du code
 * permetant de lancer le jeu.
 */

public class Jeu {
	
	// Constructeur
	public Jeu()
	{
		
	}

	public void Jouer(Personnage Joueur1, Personnage Joueur2){
		
		//MAP DE BASE
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
		
		// --------- INITIALISATION DE L'HORLOGE --------- 
		
		Long Heure_debut = System.currentTimeMillis();
		Long Time_minute = 0l;

		// --------- CRÉATION DES OBJETS NÉCESSAIRES --------- 
		
		Menu Menu = new Menu();
		Plateau Plateau_1 = new Plateau(map);
		
		// --------- BOUCLE INFINIE --------- 
		while(true)
		{
			StdDraw.clear();
			Plateau_1.Afficher_map(map,Joueur1,Joueur2);
			
			
		// --------- VARIABLES A AFFICHER --------- 
			
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
			
			//Affiche menu
			if (StdDraw.isKeyPressed(27)){
				
				Menu.Affiche_Menu(map,Plateau_1,Joueur1,Joueur2,Time_seconde,Time_minute);
			}
			
			
		// --------- VERIFICATION DES VARIABLES --------- 
			
			// Verifie si les joueurs ont été touché par une explosion
			Plateau_1.Verif_Touche(map, Joueur1, Joueur2);
						
			// Vérifie si un joueur a gagné
			Plateau_1.Verifie_WIN(Joueur1, Joueur2);
			
		// --------- DEPLACEMENT DU PERSONNAGE --------- 
			
			//Joueur 1
			Joueur1.DeplacerJoueur1(Plateau_1);
			
			//COMMANDE DEVELOPPEUR ( Je la nettoie pas parce qu'elle est vouee a etre effacee *niark*)
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
			//
			
			Joueur1.PoserBombe(Plateau_1);
			
			// A faire au propre plus tard //
			Joueur1.CompteARebourd(Plateau_1, Joueur1, Joueur2); //renommer plus tard //
			Joueur1.EnleverFlamme(Plateau_1);
			
			/*if(Joueur1.getVie() < 0)
			{
				StdDraw.picture(625, 345, "Player 2 WIN.png");
			}
			if(Joueur2.getVie() < 0)
			{
				StdDraw.picture(625, 345, "Player 1 WIN.png");
			}
			*/
			
			StdDraw.show();
			StdDraw.pause(50);
		}
	}
}
