import edu.princeton.cs.introcs.StdDraw;

public class Personnage {
	
	private int vie = 3;
	private int vitesse = 1;
	private int nbBombe = 3;
	private int x;
	private int y;
	private Bombe[] listeBombe = new Bombe[10];
	private int[] listeBonus = {0,0,0,0,0,0,0,0};
	
	public int[] getListeBonus() {
		return listeBonus;
	}

	public void setListeBonus(int[] listeBonus) {
		this.listeBonus = listeBonus;
	}

	/// Constructeur ///
	public Personnage(int vie, int vitesse, int nbBombe, int x, int y) 
	{
		this.vie = vie;
		this.vitesse = vitesse;
		this.nbBombe = nbBombe;
		this.x = x;
		this.y = y;
	}
	
	public Bombe[] getListeBombe() {
		return listeBombe;
	}

	public void setListeBombe(Bombe[] listeBombe) {
		this.listeBombe = listeBombe;
	}

	public Personnage(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/// Setters et Getters ///
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public int getNbBombe() {
		return nbBombe;
	}
	public void setNbBombe(int nbBombe) {
		this.nbBombe = nbBombe;
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
	
	/// Methodes ///

	public void Affiche_perso(int x, int y,String texture){
		StdDraw.picture(50*x+25, 40*y+17, texture,50,85);
	}
	
	public void PoserBombe(Plateau Plateau_1) 
	{
		if( (StdDraw.isKeyPressed(32)) && (Plateau_1.map[y][x] != 3) && (nbBombe > 0) ) // espace //
		{
			Plateau_1.map[y][x] = 3;
			nbBombe -= 1;
		
			int nbBombeMax = 10;
			int assigne = 0;
			for(int i = 0; i < nbBombeMax; i++)
			{
				if(this.listeBombe[i] == null && assigne == 0) // Verifie qu'un emplacement pour bombe est dispo
				{
					Bombe bombe = new Bombe(this.x, this.y);
					this.listeBombe[i] = bombe;
					assigne = 1;
				}
			}
		}
	}
	
	public void CompteARebourd(Plateau Plateau_1, Personnage Joueur1, Personnage Joueur2) //Renvoi les coordonnees d'une bombe qui explose
	{
		Bombe bombe = new Bombe(-1,-1);
		int nbBombeMax = 10;
		for(int i = 0; i < nbBombeMax; i++)
		{
			if(this.listeBombe[i] != null)
			{
				this.listeBombe[i].setDelai(this.listeBombe[i].getDelai() - 1);
				if(this.listeBombe[i].getDelai() == 0 && this.listeBombe[i].isExplose() == false)
				{
					this.listeBombe[i].setExplose(true);
					bombe = this.listeBombe[i];
					//this.listeBombe[i] = null;
					//this.nbBombe += 1;
					bombe.exploserBombe(Plateau_1, Joueur1, Joueur2);
					System.out.println("La bombe explose a l'emplacement : " + bombe.getX() + " " + bombe.getY());
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
		int nbBombeMax = 10;
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
						boolean isDissipe = bombei.getListeFlamme()[j].Retirer_Flamme(Plateau_1);
						if(isDissipe == true)
						{
							listeBombe[i] = null;
						}
					}	
				}
			}
			
		}
	}
	
	// Deplacement du joueur 1 //
	public void DeplacerJoueur1(Plateau Plateau_1)
	{
		if(StdDraw.isKeyPressed(39) && (Plateau_1.map[y][x + 1] != 0) && (Plateau_1.map[y][x + 1] != 2) && (Plateau_1.map[y][x + 1] != 4))
		{			
			x += 1;
		}
		if(StdDraw.isKeyPressed(38) && (Plateau_1.map[y - 1][x] != 0) && (Plateau_1.map[y - 1][x] != 2) && (Plateau_1.map[y - 1][x] != 4))
		{
			y -= 1;
		}
		if(StdDraw.isKeyPressed(40)&& (Plateau_1.map[y + 1][x] != 0) && (Plateau_1.map[y + 1][x] != 2) && (Plateau_1.map[y + 1][x] != 4))
		{
			y += 1;
		}
		if(StdDraw.isKeyPressed(37)&& (Plateau_1.map[y][x - 1] != 0) && (Plateau_1.map[y][x - 1] != 2) && (Plateau_1.map[y][x - 1] != 4))
		{
			x -= 1;
		}
	}
	
	// Deplacement du joueur 2 //
	
	public void DeplacerJoueur2(Plateau Plateau_1)
	{
		if(StdDraw.isKeyPressed(68) && (Plateau_1.map[y][x + 1] != 0) && (Plateau_1.map[y][x + 1] != 2) && (Plateau_1.map[y][x + 1] != 4))
		{			
			x += 1;
		}
		if(StdDraw.isKeyPressed(90) && (Plateau_1.map[y - 1][x] != 0) && (Plateau_1.map[y - 1][x] != 2) && (Plateau_1.map[y - 1][x] != 4))
		{
			y -= 1;
		}
		if(StdDraw.isKeyPressed(83)&& (Plateau_1.map[y + 1][x] != 0) && (Plateau_1.map[y + 1][x] != 2) && (Plateau_1.map[y + 1][x] != 4))
		{
			y += 1;
		}
		if(StdDraw.isKeyPressed(81)&& (Plateau_1.map[y][x - 1] != 0) && (Plateau_1.map[y][x - 1] != 2) && (Plateau_1.map[y][x - 1] != 4))
		{
			x -= 1;
		}
	}
	
	
	//Affiche Bonus
	public void Affiche_bonus_Joueur1()
	{
		
		// Flamme Jaune = 1 en position 0
		if(listeBonus[0] == 1){
		StdDraw.picture(1083,298, "Flamme Jaune.png");
		}
		
		// Flamme Bleue = 2 en position 0
		if(listeBonus[0] == 2){
		StdDraw.picture(1083,298, "Flamme Bleue.png");
		}
		
		// Flamme Verte = 3 en position 0
		if(listeBonus[0] == 3){
		StdDraw.picture(1083,298, "Flamme Verte.png");
		}
		
		// Flamme Rouge = 4 en position 0
		if(listeBonus[0] == 4){
		StdDraw.picture(1083,298, "Flamme Rouge.png");
		}
		
		//Bombe Rouge
		if(listeBonus[1] == 1){
		StdDraw.picture(1128,298, "Bombe Rouge.png");
		}
		
		//Speed Up
		if(listeBonus[2] == 1){
		StdDraw.picture(1173,298, "Speed Up.png");
		}
		
		//Slow down
		if(listeBonus[3] == 1){
		StdDraw.picture(1217,298, "Slow Down.png");
		}
		
		// Mine
		if(listeBonus[4] == 1){
		StdDraw.picture(1083,343, "Mine.png");
		}
				
		//Rebond
		if(listeBonus[5] == 1){
		StdDraw.picture(1128,343, "Rebond.png");
		}
				
		//Line
		if(listeBonus[6] == 1){
		StdDraw.picture(1173,343, "Line.png");
		}
				
		//Shield
		if(listeBonus[7] == 1){
		StdDraw.picture(1217,343, "Shield.png");
		}
		// Nb de vie
		StdDraw.text(1213, 249, Integer.toString((vie)));
		
		// Nb de bombes
		StdDraw.text(1125, 249, Integer.toString((nbBombe)));
	}
	
	public void Affiche_bonus_Joueur2()
	{
		
		// Flamme Jaune = 1 en position 0
		if(listeBonus[0] == 1){
		StdDraw.picture(1084,502, "Flamme Jaune.png");
		}
		
		// Flamme Bleue = 2 en position 0
		if(listeBonus[0] == 2){
		StdDraw.picture(1084,502, "Flamme Bleue.png");
		}
		
		// Flamme Verte = 3 en position 0
		if(listeBonus[0] == 3){
		StdDraw.picture(1084,502, "Flamme Verte.png");
		}
		
		// Flamme Rouge = 4 en position 0
		if(listeBonus[0] == 4){
		StdDraw.picture(1084,502, "Flamme Rouge.png");
		}
		
		//Bombe Rouge
		if(listeBonus[1] == 1){
		StdDraw.picture(1128,502, "Bombe Rouge.png");
		}
		
		//Speed Up
		if(listeBonus[2] == 1){
		StdDraw.picture(1173,502, "Speed Up.png");
		}
		
		//Slow down
		if(listeBonus[3] == 1){
		StdDraw.picture(1217,502, "Slow Down.png");
		}
		
		// Mine
		if(listeBonus[4] == 1){
		StdDraw.picture(1083,547, "Mine.png");
		}
				
		//Rebond
		if(listeBonus[5] == 1){
		StdDraw.picture(1128,547, "Rebond.png");
		}
				
		//Line
		if(listeBonus[6] == 1){
		StdDraw.picture(1173,547, "Line.png");
		}
				
		//Shield
		if(listeBonus[7] == 1){
		StdDraw.picture(1217,547, "Shield.png");
		}
		// Nb de vie
		StdDraw.text(1213, 454, Integer.toString((vie)));
		
		// Nb de bombes
		StdDraw.text(1125, 454, Integer.toString((nbBombe)));
	}
	
	// Permet l'identification d'une bombe touch�e par une flamme //
	
	public Bombe identificationBombe(int xBombe, int yBombe)
	{
		Bombe bombe = new Bombe(-1,-1);
		int nbBombeMax = 10;
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
		int nbBombeMax = 10;
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
	
	
}


