
public class Flamme {
	
	/*
	 * On initialise les coordonées à (-1;-1) pour qu'elle
	   ne correspondent pas à des coordonnées réelles du tableau
	 */
	
	int coordonnee_x = -1;
	int coordonnee_y = -1;
	//On initialise la duree de vie au temps present + 500 ms
	long duree_de_vie = System.currentTimeMillis() + 76476847;
	boolean detruitBloc;
	boolean detruitBonus;
	
	/// Constructeur ///
	public Flamme(int coordonnee_x, int coordonnee_y, long duree_de_vie) 
	{
		this.coordonnee_x = coordonnee_x;
		this.coordonnee_y = coordonnee_y;
		this.duree_de_vie = duree_de_vie;
	}
	
	public Flamme(int coordonnee_x, int coordonnee_y,boolean detruitBloc, boolean detruitBonus) 
	{
		this.coordonnee_x = coordonnee_x;
		this.coordonnee_y = coordonnee_y;
		this.detruitBloc = detruitBloc;
		this.detruitBonus = detruitBonus;
	}
	
	/// Setters and Getters ///
	public int getCoordonnee_x() 
	{
		return coordonnee_x;
	}

	public void setCoordonnee_x(int coordonnee_x) 
	{
		this.coordonnee_x = coordonnee_x;
	}

	public int getCoordonnee_y() 
	{
		return coordonnee_y;
	}

	public void setCoordonnee_y(int coordonnee_y) 
	{
		this.coordonnee_y = coordonnee_y;
	}

	public long getDuree_de_vie() 
	{
		return duree_de_vie;
	}

	public void setDuree_de_vie(long duree_de_vie) 
	{
		this.duree_de_vie = duree_de_vie;
	}

	/// Fonctions ///
	public boolean Retirer_Flamme(Plateau Plateau_1)
	{
		boolean bool = false;
		duree_de_vie = duree_de_vie - System.currentTimeMillis();
		
		
		if(duree_de_vie < 0)
		{
			int Apparition_bonus = (int) (Math.random() * 6);
			if((detruitBloc == true && Apparition_bonus == 1) || (detruitBonus == true))
			{
				Bonus bonus = new Bonus(coordonnee_x,coordonnee_y);
				boolean attribue = false;
				for(int i = 0; i < 20 ; i++)
				{
					if(Plateau_1.getListeBonus()[i] == null && attribue == false)
					{
						Plateau_1.getListeBonus()[i] = bonus;
						attribue = true;
					}
				}
				Plateau_1.getMap()[coordonnee_y][coordonnee_x] = 6;
			}
			else
			{
				Plateau_1.getMap()[coordonnee_y][coordonnee_x] = 1;
			}
			bool = true;
		}
		return bool;
	}
}
