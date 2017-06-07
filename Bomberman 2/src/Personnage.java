import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;

public class Personnage {
	
	private int vie = 3;
	private float vitesse = 0.25f;
	private int nbBombe = 3;
	private int portee = 3;
	private float x;
	private float y;
	private Bombe[] listeBombe = new Bombe[30];
	private int[] listeBonus = {0,0,0,0,0,0,0,0};
	private String Skin = "Images/Skin/Skin 404.png";
	private String Orientation = "Bas";
	
	/// Constructeur ///
	public Personnage(int vie, int vitesse, int nbBombe, int x, int y,String Skin) 
	{
		this.vie = vie;
		this.vitesse = vitesse;
		this.nbBombe = nbBombe;
		this.x = x;
		this.y = y;
		this.Skin = Skin;
	}
	
	public Personnage(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/// Setters and Getters ///
	public String getOrientation() 
	{
		return Orientation;
	}

	public void setOrientation(String orientation) 
	{
		Orientation = orientation;
	}

	
	
	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public int[] getListeBonus() 
	{
		return listeBonus;
	}

	public void setListeBonus(int[] listeBonus) 
	{
		this.listeBonus = listeBonus;
	}
	
	public String getSkin() 
	{
		return Skin;
	}

	public void setSkin(String skin) 
	{
		Skin = skin;
	}

	public Bombe[] getListeBombe() 
	{
		return listeBombe;
	}

	public void setListeBombe(Bombe[] listeBombe) 
	{
		this.listeBombe = listeBombe;
	}
	
	public int getVie() 
	{
		return vie;
	}
	
	public void setVie(int vie) 
	{
		this.vie = vie;
	}
	
	public float getVitesse() 
	{
		return vitesse;
	}
	
	public void setVitesse(float vitesse) 
	{
		this.vitesse = vitesse;
	}
	
	public int getNbBombe() 
	{
		return nbBombe;
	}
	
	public void setNbBombe(int nbBombe) 
	{
		this.nbBombe = nbBombe;
	}
	
	public float getX() 
	{
		return x;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public float getY() 
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	/// Methodes ///

	public void Affiche_perso(String texture)
	{
		
		if (texture == "Images/Skin/Bomberman Perso 1.png")
		{
			if(Orientation == "bas")
			{
				StdDraw.picture(50*x+25, 40*y+17, "Images/Skin/Bomberman Perso 1.png",50,85);
			}
			else if(Orientation == "haut")
			{
				StdDraw.picture(50*x+25, 40*y+17, "Images/Skin/Bomberman Perso 1 dos.png",50,85);
			}
			else if(Orientation == "droite")
			{
				StdDraw.picture(50*x+25, 40*y+17, "Images/Skin/Bomberman Perso 1 droite.png",50,85);
			}
			else if(Orientation == "gauche")
			{
				StdDraw.picture(50*x+25, 40*y+17, "Images/Skin/Bomberman Perso 1 gauche.png",50,85);
			}
		}
		else
		{
			StdDraw.picture(50*x+25, 40*y+17, texture,50,85);
		}
	}
	
	public void PoserBombe(Plateau Plateau_1) 
	{
		
			Plateau_1.map[Math.round(y)][Math.round(x)] = 3;
			nbBombe -= 1;
		
			int nbBombeMax = 30;
			int assigne = 0;
			for(int i = 0; i < nbBombeMax; i++)
			{
				if(this.listeBombe[i] == null && assigne == 0) // Verifie qu'un emplacement pour bombe est dispo
				{
					Bombe bombe = new Bombe(Math.round(this.x), Math.round(this.y));
					this.listeBombe[i] = bombe;
					assigne = 1;
				}
			}
	}
	
	public void PoserBombeLine(Plateau Plateau_1, int x, int y) 
	{
		
			Plateau_1.map[y][x] = 3;
		
			int nbBombeMax = 30;
			int assigne = 0;
			for(int i = 0; i < nbBombeMax; i++)
			{
				if(this.listeBombe[i] == null && assigne == 0) // Verifie qu'un emplacement pour bombe est dispo
				{
					System.out.println(i);
					Bombe bombe = new Bombe(x, y,true);
					this.listeBombe[i] = bombe;
					assigne = 1;
				}
			}
	}
	
	public void PoserBombeRebond(Plateau Plateau_1) 
	{
		
			Plateau_1.map[Math.round(y)][Math.round(x)] = 3;
		
			int nbBombeMax = 30;
			int assigne = 0;
			for(int i = 0; i < nbBombeMax; i++)
			{
				if(this.listeBombe[i] == null && assigne == 0) // Verifie qu'un emplacement pour bombe est dispo
				{
					System.out.println(i);
					Bombe bombe = new Bombe(Math.round(y), Math.round(x), this.Orientation);
					this.listeBombe[i] = bombe;
					assigne = 1;
				}
			}
	}
	public void CompteARebourd(Plateau Plateau_1, Personnage Joueur1, Personnage Joueur2) //Renvoi les coordonnees d'une bombe qui explose
	{
		Bombe bombe = new Bombe(-1,-1);
		int nbBombeMax = 30;
		for(int i = 0; i < nbBombeMax; i++)
		{
			if(this.listeBombe[i] != null)
			{
				this.listeBombe[i].setDelai(System.currentTimeMillis() - this.listeBombe[i].getMoment_crea());
				if(this.listeBombe[i].getDelai() > 5000 && this.listeBombe[i].isExplose() == false)
				{
					this.listeBombe[i].setExplose(true);
					bombe = this.listeBombe[i];
					//this.listeBombe[i] = null;
					//this.nbBombe += 1;
					bombe.exploserBombe(Plateau_1, Joueur1, Joueur2);
					//System.out.println("La bombe explose a l'emplacement : " + bombe.getX() + " " + bombe.getY());
				}
			}
		}
		/*if(bombe.getX() != -1)
		{
			bombe.exploserBombe(Plateau_1, Joueur1, Joueur2);
		}*/
		
	}
	
	public void EnleverFlamme(Plateau Plateau_1)
	{
		int nbBombeMax = 30;
		for(int i = 0; i < nbBombeMax; i++)
		{
			Bombe bombei = listeBombe[i];
			if(bombei != null)
			{
				int tailleFlamme = bombei.getListeFlamme().length; // le nombre de case dans listeFlamme //
				for(int j = 0; j < tailleFlamme; j++)
				{
					if(bombei.getListeFlamme()[j] != null)
					{
						boolean isDissipe = bombei.getListeFlamme()[j].Retirer_Flamme(Plateau_1); //retirerflamme renvoie un boolean
						if(isDissipe == true)
						{
							listeBombe[i] = null;
						}
					}	
				}
			}
		}
	}
	
	/// Deplacement du joueur 1 ///
	public void DeplacerJoueur1(Plateau Plateau_1)
	{
		if(StdDraw.isKeyPressed(68) && (Plateau_1.map[Math.round(y)][Math.round(x + vitesse)] != 0) && (Plateau_1.map[Math.round(y)][Math.round(x + vitesse)] != 3)  && (Plateau_1.map[Math.round(y)][Math.round(x + vitesse)] != 2) && (Plateau_1.map[Math.round(y)][Math.round(x + vitesse)] != 4) && (Plateau_1.map[(int)(y)][(int)(x + vitesse)] != 2) && (Plateau_1.map[(int)(y)][(int)(x + vitesse)] != 4))
		{			
			x += vitesse;
			Orientation = "droite";
		}
		if(StdDraw.isKeyPressed(90) && (Plateau_1.map[Math.round(y - vitesse)][Math.round(x)] != 0) && Plateau_1.map[Math.round(y - vitesse)][Math.round(x)] != 3
				/*&& (Plateau_1.map[Math.round(y - vitesse)][Math.round(x)] != 2)*/ /*&& (Plateau_1.map[Math.round(y - vitesse)][Math.round(x)] != 4)*/ && (Plateau_1.map[(int)(y - vitesse)][Math.round(x)] != 4) && (Plateau_1.map[(int)(y - vitesse)][Math.round(x)] != 2) && (Plateau_1.map[(int)(y - vitesse)][(int)(x)] != 4) && (Plateau_1.map[(int)(y - vitesse)][(int)(x)] != 2))
		{
			y -= vitesse;
			Orientation = "haut";
		}
		if(StdDraw.isKeyPressed(83) && (Plateau_1.map[Math.round(y + vitesse)][Math.round(x)] != 0) && (Plateau_1.map[Math.round(y + vitesse)][Math.round(x)] != 3) && (Plateau_1.map[(int)(y + vitesse)][(int)(x)] != 2) && (Plateau_1.map[(int)(y + vitesse)][(int)(x)] != 4) && (Plateau_1.map[Math.round(y + vitesse)][Math.round(x)] != 2) && (Plateau_1.map[Math.round(y + vitesse)][Math.round(x)] != 4))
		{
			y += vitesse;
			Orientation = "bas";
		}
		if(StdDraw.isKeyPressed(81) && (Plateau_1.map[Math.round(y)][Math.round(x - vitesse - 0.2f)] != 0) && (Plateau_1.map[Math.round(y)][Math.round(x - vitesse - 0.2f)] != 3) && (Plateau_1.map[Math.round(y)][Math.round(x - vitesse - 0.2f)] != 2) && (Plateau_1.map[Math.round(y)][Math.round(x - vitesse - 0.2f)] != 4)/* && (Plateau_1.map[(int)(y)][(int)(x - vitesse + 0.25f)] != 2) && (Plateau_1.map[(int)(y)][(int)(x - vitesse + 0.25f)] != 4) /*&& (Plateau_1.map[(int)(y)][(int)(x - vitesse/2)] != 0)*/)
		{
			x -= vitesse;
			Orientation = "gauche";
		}
	}
	
	/// Deplacement du joueur 2 ///
	
	public void DeplacerJoueur2(Plateau Plateau_1)
	{
		if(StdDraw.isKeyPressed(39) && (Plateau_1.map[Math.round(y)][Math.round(x + vitesse)] != 0) && (Plateau_1.map[Math.round(y)][Math.round(x + vitesse)] != 2) && (Plateau_1.map[Math.round(y)][Math.round(x + vitesse)] != 4) && (Plateau_1.map[(int)(y)][(int)(x + vitesse)] != 2) && (Plateau_1.map[(int)(y)][(int)(x + vitesse)] != 4))
		{			
			x += vitesse;
			Orientation = "droite";
		}
		if(StdDraw.isKeyPressed(38) && (Plateau_1.map[Math.round(y - vitesse)][Math.round(x)] != 0)
				/*&& (Plateau_1.map[Math.round(y - vitesse)][Math.round(x)] != 2)*/ /*&& (Plateau_1.map[Math.round(y - vitesse)][Math.round(x)] != 4)*/ && (Plateau_1.map[(int)(y - vitesse)][Math.round(x)] != 4) && (Plateau_1.map[(int)(y - vitesse)][Math.round(x)] != 2) && (Plateau_1.map[(int)(y - vitesse)][(int)(x)] != 4) && (Plateau_1.map[(int)(y - vitesse)][(int)(x)] != 2))
		{
			y -= vitesse;
			Orientation = "haut";
		}
		if(StdDraw.isKeyPressed(40) && (Plateau_1.map[Math.round(y + vitesse)][Math.round(x)] != 0) && (Plateau_1.map[(int)(y + vitesse)][(int)(x)] != 2) && (Plateau_1.map[(int)(y + vitesse)][(int)(x)] != 4) && (Plateau_1.map[Math.round(y + vitesse)][Math.round(x)] != 2) && (Plateau_1.map[Math.round(y + vitesse)][Math.round(x)] != 4))
		{
			y += vitesse;
			Orientation = "bas";
		}
		if(StdDraw.isKeyPressed(37) && (Plateau_1.map[Math.round(y)][Math.round(x - vitesse - 0.2f)] != 0) && (Plateau_1.map[Math.round(y)][Math.round(x - vitesse - 0.2f)] != 2) && (Plateau_1.map[Math.round(y)][Math.round(x - vitesse - 0.2f)] != 4)/* && (Plateau_1.map[(int)(y)][(int)(x - vitesse + 0.25f)] != 2) && (Plateau_1.map[(int)(y)][(int)(x - vitesse + 0.25f)] != 4) /*&& (Plateau_1.map[(int)(y)][(int)(x - vitesse/2)] != 0)*/)
		{
			x -= vitesse;
			Orientation = "gauche";
		}
	}
	
	/// Affiche Bonus ///
	public void Affiche_bonus_Joueur1()
	{
		
		// Flamme Jaune = 1 en position 0
		if(listeBonus[0] == 1)
		{
		StdDraw.picture(1083,298, "Images/Bonus/Flamme Jaune.png");
		}
		
		// Flamme Bleue = 2 en position 0
		if(listeBonus[0] == 2)
		{
		StdDraw.picture(1083,298, "Images/Bonus/Flamme Bleue.png");
		}
		
		// Flamme Verte = 3 en position 0
		if(listeBonus[0] == 3)
		{
		StdDraw.picture(1083,298, "Images/Bonus/Flamme Verte.png");
		}
		
		// Flamme Rouge = 4 en position 0
		if(listeBonus[0] == 4)
		{
		StdDraw.picture(1083,298, "Images/Bonus/Flamme Rouge.png");
		}
		
		//Bombe Rouge
		if(listeBonus[1] == 1)
		{
		StdDraw.picture(1128,298, "Images/Bonus/Bombe Rouge.png");
		}
		
		//Speed Up
		if(listeBonus[2] == 1)
		{
		StdDraw.picture(1173,298, "Images/Bonus/Speed Up.png");
		}
		
		//Slow down
		if(listeBonus[3] == 1)
		{
		StdDraw.picture(1217,298, "Images/Bonus/Slow Down.png");
		}
		
		// Mine
		if(listeBonus[4] == 1)
		{
		StdDraw.picture(1083,343, "Images/Bonus/Mine.png");
		}
				
		//Rebond
		if(listeBonus[5] == 1)
		{
		StdDraw.picture(1128,343, "Images/Bonus/Rebond.png");
		}
				
		//Line
		if(listeBonus[6] == 1)
		{
		StdDraw.picture(1173,343, "Images/Bonus/Line.png");
		}
				
		//Shield
		if(listeBonus[7] == 1)
		{
		StdDraw.picture(1217,343, "Images/Bonus/Shield.png");
		}
		// Nb de vie
		Font font = new Font("Arial", Font.BOLD, 30);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(font);
		
		StdDraw.text(1213, 249, Integer.toString((vie)));
		
		// Nb de bombes
		StdDraw.text(1125, 249, Integer.toString((nbBombe)));
	}
	
	public void Affiche_bonus_Joueur2()
	{
		// Flamme Jaune = 1 en position 0
		if(listeBonus[0] == 1)
		{
		StdDraw.picture(1084,502, "Images/Bonus/Flamme Jaune.png");
		}
		
		// Flamme Bleue = 2 en position 0
		if(listeBonus[0] == 2)
		{
		StdDraw.picture(1084,502, "Images/Bonus/Flamme Bleue.png");
		}
		
		// Flamme Verte = 3 en position 0
		if(listeBonus[0] == 3)
		{
		StdDraw.picture(1084,502, "Images/Bonus/Flamme Verte.png");
		}
		
		// Flamme Rouge = 4 en position 0
		if(listeBonus[0] == 4)
		{
		StdDraw.picture(1084,502, "Images/Bonus/Flamme Rouge.png");
		}
		
		//Bombe Rouge
		if(listeBonus[1] == 1)
		{
		StdDraw.picture(1128,502, "Images/Bonus/Bombe Rouge.png");
		}
		
		//Speed Up
		if(listeBonus[2] == 1)
		{
		StdDraw.picture(1173,502, "Images/Bonus/Speed Up.png");
		}
		
		//Slow down
		if(listeBonus[3] == 1)
		{
		StdDraw.picture(1217,502, "Images/Bonus/Slow Down.png");
		}
		
		// Mine
		if(listeBonus[4] == 1)
		{
		StdDraw.picture(1083,547, "Images/Bonus/Mine.png");
		}
				
		//Rebond
		if(listeBonus[5] == 1)
		{
		StdDraw.picture(1128,547, "Images/Bonus/Rebond.png");
		}
				
		//Line
		if(listeBonus[6] == 1)
		{
		StdDraw.picture(1173,547, "Images/Bonus/Line.png");
		}
				
		//Shield
		if(listeBonus[7] == 1)
		{
		StdDraw.picture(1217,547, "Images/Bonus/Shield.png");
		}
		// Nb de vie
		Font font = new Font("Arial", Font.BOLD, 30);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(font);
		
		StdDraw.text(1213, 454, Integer.toString((vie)));
		
		// Nb de bombes
		StdDraw.text(1125, 454, Integer.toString((nbBombe)));
	}
	
	/// Permet l'identification d'une bombe touch�e par une flamme ///
	
	public Bombe identificationBombe(int xBombe, int yBombe)
	{
		Bombe bombe = new Bombe(-1,-1);
		int nbBombeMax = 30;
		for(int i = 0; i < nbBombeMax; i++)
		{
			if(listeBombe[i] != null)
			{
				if((listeBombe[i].getX() == xBombe) && (listeBombe[i].getY() == yBombe))
				{
					return listeBombe[i];
				}
			}	
		}
		return bombe;
	}
	
	public int positionBombe(int xBombe, int yBombe)
	{
		int nbBombeMax = 30;
		for(int i = 0; i < nbBombeMax; i++)
		{
			if(listeBombe[i] != null)
			{
				if((listeBombe[i].getX() == xBombe) && (listeBombe[i].getY() == yBombe))
				{
					return i;
				}
			}	
		}
		return -1;
	}
	
	public void line(Plateau Plateau_1)
	{
		int x = Math.round(this.getX());
		int y = Math.round(this.getY());
		// Bonus ligne de bombes
		if(this.getOrientation() == "bas")
		{
			int i = 1;
			while(Plateau_1.getMap()[(int)(y + i)][x] == 1)
			{
				this.PoserBombeLine(Plateau_1, x, y + i );
				i++;
			}
		}
		if(this.getOrientation() == "haut")
		{
			int i = 1;
			while(Plateau_1.getMap()[(int)(y - i)][x] == 1)
			{
				this.PoserBombeLine(Plateau_1, x, y - i );
				i++;
			}
		}
		if(this.getOrientation() == "gauche")
		{
			int i = 1;
			while(Plateau_1.getMap()[y][(int)(x-i)] == 1)
			{
				this.PoserBombeLine(Plateau_1, x-i, y);
				i++;
			}
		}
		if(this.getOrientation() == "droite")
		{
			int i = 1;
			while(Plateau_1.getMap()[(int)(y)][x+i] == 1)
			{
				this.PoserBombeLine(Plateau_1, x+i,y);
				i++;
			}
		}
	}
	
	public void majRebond(Plateau Plateau_1)
	{
		int x = Math.round(this.getX());
		int y = Math.round(this.getY());
		this.PoserBombeRebond(Plateau_1);
		int nbBombeMax = 30;
		Bombe bombe = null;
		int vitesseb = 1;
		for(int i = 0; i < nbBombeMax; i++)
		{
			if(this.listeBombe[i] != null && (this.listeBombe[i].getOrientation() == "bas" || this.listeBombe[i].getOrientation() == "haut" || this.listeBombe[i].getOrientation() == "gauche" || this.listeBombe[i].getOrientation() == "droite")) // Verifie qu'un emplacement pour bombe est dispo
			{
				bombe = this.listeBombe[i];
			}
		}
		
		if(bombe.getOrientation() == "bas")
		{
			if(Plateau_1.getMap()[y + vitesseb][x] != 1)
			{
				vitesseb = -vitesseb;
			}
			bombe.setY(bombe.getY() + vitesseb);
			
		}
		if(bombe.getOrientation() == "haut")
		{
			if(Plateau_1.getMap()[y - vitesseb][x] != 1)
			{
				vitesseb = -vitesseb;
			}
			bombe.setY(bombe.getY() - vitesseb);
		}
		if(bombe.getOrientation() == "gauche")
		{
			if(Plateau_1.getMap()[y][x - vitesseb] != 1)
			{
				vitesseb = -vitesseb;
			}
			bombe.setY(bombe.getX() - vitesseb);
		}
		if(bombe.getOrientation() == "droite")
		{
			if(Plateau_1.getMap()[y][x + vitesseb] != 1)
			{
				vitesseb = -vitesseb;
			}
			bombe.setY(bombe.getX() + vitesseb);
		}
		
	}
}


