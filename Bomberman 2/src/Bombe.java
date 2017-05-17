import edu.princeton.cs.introcs.StdDraw;

public class Bombe {
	private int x;
	private int y;
	private int delai = 500;
	private int portee = 1;
	private Personnage joueur;
	
	public Bombe(int x, int y, Personnage joueur)
	{
		this.x = x;
		this.y = y;
		this.joueur = joueur;
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

	public Personnage getJoueur() {
		return joueur;
	}

	public void setJoueur(Personnage joueur) {
		this.joueur = joueur;
	}
	
	public void Affiche_bomb(int x, int y){
		StdDraw.picture(50*(x)+25, y*40+37, "Grass Block 2.png",50,85);
		StdDraw.picture(50*(x)+25, y*40+37, "Bomb.png",50,85);
	}
	

}
