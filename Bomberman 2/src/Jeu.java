import java.awt.Font;
import edu.princeton.cs.introcs.StdDraw;

/*Tentative de rassemblement du code
 * permetant de lancer le jeu.
 */

public class Jeu {
	
	/// Constructeur ///
	public Jeu()
	{
		
	}

	public void Jouer(Personnage Joueur1, Personnage Joueur2, boolean Solo)
	{
		//MAP DE BASE
		
		/* DÉTAIL MAP : 
		 * - 0 : Mur d'enceinte ( infranchissable )
		 * - 1 : Herbe sol ( franchissable )
		 * - 2 : Mur Destructible
		 * - 3 : Bombes posée
		 * - 4 : Mur Indestructible
		 * - 5 : Flamme ( temporaire )
		 * - 6 : Bonus
		 */
		
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
		
		// --------- CRÉATION DE L'IA SI LE MODE SOLO EST SELECTIONNE -------
		
		IA IA_1 = new IA();
		
		// --------- Lancement de la musique -------
		//Musique.getClip().stop();
		//Musique.JouerMusiqueContinu("Musique/Bande_son_1.wav");
		
		// --------- INITIALISATION DE L'HORLOGE --------- 
		
		Long Heure_debut = System.currentTimeMillis();
		Long Time_minute = 0l;
		
		// --------- INITIALISATION DES POLICES D'ECRITURE ---------
		
		Font font = new Font("Arial", Font.BOLD, 30);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.WHITE);

		// --------- CRÉATION DES OBJETS NÉCESSAIRES --------- 
		
		Menu Menu = new Menu();
		Plateau Plateau_1 = new Plateau(map);
		
		// --------- RESET DES PERSONNAGES ( CAS DU RESTART ) --------- 
		Joueur1.setX(1);
		Joueur1.setY(15);
		
		Joueur2.setX(19);
		Joueur2.setY(1);
		
		Joueur1.setVie(3);
		Joueur2.setVie(3);
		
		Joueur1.setListeBombe(new Bombe[10]);
		Joueur2.setListeBombe(new Bombe[10]);
		
		// --------- BOUCLE INFINIE --------- 
		while(true)
		{
			StdDraw.clear();
			Plateau_1.Afficher_map(map,Joueur1,Joueur2);
			
			
		// --------- VARIABLES A AFFICHER --------- 
			
			//Bonus
			Joueur1.Affiche_bonus_Joueur1();
			Joueur2.Affiche_bonus_Joueur2();

			
			/// Timer ///
			Font font_2 = new Font("Arial", Font.BOLD, 10);
			StdDraw.setFont(font_2);
			
			Long Time_seconde = (System.currentTimeMillis() - Heure_debut)/1000;
			if(Time_seconde > 59)
			{
				Heure_debut = System.currentTimeMillis();
				Time_minute = Time_minute + 1;
			}
			
			/// Affichage timer ///
			if (Time_seconde < 10 && Time_minute < 10)
			{
				StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
			}
			else if(Time_seconde >= 10 && Time_minute < 10)
			{
				StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
			}
			else if(Time_seconde < 10 && Time_minute >= 10)
			{
				StdDraw.text(1150, 116,Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
			}
			else if(Time_seconde >= 10 && Time_minute >= 10)
			{
				StdDraw.text(1150, 116,Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
			}
			
			/// Affiche menu ///
			if (StdDraw.isKeyPressed(27))
			{
				Menu.Affiche_Menu(map,Plateau_1,Joueur1,Joueur2,Time_seconde,Time_minute);
			}
			
			
		// --------- VERIFICATION DES VARIABLES --------- 
			
			// Verifie si les joueurs ont été touché par une explosion ///
			Plateau_1.Verif_Touche(map, Joueur1, Joueur2);
						
			/// Vérifie si un joueur a gagné ///
			Plateau_1.Verifie_WIN(Joueur1, Joueur2);
			
		// --------- DEPLACEMENT DU PERSONNAGE --------- 
			
			/// Joueur 1 ///
			Joueur1.DeplacerJoueur1(Plateau_1);
			
			/// COMMANDE DEVELOPPEUR ///
			
				/// Haut ///
				if (StdDraw.isKeyPressed(73) && map[Joueur1.getY()-1][Joueur1.getX()] != 0)
				{
					map[Joueur1.getY()-1][Joueur1.getX()] = 1;
				}
				
				/// Droite ///
				if (StdDraw.isKeyPressed(76) && map[Joueur1.getY()][Joueur1.getX()+1] != 0)
				{
					map[Joueur1.getY()][Joueur1.getX()+1] = 1;
				}
				
				/// Gauche ///
				if (StdDraw.isKeyPressed(74) && map[Joueur1.getY()][Joueur1.getX()-1] != 0)
				{
					map[Joueur1.getY()][Joueur1.getX()-1] = 1;
				}
				
				/// Bas ///
				if (StdDraw.isKeyPressed(75) && map[Joueur1.getY()+1][Joueur1.getX()] != 0)
				{
					map[Joueur1.getY()+1][Joueur1.getX()] = 1;
					System.out.println(Joueur2.getX() + " , " + Joueur2.getY());
				}
			
			//Joueur 2
			if (Solo == false)
			{
				Joueur2.DeplacerJoueur2(Plateau_1);
			}
			else if (Solo == true)
			{
				IA_1.Deplacement_IA(Joueur1,Joueur2,Plateau_1);
			}
			if( (StdDraw.isKeyPressed(32)) && (Plateau_1.map[Joueur1.getY()][Joueur1.getX()] != 3) && (Joueur1.getNbBombe() > 0)) // espace //
			{
			Joueur1.PoserBombe(Plateau_1);
			}
			// A faire au propre plus tard //
			Joueur1.CompteARebourd(Plateau_1, Joueur1, Joueur2); //renommer plus tard //
			Joueur1.EnleverFlamme(Plateau_1);
			
			StdDraw.show();
			StdDraw.pause(50);
		}
	}
}
