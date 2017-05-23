import edu.princeton.cs.introcs.StdDraw;

public class Bombe {
	private int x;
	private int y;
	private int delai = 25;
	private int portee = 3;
	private Flamme[] listeFlamme = new Flamme[41];
	//private Personnage joueur;
	
	public Bombe(int x, int y)
	{
		this.x = x;
		this.y = y;
		//this.joueur = joueur;
	}
	
	

	public Flamme[] getListeFlamme() {
		return listeFlamme;
	}



	public void setListeFlamme(Flamme[] listeFlamme) {
		this.listeFlamme = listeFlamme;
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	/*public Personnage getJoueur() {
		return joueur;
	}

	public void setJoueur(Personnage joueur) {
		this.joueur = joueur;
	}*/
	
	public void Affiche_bomb(int x, int y){
		StdDraw.picture(50*(x)+25, y*40+37, "Grass Block 2.png",50,85);
		StdDraw.picture(50*(x)+25, y*40+37, "Bomb.png",50,85);
	}
	
	public int[] retourCoordonnee()
	{
		int[] resultat = {this.x, this.y};
		return resultat;
	}
	
	
	public void exploserBombe(Plateau Plateau_1, Personnage Joueur1, Personnage Joueur2)
	{
		if(x != -1)
		{
			
			Plateau_1.getMap()[y][x] = 5;
			listeFlamme[0] = new Flamme(x,y);
			int compteur = 1; // compte le nombre de flamme pour la listeFlamme //
			
			///Destruction des environs de la bombe///
			int gauche = 0;
			int droite = 0;
			int haut = 0;
			int bas = 0;
			for(int r = 1; r <= portee; r++)
			{
				// Flammes du bas //
				if(y + r < 16)
				{
					if(Plateau_1.getMap()[y+r][x] == 4) // Si l'explosion rencontre un mur incassable : arrêt immédiat
					{
						bas = 1;
					}
					else if(Plateau_1.getMap()[y+r][x] == 3)
					{
						Plateau_1.getMap()[y+r][x] = 5;
						listeFlamme[compteur] = new Flamme(x,y+r);
						compteur += 1;
						if(Joueur1.identificationBombe(x, y+r).x != -1)
						{
							Joueur1.identificationBombe(x, y+r).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
						else if(Joueur2.identificationBombe(x, y+r).x != -1)
						{
							Joueur2.identificationBombe(x, y+r).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
					}
					else if((Plateau_1.getMap()[y+r][x] == 2) && (bas == 0))
					{
						Plateau_1.getMap()[y+r][x] = 5;
						listeFlamme[compteur] = new Flamme(x,y+r);
						compteur += 1;
						bas = 1;
					}
					
					else if(bas == 0)
					{
						Plateau_1.getMap()[y+r][x] = 5;
						listeFlamme[compteur] = new Flamme(x,y+r);
						compteur += 1;
					}	
				}
				// Flamme du haut //
				if(y - r > 0)
				{
					if(Plateau_1.getMap()[y-r][x] == 4)
					{
						haut = 1;
					}
					else if((Plateau_1.getMap()[y-r][x] == 2) && (haut == 0))
					{
						Plateau_1.getMap()[y-r][x] = 5;
						listeFlamme[compteur] = new Flamme(x,y-r);
						compteur += 1;
						haut = 1;
					}
					else if(Plateau_1.getMap()[y-r][x] == 3)
					{
						Plateau_1.getMap()[y-r][x] = 5;
						listeFlamme[compteur] = new Flamme(x,y-r);
						compteur += 1;
						if(Joueur1.identificationBombe(x, y-r).x != -1)
						{
							Joueur1.identificationBombe(x, y-r).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
						else if(Joueur2.identificationBombe(x, y-r).x != -1)
						{
							Joueur2.identificationBombe(x, y-r).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
					}
					else if(haut == 0)
					{
						Plateau_1.getMap()[y-r][x] = 5;
						listeFlamme[compteur] = new Flamme(x,y-r);
						compteur += 1;
					}
					
					
				}
				// Flammes de droite //
				if(x + r < 20)
				{
					if(Plateau_1.getMap()[y][x+r] == 4)
					{
						droite = 1;
					}
					else if((Plateau_1.getMap()[y][x+r] == 2) && droite == 0)
					{
						Plateau_1.getMap()[y][x+r] = 5;
						listeFlamme[compteur] = new Flamme(x+r,y);
						compteur += 1;
						droite = 1;
					}
					else if(Plateau_1.getMap()[y][x+r] == 3)
					{
						Plateau_1.getMap()[y][x+r] = 5;
						listeFlamme[compteur] = new Flamme(x+r,y);
						compteur += 1;
						if(Joueur1.identificationBombe(x+r, y).x != -1)
						{
							Joueur1.identificationBombe(x+r, y).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
						else if(Joueur2.identificationBombe(x+r, y).x != -1)
						{
							Joueur2.identificationBombe(x+r, y).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
					}
					else if(droite == 0)
					{
						Plateau_1.getMap()[y][x+r] = 5;
						listeFlamme[compteur] = new Flamme(x+r,y);
						compteur += 1;
					}	
				}
				// Flamme du gauche //
				if(x - r > 0)
				{
					if(Plateau_1.getMap()[y][x-r] == 4)
					{
						gauche = 1;
					}
					else if((Plateau_1.getMap()[y][x-r] == 2) && gauche == 0)
					{
						Plateau_1.getMap()[y][x-r] = 5;
						listeFlamme[compteur] = new Flamme(x-r,y);
						compteur += 1;
						gauche = 1;	
					}
					else if(Plateau_1.getMap()[y][x-r] == 3)
					{
						Plateau_1.getMap()[y][x-r] = 5;
						listeFlamme[compteur] = new Flamme(x-r,y);
						compteur += 1;
						if(Joueur1.identificationBombe(x-r, y).x != -1)
						{
							Joueur1.identificationBombe(x-r, y).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
						else if(Joueur2.identificationBombe(x-r, y).x != -1)
						{
							Joueur2.identificationBombe(x-r, y).exploserBombe(Plateau_1, Joueur1, Joueur2);
						}
					}
					else if(gauche == 0)
					{
						Plateau_1.getMap()[y][x-r] = 5;
						listeFlamme[compteur] = new Flamme(x-r,y);
						compteur += 1;
					}
					
					
				}
				
			}
			
		}
	}
}
