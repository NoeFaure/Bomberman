import java.awt.Font;

import edu.princeton.cs.introcs.StdDraw;

public class Bombe {
	private int x;
	private int y;
	private long Moment_crea = System.currentTimeMillis();
	private long delai = 5000;
	private Flamme[] listeFlamme = new Flamme[41];
	private boolean Explose = false;
	private boolean Line = false;
	private String orientation;
	//private Personnage joueur;
	
	/// Constructeur ///
	public Bombe(int x, int y)
	{
		this.x = x;
		this.y = y;
		//this.joueur = joueur;
	}
	
	public Bombe(int x, int y, String orientation)
	{
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	public Bombe(int x, int y, boolean line)
	{
		this.x = x;
		this.y = y;
		this.Line = line;
	}
	
	/// Setters and Getters ///
	

	public boolean isLine() {
		return Line;
	}

	public void setLine(boolean line) {
		Line = line;
	}
	
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public boolean isExplose() 
	{
		return Explose;
	}

	public long getMoment_crea() {
		return Moment_crea;
	}

	public void setMoment_crea(long moment_crea) {
		Moment_crea = moment_crea;
	}

	public void setExplose(boolean aExplose) 
	{
		this.Explose = aExplose;
	}

	public  Flamme[] getListeFlamme() 
	{
		return listeFlamme;
	}

	public void setListeFlamme(Flamme[] listeFlamme) 
	{
		this.listeFlamme = listeFlamme;
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public long getDelai() 
	{
		return delai;
	}

	public void setDelai(long delai) 
	{
		this.delai = delai;
	}

	/*public int getPortee() 
	{
		return portee;
	}

	public void setPortee(int portee) 
	{
		this.portee = portee;
	}*/

	/*public Personnage getJoueur() 
	{
		return joueur;
	}

	public void setJoueur(Personnage joueur) 
	{
		this.joueur = joueur;
	}*/
	
	/// Fonctions ///
	public void Affiche_bomb(int x, int y)
	{
		StdDraw.picture(50*(x)+25, y*40+37, "Images/Bloc/Grass Block 2.png",50,85);
		StdDraw.picture(50*(x)+25, y*40+37, "Images/Bonus/Bomb.png",50,85);
	}
	
	public int[] retourCoordonnee()
	{
		int[] resultat = {this.x, this.y};
		return resultat;
	}
	
	//test
	public void Affiche_delai(){
		Font font_2 = new Font("Arial", Font.BOLD, 10);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setFont(font_2);
		
		StdDraw.text(x*50+23,y*40+37, Long.toString((5000 - delai)/1000) + "." + Long.toString((5000 - delai)/100 - ((5000 - delai)/1000)*10));
		
	}
	public void exploserBombe(Plateau Plateau_1, Personnage Joueur1, Personnage Joueur2)
	{
		//Joue la musique
		Musique.JouerMusique("Musique/Explosion.wav");
		Personnage Joueur = Joueur1;
		// Verifie a qui appartient la bombe pour lui en redonner une //
		if(Joueur1.identificationBombe(x, y).x != -1) // Si la bombe appartient au joueur1
		{
			if(Joueur1.identificationBombe(x, y).Line == false)
			{
				Joueur1.setNbBombe(Joueur1.getNbBombe() + 1);
			}
			int positionListeJ1 = Joueur1.positionBombe(x,y);
			Joueur1.getListeBombe()[positionListeJ1].setExplose(true);
			//System.out.println(" +1 ! " + x + " " + y);
			Joueur = Joueur1;
		}
		else if(Joueur2.identificationBombe(x, y).x != -1) // Si la bombe appartient au joueur2
		{
			if(Joueur2.identificationBombe(x, y).Line == false)
			{
				Joueur2.setNbBombe(Joueur2.getNbBombe() + 1);
			}
			int positionListeJ2 = Joueur2.positionBombe(x,y);
			Joueur2.getListeBombe()[positionListeJ2].setExplose(true);
			Joueur = Joueur2;
		}
		
		Plateau_1.getMap()[y][x] = 5;
		listeFlamme[0] = new Flamme(x,y,false,false);
		int compteur = 1; // compte le nombre de flamme pour la listeFlamme //
		
		///Destruction des environs de la bombe///
		int gauche = 0; // Permet de verifier si la flamme s'arrete � gauche //
		int droite = 0; // Permet de verifier si la flamme s'arrete � droite //
		int haut = 0; // Permet de verifier si la flamme s'arrete en haut //
		int bas = 0; // Permet de verifier si la flamme s'arrete en bas //
		
		// Creation des flammes de la bombe qui explose //
		for(int r = 1; r <= Joueur.getPortee() ; r++)
		{
			// Flammes du bas //
			if(y + r < 16) // on verifie que la flamme est dans les limites du terrain //
			{
				if(Plateau_1.getMap()[y+r][x] == 4) // Si l'explosion rencontre un mur incassable : arr�t imm�diat
				{
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						bas = 1;
					}
				}
				else if(Plateau_1.getMap()[y+r][x] == 3 && (bas == 0)) // Si l'explosion rencontre une autre bombe //
				{
					Plateau_1.getMap()[y+r][x] = 5;
					listeFlamme[compteur] = new Flamme(x,y+r,false,false); // Ajout de flammes //
					compteur += 1;
					bas = 1;
					if(Joueur1.identificationBombe(x, y+r).x != -1) // On identifie si la bombe touch�e appartient au joueur 1 ou au joueur 2 //
					{
						Joueur1.identificationBombe(x, y+r).exploserBombe(Plateau_1, Joueur1, Joueur2); // On fait exploser la bombe rencontree //
					}
					else if(Joueur2.identificationBombe(x, y+r).x != -1)
					{
						Joueur2.identificationBombe(x, y+r).exploserBombe(Plateau_1, Joueur1, Joueur2); // On fait exploser la bombe rencontree //
					}
				}
				else if((Plateau_1.getMap()[y+r][x] == 2) && (bas == 0)) // Si l'explosion rencontre un bloc cassable //
				{
					Plateau_1.getMap()[y+r][x] = 5; // On detruit le bloc cassable //
					listeFlamme[compteur] = new Flamme(x,y+r,true,false);
					compteur += 1;
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						bas = 1;
					}
				}
				else if(Plateau_1.getMap()[y+r][x] == 6 && (bas == 0)) //Si la flamme rencontre un bonus
				{
					Plateau_1.detruitBonus(x, y+r);
					Plateau_1.getMap()[y+r][x] = 5; // On detruit le bloc cassable //
					listeFlamme[compteur] = new Flamme(x,y+r,false,true);
					compteur += 1;
				}
				
				else if(bas == 0) // Si la flamme ne rencontre que de l'herbe
				{
					Plateau_1.getMap()[y+r][x] = 5;
					listeFlamme[compteur] = new Flamme(x,y+r,false, false);
					compteur += 1;
				}	
			}
			// Flamme du haut //
			if(y - r > 0) // On verifie que la flamme est dans les limites du terrain //
			{
				if(Plateau_1.getMap()[y-r][x] == 4) // Si la flamme rencontre un bloc incassable
				{
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						haut = 1;
					}
				}
				else if((Plateau_1.getMap()[y-r][x] == 2) && (haut == 0)) // Si la flamme rencontre un bloc cassable
				{
					Plateau_1.getMap()[y-r][x] = 5;
					listeFlamme[compteur] = new Flamme(x,y-r,true,false);
					compteur += 1;
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						haut = 1;
					}
				}
				else if(Plateau_1.getMap()[y-r][x] == 3 && (haut == 0)) // Si la flamme rencontre une autre bombe 
				{
					Plateau_1.getMap()[y-r][x] = 5;
					listeFlamme[compteur] = new Flamme(x,y-r,false,false);
					compteur += 1;
					haut = 1;
					if(Joueur1.identificationBombe(x, y-r).x != -1) // On identifie si la bombe touch�e appartient au joueur 1 ou au joueur 2 //
					{
						Joueur1.identificationBombe(x, y-r).exploserBombe(Plateau_1, Joueur1, Joueur2); //On fait exploser la bombe rencontree
					}
					else if(Joueur2.identificationBombe(x, y-r).x != -1)
					{
						Joueur2.identificationBombe(x, y-r).exploserBombe(Plateau_1, Joueur1, Joueur2); // On fait exploser la bombe rencontree
					}
				}
				else if(Plateau_1.getMap()[y-r][x] == 6 && (haut == 0)) //Si la flamme rencontre un bonus
				{
					Plateau_1.detruitBonus(x, y-r);
					Plateau_1.getMap()[y-r][x] = 5; // On detruit le bloc cassable //
					listeFlamme[compteur] = new Flamme(x,y-r,false,true);
					compteur += 1;
				}
				else if(haut == 0) // Si la flamme ne rencontre que de l'herbe
				{
					Plateau_1.getMap()[y-r][x] = 5;
					listeFlamme[compteur] = new Flamme(x,y-r,false,false);
					compteur += 1;
				}
			}
			// Flammes de droite //
			if(x + r < 20)
			{
				if(Plateau_1.getMap()[y][x+r] == 4)// Si la flamme rencontre un bloc incassable
				{
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						droite = 1;
					}
				}
				else if((Plateau_1.getMap()[y][x+r] == 2) && droite == 0) // Si la flamme rencontre un bloc cassable
				{
					Plateau_1.getMap()[y][x+r] = 5;
					listeFlamme[compteur] = new Flamme(x+r,y,true,false);
					compteur += 1;
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						droite = 1;
					}
				}
				else if(Plateau_1.getMap()[y][x+r] == 3 && (droite == 0)) // Si la flamme rencontre une autre bombe 
				{
					Plateau_1.getMap()[y][x+r] = 5;
					listeFlamme[compteur] = new Flamme(x+r,y,false,false);
					compteur += 1;
					droite = 1;
					if(Joueur1.identificationBombe(x+r, y).x != -1) // On identifie si la bombe touch�e appartient au joueur 1 ou au joueur 2 //
					{
						Joueur1.identificationBombe(x+r, y).exploserBombe(Plateau_1, Joueur1, Joueur2); // On fait exploser la bombe rencontree
					}
					else if(Joueur2.identificationBombe(x+r, y).x != -1)
					{
						Joueur2.identificationBombe(x+r, y).exploserBombe(Plateau_1, Joueur1, Joueur2); // On fait exploser la bombe rencontree
					}
				}
				else if(Plateau_1.getMap()[y][x+r] == 6 && (droite == 0)) //Si la flamme rencontre un bonus
				{
					Plateau_1.detruitBonus(x+r, y);
					Plateau_1.getMap()[y][x+r] = 5; // On detruit le bloc cassable //
					listeFlamme[compteur] = new Flamme(x+r,y,false,true);
					compteur += 1;
				}
				else if(droite == 0) // Si la flamme ne rencontre que de l'herbe
				{
					Plateau_1.getMap()[y][x+r] = 5;
					listeFlamme[compteur] = new Flamme(x+r,y,false,false);
					compteur += 1;
				}	
			}
			// Flammes de gauche //
			if(x - r > 0) // On verifie que la flamme se trouve dans les limites du terrain
			{
				if(Plateau_1.getMap()[y][x-r] == 4)// Si la flamme rencontre un bloc incassable
				{
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						gauche = 1;
					}
				}
				else if((Plateau_1.getMap()[y][x-r] == 2) && gauche == 0)// Si la flamme rencontre un bloc cassable
				{
					Plateau_1.getMap()[y][x-r] = 5;
					listeFlamme[compteur] = new Flamme(x-r,y,true,false);
					compteur += 1;
					if(Joueur.getListeBonus()[1] == 0) // Si le joueur n a pas la bombe rouge
					{
						gauche = 1;
					}	
				}
				else if(Plateau_1.getMap()[y][x-r] == 3 && (gauche == 0)) // Si la flamme rencontre une autre bombe 
				{
					Plateau_1.getMap()[y][x-r] = 5;
					listeFlamme[compteur] = new Flamme(x-r,y,false,false);
					compteur += 1;
					gauche = 1;
					if(Joueur1.identificationBombe(x-r, y).x != -1) // On identifie si la bombe touch�e appartient au joueur 1 ou au joueur 2 //
					{
						Joueur1.identificationBombe(x-r, y).exploserBombe(Plateau_1, Joueur1, Joueur2); // On fait exploser la bombe rencontree
					}
					else if(Joueur2.identificationBombe(x-r, y).x != -1)
					{
						Joueur2.identificationBombe(x-r, y).exploserBombe(Plateau_1, Joueur1, Joueur2); // On fait exploser la bombe rencontree
					}
				}
				else if(Plateau_1.getMap()[y][x-r] == 6 && (gauche == 0)) //Si la flamme rencontre un bonus
				{
					Plateau_1.detruitBonus(x-r, y);
					Plateau_1.getMap()[y][x-r] = 5; // On detruit le bloc cassable //
					listeFlamme[compteur] = new Flamme(x-r,y,false,true);
					compteur += 1;
				}
				else if(gauche == 0) // Si la flamme ne rencontre que de l'herbe
				{
					Plateau_1.getMap()[y][x-r] = 5;
					listeFlamme[compteur] = new Flamme(x-r,y,false,false);
					compteur += 1;
				}
			}
			
		}
	}
}
