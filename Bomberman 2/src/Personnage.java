import edu.princeton.cs.introcs.StdDraw;

public class Personnage {
	
	private int vie = 3;
	private int vitesse = 1;
	private int nbBombe = 1;
	private int x;
	private int y;
	public Personnage(int vie, int vitesse, int nbBombe, int x, int y) 
	{
		this.vie = vie;
		this.vitesse = vitesse;
		this.nbBombe = nbBombe;
		this.x = x;
		this.y = y;
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
	
	/*public void PoserBombe()
	{
		Bombe bombe = new Bombe(this.x, this.y, this);
		StdDraw.picture(50*this.x+25, 40*this.y+17, "Gem Green.png",50,85);
		
	}*/
	
}


