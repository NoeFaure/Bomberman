import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Plateau {

	int [][] map;
	Bonus[] listeBonus = new Bonus[20];
	
	/// Constructeur ///
	public Plateau(int [][] map){
		this.map = map;
	}
	
	/// Setters and Getters ///
	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	/// Fonctions ///
	public  void Afficher_map(int map [][],Personnage Joueur1,Personnage Joueur2)
	{
		
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(1150,345, "Images/Menu/Interface_bomber.png");
		
		for (int i=0;i < map.length; i++)
		{
			for (int j=0;j < map[i].length; j++)
			{
				
				//Enceinte
				if (map[i][j] == 0)
				{
					StdDraw.picture(50*(j)+25, i*40+17, "Images/Bloc/Stone Block 2.png",50,85);
				}
				
				//Herbe
				if (map[i][j] == 1)
				{
					StdDraw.picture(50*(j)+25, i*40+37, "Images/Bloc/Grass Block 2.png",50,85);
					
					//Affiche perso
					//Joueur 1
					if(Joueur1.getX() == j && Joueur1.getY() == i){
						Joueur1.Affiche_perso(j, i, Joueur1.getSkin());
						//System.out.println(j+" "+i);
						
					}
					//Joueur 2
					if(Joueur2.getX() == j && Joueur2.getY() == i){
						Joueur2.Affiche_perso(j, i, Joueur2.getSkin());
					}
					
					
					//Gestion de l'ombre
					if (map[i-1][j] == 4 || map[i-1][j] == 2 || map[i-1][j] == 0)
					{
						StdDraw.picture(50*(j)+25, i*40+35, "Images/Shadow/Shadow North.png",50,85);
					}
				}
				
				//Blocs cassables
				if (map[i][j] == 2)
				{
					StdDraw.picture(50*(j)+25, i*40+17, "Images/Bloc/Dirt Block 2.png",50,85);
					
				}
				
				//Murs
				if (map[i][j] == 4)
				{
					StdDraw.picture(50*(j)+25, i*40+17, "Images/Bloc/Wall Block.png",50,85);
					
				}
				
				
				// Bombes // // Plus utile ? //
				if (map[i][j] == 3)
				{
					StdDraw.picture(50*(j)+25, i*40+37, "Images/Bloc/Grass Block 2.png",50,85);
					StdDraw.picture(50*(j)+25, i*40+37, "Images/Bonus/Bomb.png",50,85);
					
						//Affiche perso
						//Joueur 1
						if(Joueur1.getX() == j && Joueur1.getY() == i){
							Joueur1.Affiche_perso(j, i, Joueur1.getSkin());
							//System.out.println(j+" "+i);
							
						}
						//Joueur 2
						if(Joueur2.getX() == j && Joueur2.getY() == i){
							Joueur2.Affiche_perso(j, i, Joueur2.getSkin());
						}
						
						//Gestion de l'ombre
						if (map[i-1][j] == 4 || map[i-1][j] == 2 || map[i-1][j] == 0)
						{
							StdDraw.picture(50*(j)+25, i*40+35, "Images/Shadow/Shadow North.png",50,85);
						}
					
				}
				
				//Flamme
				if (map[i][j] == 5)
				{
					StdDraw.picture(50*(j)+25, i*40+37, "Images/Bloc/Grass Block 2.png",50,85);
					
					//Affiche perso
					//Joueur 1
					if(Joueur1.getX() == j && Joueur1.getY() == i){
						Joueur1.Affiche_perso(j, i, Joueur1.getSkin());
						//System.out.println(j+" "+i);
						
					}
					//Joueur 2
					if(Joueur2.getX() == j && Joueur2.getY() == i){
						Joueur2.Affiche_perso(j, i, Joueur2.getSkin());
					}
					
					//Gestion de l'ombre
					if (map[i-1][j] == 4 || map[i-1][j] == 2 || map[i-1][j] == 0)
					{
						StdDraw.picture(50*(j)+25, i*40+35, "Images/Shadow/Shadow North.png",50,85);
					}
					
					StdDraw.picture(50*(j)+25, i*40+17, "Images/Bloc/Flamme.png",50,85);
					
				}
				// Bonus
				if (map[i][j] == 6)
				{
					StdDraw.picture(50*(j)+25, i*40+37, "Images/Bloc/Grass Block 2.png",50,85);
					StdDraw.picture(50*(j)+25, i*40+17, "Images/Bonus/Chest.png",50,85);
					
					//Affiche perso
					//Joueur 1
					if(Joueur1.getX() == j && Joueur1.getY() == i){
						Joueur1.Affiche_perso(j, i, Joueur1.getSkin());
						//System.out.println(j+" "+i);
						
					}
					//Joueur 2
					if(Joueur2.getX() == j && Joueur2.getY() == i){
						Joueur2.Affiche_perso(j, i, Joueur2.getSkin());
					}
					
				}
				
				

			}
	
		}
	
	}
	
	public void Verif_Touche(int [][] map, Personnage Joueur1, Personnage Joueur2){
		
		int x1 = Joueur1.getX();
		int y1 = Joueur1.getY();
		
		int x2 = Joueur2.getX();
		int y2 = Joueur2.getY();
		
		for (int i=0;i < map.length; i++)
		{
			for (int j=0;j < map[i].length; j++)
			{
				if(map[i][j] == 5 && j == x1 && i == y1){
					Joueur1.setVie(Joueur1.getVie() - 1);
					Musique.JouerMusique("Musique/Touch.wav");
				}
				
				if(map[i][j] == 5 && j == x2 && i == y2){
					Joueur2.setVie(Joueur2.getVie() - 1);
					Musique.JouerMusique("Musique/Touch.wav");
				}
			}
		}
		
	}
	
	public void Verifie_WIN(Personnage Joueur1, Personnage Joueur2){
		
		int Vie_Joueur1 = Joueur1.getVie();
		int Vie_Joueur2 = Joueur2.getVie();
		boolean boucle = true;
		
		if (Vie_Joueur1 == 0 && Vie_Joueur2 != 0){
			StdDraw.picture(625, 345, "Images/Menu/Player 2 WIN.png");
			StdDraw.picture(625, 345, "Images/Menu/Press Enter.png");
			StdDraw.show();
			
			while(boucle == true){
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
					boucle = false;
					
					Ecran_Titre Ecran_titre_2 = new Ecran_Titre();
					Ecran_titre_2.Affiche_Ecran_Titre(Joueur1,Joueur2);
				}
			}
			
		}
		if (Vie_Joueur2 == 0 && Vie_Joueur1 != 0){
			StdDraw.picture(625, 345, "Images/Menu/Player 1 WIN.png");
			StdDraw.picture(625, 345, "Images/Menu/Press Enter.png");
			StdDraw.show();
			
			while(boucle == true){
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
					boucle = false;
					
					Ecran_Titre Ecran_titre_2 = new Ecran_Titre();
					Ecran_titre_2.Affiche_Ecran_Titre(Joueur1,Joueur2);
				}
			}
			
		}
		if (Vie_Joueur1 == 0 && Vie_Joueur2 == 0){
			StdDraw.picture(625, 345, "Images/Menu/Draw.png");
			StdDraw.picture(625, 345, "Images/Menu/Press Enter.png");
			StdDraw.show();
			
			while(boucle == true){
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
					boucle = false;
					
					Ecran_Titre Ecran_titre_2 = new Ecran_Titre();
					Ecran_titre_2.Affiche_Ecran_Titre(Joueur1,Joueur2);
				}
			}
		}
		
	}
}