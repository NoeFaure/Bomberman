import edu.princeton.cs.introcs.StdDraw;

public class Personnage {
	
	private int vie = 3;
	private int vitesse = 1;
	private int nbBombe = 3;
	private int x;
	private int y;
	private Bombe[] listeBombe = new Bombe[10];
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
		int assigne = 0;
		for(int i = 0; i < 10; i++)
		{
			if(this.listeBombe[i] == null && assigne == 0) // Verifie qu'un emplacement pour bombe est dispo
			{
				Bombe bombe = new Bombe(this.x, this.y);
				this.listeBombe[i] = bombe;
				assigne = 1;
			}
		}
		
	}
	
	public int[] CompteARebourd() //Renvoi les coordonnees d'une bombe qui explose
	{
		int[] coordonnees = {-1,-1};
		for(int i = 0; i < 10; i++)
		{
			if(this.listeBombe[i] != null)
			{
				this.listeBombe[i].setDelai(this.listeBombe[i].getDelai() - 1);
				if(this.listeBombe[i].getDelai() == 0)
				{
					coordonnees = this.listeBombe[i].retourCoordonnee();
					this.listeBombe[i] = null;
					this.nbBombe += 1;
					System.out.println("bombe explos�e � l'emplacement : " + coordonnees[0] + " " + coordonnees[1]);
					/// Destruction de ce qu'il y a autour de la bombe ///				
				}
			}
		}
		return coordonnees;
	}
	
}


