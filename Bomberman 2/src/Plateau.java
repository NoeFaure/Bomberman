import edu.princeton.cs.introcs.StdDraw;

public class Plateau {

	int [][] map;
	
	//Constructeur
	public Plateau(int [][] map){
		this.map = map;
	}

	public  void Afficher_map(int map [][],Personnage Joueur1,Personnage Joueur2)
	{
		
		// Taille de la map (1050 x 850)
		/*StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(1250,690);
		StdDraw.setXscale(0,1250);
		StdDraw.setYscale(690, 0);*/
		
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(1150,345, "Interface_bomber.png");
		
		for (int i=0;i < map.length; i++)
		{
			for (int j=0;j < map[i].length; j++)
			{
				
				//Enceinte
				if (map[i][j] == 0)
				{
					StdDraw.picture(50*(j)+25, i*40+17, "Stone Block 2.png",50,85);
				}
				
				//Herbe
				if (map[i][j] == 1)
				{
					StdDraw.picture(50*(j)+25, i*40+37, "Grass Block 2.png",50,85);
					
					//Affiche perso
					//Joueur 1
					if(Joueur1.getX() == j && Joueur1.getY() == i){
						Joueur1.Affiche_perso(j, i, "Bomberman Perso 1.png");
						//System.out.println(j+" "+i);
						
					}
					//Joueur 2
					if(Joueur2.getX() == j && Joueur2.getY() == i){
						Joueur1.Affiche_perso(j, i, "Bomberman Perso 2.png");
					}
					
					
					//Gestion de l'ombre
					if (map[i-1][j] == 4 || map[i-1][j] == 2 || map[i-1][j] == 0)
					{
						StdDraw.picture(50*(j)+25, i*40+35, "Shadow North.png",50,85);
					}
				}
				
				//Blocs cassables
				if (map[i][j] == 2)
				{
					StdDraw.picture(50*(j)+25, i*40+17, "Dirt Block 2.png",50,85);
					
				}
				
				//Murs
				if (map[i][j] == 4)
				{
					StdDraw.picture(50*(j)+25, i*40+17, "Wall Block.png",50,85);
					
				}
				// Bombes // // Plus utile ? //
				if (map[i][j] == 3)
				{
					//CODE EN COURS : Bomb1.Affiche_bomb etc ..
					
					//Affiche perso
					//Joueur 1
					if(Joueur1.getX() == j && Joueur1.getY() == i){
						Joueur1.Affiche_perso(j, i, "Bomberman Perso 1.png");
						//System.out.println(j+" "+i);
						
					}
					//Joueur 2
					if(Joueur2.getX() == j && Joueur2.getY() == i){
						Joueur1.Affiche_perso(j, i, "Bomberman.png");
					}
					
					//Gestion de l'ombre
					if (map[i-1][j] == 4 || map[i-1][j] == 2 || map[i-1][j] == 0)
					{
						StdDraw.picture(50*(j)+25, i*40+35, "Shadow North.png",50,85);
					}
					
				}

			} // � mettre � la fin du main
	
		}
	
	}
}