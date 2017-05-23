
public class Flamme {
	
	//On initialise les coordonées à (-1;-1) pour qu'elle
	//ne correspondent pas à des coordonées réelles du tableau
	int coordonnee_x = -1;
	int coordonnee_y = -1;
	//On initialise la duree de vie au temps present + 500 ms
	long duree_de_vie = System.currentTimeMillis() + 76476847;
	
	//Constructeur
	public Flamme(int coordonnee_x, int coordonnee_y, long duree_de_vie) {
		this.coordonnee_x = coordonnee_x;
		this.coordonnee_y = coordonnee_y;
		this.duree_de_vie = duree_de_vie;
	}
	
	public Flamme(int coordonnee_x, int coordonnee_y) {
		this.coordonnee_x = coordonnee_x;
		this.coordonnee_y = coordonnee_y;
	}
	
	
	public int getCoordonnee_x() {
		return coordonnee_x;
	}


	public void setCoordonnee_x(int coordonnee_x) {
		this.coordonnee_x = coordonnee_x;
	}



	public int getCoordonnee_y() {
		return coordonnee_y;
	}


	public void setCoordonnee_y(int coordonnee_y) {
		this.coordonnee_y = coordonnee_y;
	}


	public long getDuree_de_vie() {
		return duree_de_vie;
	}


	public void setDuree_de_vie(long duree_de_vie) {
		this.duree_de_vie = duree_de_vie;
	}



	public boolean Retirer_Flamme(Plateau Plateau_1){
		boolean bool = false;
		duree_de_vie = duree_de_vie - System.currentTimeMillis();
		
		
		if(duree_de_vie < 0)
		{
			Plateau_1.getMap()[coordonnee_y][coordonnee_x] = 1;
			bool = true;
		}
		return bool;
		
	}
	

}
