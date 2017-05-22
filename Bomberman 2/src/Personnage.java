import edu.princeton.cs.introcs.StdDraw;

public class Personnage {
	
	private int vie = 3;
	private int vitesse = 1;
	private int nbBombe = 3;
	private int x;
	private int y;
	private Bombe[] listeBombe = new Bombe[10];
	private int[] listeBonus = {0,0,0,0,1,0,0,0};
	
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
	
	public void DeplacerDroite()
	{
		this.x += 1;
	}
	
	public void DeplacerGauche()
	{
		this.x -= 1;
	}
	
	public void DeplacerHaut()
	{
		this.y -= 1;
	}
	
	public void DeplacerBas()
	{
		this.y += 1;
	}
	
	public void Affiche_perso(int x, int y,String texture){
		StdDraw.picture(50*x+25, 40*y+17, texture,50,85);
	}
	
	public void PoserBombe() 
	{
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
	
	public Bombe CompteARebourd() //Renvoi les coordonnees d'une bombe qui explose
	{
		Bombe bombe = new Bombe(-1,-1);
		int rangeMax = 10;
		for(int i = 0; i < rangeMax; i++)
		{
			if(this.listeBombe[i] != null)
			{
				this.listeBombe[i].setDelai(this.listeBombe[i].getDelai() - 1);
				if(this.listeBombe[i].getDelai() == 0)
				{
					bombe = this.listeBombe[i];
					this.listeBombe[i] = null;
					this.nbBombe += 1;
					System.out.println("La bombe explose a l'emplacement : " + bombe.getX() + " " + bombe.getY());
					/// Destruction de ce qu'il y a autour de la bombe ///	
					
				}
			}
		}
		return bombe;
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
	}
}


