import java.awt.Font;

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
		
		//SET TIMER //
		Long Heure_debut = System.currentTimeMillis();
		Long Time_minute = 0l;
		
		Plateau Plateau_1 = new Plateau(map);
		Personnage Joueur1 = new Personnage(1,15);
		Personnage Joueur2 = new Personnage(19,1);
		//Plateau_1.Afficher_map(map);
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1250,690);
		StdDraw.setXscale(0,1250);
		StdDraw.setYscale(690, 0);
		
		//Boucle infinie
		while(true)
		{
			StdDraw.clear();
			Plateau_1.Afficher_map(map,Joueur1,Joueur2);
			//Joueur1.Affiche_perso(Joueur1.getX(), Joueur1.getY(), "Character Boy.png");
			
			// VARIABLES A AFFICHER
			
			//Paramètres Polices
			Font font = new Font("Arial", Font.BOLD, 30);
			StdDraw.setFont(font);
			StdDraw.setPenColor(StdDraw.WHITE);
			
			//Nombre de vies
			StdDraw.text(1213, 249, Integer.toString((Joueur1.getVie())));
			StdDraw.text(1213, 454, Integer.toString((Joueur2.getVie())));
			
			//Nombre de bombes
			StdDraw.text(1125, 249, Integer.toString((Joueur1.getNbBombe())));
			StdDraw.text(1125, 454, Integer.toString((Joueur2.getNbBombe())));
			
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
			
			
			
			
			//DEPLACEMENT PERSO
			
			//Joueur 1
			if(StdDraw.isKeyPressed(39) && (Plateau_1.map[Joueur1.getY()][Joueur1.getX()+1] != 0) && (Plateau_1.map[Joueur1.getY()][Joueur1.getX()+1] != 2) && (Plateau_1.map[Joueur1.getY()][Joueur1.getX()+1] != 4))
			{			
				Joueur1.DeplacerDroite();
			}
			if(StdDraw.isKeyPressed(38) && (Plateau_1.map[Joueur1.getY() - 1][Joueur1.getX()] != 0) && (Plateau_1.map[Joueur1.getY() - 1][Joueur1.getX()] != 2) && (Plateau_1.map[Joueur1.getY()-1][Joueur1.getX()] != 4))
			{
				Joueur1.DeplacerHaut();
			}
			if(StdDraw.isKeyPressed(40)&& (Plateau_1.map[Joueur1.getY()+1][Joueur1.getX()] != 0) && (Plateau_1.map[Joueur1.getY()+1][Joueur1.getX()] != 2) && (Plateau_1.map[Joueur1.getY()+1][Joueur1.getX()] != 4))
			{
				Joueur1.DeplacerBas();
			}
			if(StdDraw.isKeyPressed(37)&& (Plateau_1.map[Joueur1.getY()][Joueur1.getX()-1] != 0) && (Plateau_1.map[Joueur1.getY()][Joueur1.getX()-1] != 2) && (Plateau_1.map[Joueur1.getY()][Joueur1.getX()-1] != 4))
			{
				Joueur1.DeplacerGauche();
			}
			
			//COMMANDE DEVELOPPEUR
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
			if(StdDraw.isKeyPressed(68) && (Plateau_1.map[Joueur2.getY()][Joueur2.getX()+1] != 0) && (Plateau_1.map[Joueur2.getY()][Joueur2.getX()+1] != 2) && (Plateau_1.map[Joueur2.getY()][Joueur2.getX()+1] != 4))
			{			
				Joueur2.DeplacerDroite();
			}
			if(StdDraw.isKeyPressed(90) && (Plateau_1.map[Joueur2.getY()-1][Joueur2.getX()] != 0) && (Plateau_1.map[Joueur2.getY() - 1][Joueur2.getX()] != 2) && (Plateau_1.map[Joueur2.getY()-1][Joueur2.getX()] != 4))
			{
				Joueur2.DeplacerHaut();
			}
			if(StdDraw.isKeyPressed(83) && (Plateau_1.map[Joueur2.getY()+1][Joueur2.getX()] != 0) && (Plateau_1.map[Joueur2.getY() + 1][Joueur2.getX()] != 2) && (Plateau_1.map[Joueur2.getY()+1][Joueur2.getX()] != 4))
			{
				Joueur2.DeplacerBas();
			}
			if(StdDraw.isKeyPressed(81) && (Plateau_1.map[Joueur2.getY()][Joueur2.getX()-1] != 0) && (Plateau_1.map[Joueur2.getY()][Joueur2.getX()-1] != 2) && (Plateau_1.map[Joueur2.getY()][Joueur2.getX()-1] != 4))
			{
				Joueur2.DeplacerGauche();
			}
			
			if( (StdDraw.isKeyPressed(32)) && (Plateau_1.map[Joueur1.getY()][Joueur1.getX()] != 3) && (Joueur1.getNbBombe() > 0) ) // espace //
			{
				//Bombe bombe = new Bombe(Joueur1.getX(),Joueur1.getY()/*, Joueur1*/);
				Plateau_1.map[Joueur1.getY()][Joueur1.getX()] = 3;
				Joueur1.setNbBombe(Joueur1.getNbBombe() - 1);
				//bombe.Affiche_bomb(Joueur1.getX(), Joueur1.getY());
				Joueur1.PoserBombe();
			}
			
			// � faire au propre plus tard //
			int[] coordonneesExplosion = Joueur1.CompteARebourd();
			if(coordonneesExplosion[0] != -1)
			{
				Plateau_1.map[coordonneesExplosion[1]][coordonneesExplosion[0]] = 1;
			}
			
			
			
			StdDraw.show();
			StdDraw.pause(50);
		}
		
		
		
	}
}