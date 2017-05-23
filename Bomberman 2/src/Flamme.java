
public class Flamme {
	
	//On initialise les coordonées à (-1;-1) pour qu'elle
	//ne correspondent pas à des coordonées réelles du tableau
	int coordonne_x = -1;
	int coordonne_y = -1;
	//On initialise la duree de vie au temps present + 500 ms
	long duree_de_vie = System.currentTimeMillis() + 500;
	
	//Constructeur
	public Flamme() {
		this.coordonne_x = coordonne_x;
		this.coordonne_y = coordonne_y;
		this.duree_de_vie = duree_de_vie;
	}
	
	public int getCoordonne_x() {
		return coordonne_x;
	}


	public void setCoordonne_x(int coordonne_x) {
		this.coordonne_x = coordonne_x;
	}



	public int getCoordonne_y() {
		return coordonne_y;
	}


	public void setCoordonne_y(int coordonne_y) {
		this.coordonne_y = coordonne_y;
	}


	public long getDuree_de_vie() {
		return duree_de_vie;
	}


	public void setDuree_de_vie(long duree_de_vie) {
		this.duree_de_vie = duree_de_vie;
	}



	public void Retirer_Flamme(int map [][],int coordonne_x,int coordonne_y,long duree_de_vie){
		duree_de_vie = duree_de_vie - System.currentTimeMillis();
		
		if(duree_de_vie < 0){
			map[coordonne_x][coordonne_y] = 1;
		}
	}
	

}
