import java.lang.Math; 

public class IA {
	
	// _______________TENTATIVE DE CRÉATION D'IA _______________
	//------------------ /!\ GROS CHANTIER /!\ ------------------

	/// Constructeur ///
	public IA() 
	{
		
	}
	
	public int[][] Generation_matrice_de_danger(Personnage Joueur1, Personnage Joueur2){
		
		/* Infos : cette fonction crée une matrice
		 * dite "de danger" faisant la taille de la matrice
		 * "plateau" possédant des 1 au endroit ou une flamme
		 * peut être générée par une bombe posée. Des 0 sinon.
		 * 
		 * Les 3 correspondent aux murs d'enceinte
		 * les 4 aux murs indestructibles
		 * 
		 *  Joueur 1 : Utilisateur
		 *  Joueur 2 : IA
		 */
		
		int[][] Matrice ={{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,3},
						  {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
						  {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}};
		
		//---- ON RÉCUPÈRE LA POSITIONS DE TOUTES LES BOMBES PRÉSENTES SUR LA MAP ----
		
		/// Pour le joueur 1 ///
		for (int indice = 0; indice < Joueur1.getListeBombe().length; indice++)
		{
			if(Joueur1.getListeBombe()[indice] != null)
			{
				Bombe bombe = Joueur1.getListeBombe()[indice];
				int Bombe_x = bombe.getX();
				int Bombe_y = bombe.getY();
				
				//La position de la bombe prend la coordonnee 1
				Matrice[Bombe_y][Bombe_x] = 1;
				
				// On recupere la portee de la bombe du joueurs pour evaluer la taille de
				// l'explosion.
				int Portee = bombe.getPortee() + 1;
				
				//On place des 1 sur les endroits ou l'explosion apparaitera.
				//On creer des variables stop au cas ou on depasse la taille de la map.
				boolean stop_1 = false;
				boolean stop_2 = false;
				boolean stop_3 = false;
				boolean stop_4 = false;
				
				//Variable de protections ( si un mur protege de l'explosion )
				boolean protect_1 = false;
				boolean protect_2 = false;
				boolean protect_3 = false;
				boolean protect_4 = false;
				
				for(int ajout = 0; ajout<Portee; ajout++)
				{
					
					//On verifie qu'on ne depasse pas la taille de la map
					//Puis on remplace par 1.
					
					//En Bas
					if(stop_1 == false)
					{
						if (Matrice[Bombe_y][Bombe_x+ajout] != 3)
						{
							if(Matrice[Bombe_y][Bombe_x+ajout] == 4)
							{
								protect_1 = true;
							}
							else if(protect_1 == false)
							{
								Matrice[Bombe_y][Bombe_x+ajout] = 1;
							}
						}
						else
						{
							stop_1 = true;
						}
					}
					
					//En haut
					if (stop_2 == false)
					{
						if (Matrice[Bombe_y][Bombe_x-ajout] != 3)
						{
							if(Matrice[Bombe_y][Bombe_x-ajout] == 4)
							{
								protect_2 = true;
							}
							else if(protect_2 == false)
							{
								Matrice[Bombe_y][Bombe_x-ajout] = 1;
							}
						}
						else
						{
							stop_2 = true;
						}
					}
					
					//A droite
					if (stop_3 == false)
					{
						if (Matrice[Bombe_y+ajout][Bombe_x] != 3)
						{
							if(Matrice[Bombe_y+ajout][Bombe_x] == 4)
							{
								protect_3 = true;
							}
							else if(protect_3 == false)
							{
								Matrice[Bombe_y+ajout][Bombe_x] = 1;
							}
						}
						else
						{
							stop_3 = true;
						}
					}
					
					//A gauche
					if (stop_4 == false)
					{
						if (Matrice[Bombe_y-ajout][Bombe_x] != 3)
						{
							if(Matrice[Bombe_y-ajout][Bombe_x] == 4)
							{
								protect_4 = true;
							}
							else if(protect_4 == false)
							{
								Matrice[Bombe_y-ajout][Bombe_x] = 1;
							}
						}
						else
						{
							stop_4 = true;
						}
					}
				}
			}
		}
		
		//Pour le Joueur 2
		
		for (int indice = 0; indice < Joueur2.getListeBombe().length; indice++)
		{
			if(Joueur2.getListeBombe()[indice] != null)
			{
				Bombe bombe = Joueur2.getListeBombe()[indice];
				int Bombe_x = bombe.getX();
				int Bombe_y = bombe.getY();
				
				//La position de la bombe prend la coordonnee 1
				Matrice[Bombe_y][Bombe_x] = 1;
				
				// On recupere la portee de la bombe du joueurs pour evaluer la taille de
				// l'explosion.
				int Portee = bombe.getPortee() + 1;
				
				//On place des 1 sur les endroits ou l'explosion apparaitera.
				//On creer des variables stop au cas ou on depasse la taille de la map.
				boolean stop_1 = false;
				boolean stop_2 = false;
				boolean stop_3 = false;
				boolean stop_4 = false;
				
				//Variable de protections ( si un mur protege de l'explosion )
				boolean protect_1 = false;
				boolean protect_2 = false;
				boolean protect_3 = false;
				boolean protect_4 = false;
				
				for(int ajout = 0; ajout<Portee; ajout++)
				{
					
					//On verifie qu'on ne depasse pas la taille de la map
					//Puis on remplace par 1.
					
					//En Bas
					if(stop_1 == false)
					{
						if (Matrice[Bombe_y][Bombe_x+ajout] != 3)
						{
							if(Matrice[Bombe_y][Bombe_x+ajout] == 4)
							{
								protect_1 = true;
							}
							else if(protect_1 == false)
							{
								Matrice[Bombe_y][Bombe_x+ajout] = 1;
							}
						}
						else
						{
							stop_1 = true;
						}
					}
					
					//En haut
					if (stop_2 == false)
					{
						if (Matrice[Bombe_y][Bombe_x-ajout] != 3)
						{
							if(Matrice[Bombe_y][Bombe_x-ajout] == 4)
							{
								protect_2 = true;
							}
							else if(protect_2 == false)
							{
								Matrice[Bombe_y][Bombe_x-ajout] = 1;
							}
						}
						else
						{
							stop_2 = true;
						}
					}
					
					//A droite
					if (stop_3 == false)
					{
						if (Matrice[Bombe_y+ajout][Bombe_x] != 3)
						{
							if(Matrice[Bombe_y+ajout][Bombe_x] == 4)
							{
								protect_3 = true;
							}
							else if(protect_3 == false)
							{
								Matrice[Bombe_y+ajout][Bombe_x] = 1;
							}
						}
						else
						{
							stop_3 = true;
						}
					}
					
					//A gauche
					if (stop_4 == false)
					{
						if (Matrice[Bombe_y-ajout][Bombe_x] != 3)
						{
							if(Matrice[Bombe_y-ajout][Bombe_x] == 4)
							{
								protect_4 = true;
							}
							else if(protect_4 == false)
							{
								Matrice[Bombe_y-ajout][Bombe_x] = 1;
							}
						}
						else
						{
							stop_4 = true;
						}
					}
				}
			}
		}
		
		// On retourne la matrice cree
		return Matrice;
	}

	public void Deplacement_IA(Personnage Joueur1,Personnage Joueur2, Plateau Map)
	{
		
		// ------------- ESQUIVE ------------- 
		
		int [][] Matrice_Danger = Generation_matrice_de_danger(Joueur1,Joueur2);
		int X_IA = Joueur2.getX();
		int Y_IA = Joueur2.getY();
		
		//Si le joueur est en danger ( defensif )
		if (Matrice_Danger[Y_IA][X_IA] == 1)
		{
			Deplacement_aleatoire(Joueur2, Map);
		}
		//Si le joueur n'est en danger ( offensif )
		else{
			if((int) (Math.random() * 40 ) == 1){
				Joueur2.PoserBombe(Map);
			}
		}
		Joueur2.CompteARebourd(Map, Joueur1, Joueur2); //renommer plus tard //
		Joueur2.EnleverFlamme(Map);
	}
	
	public void Deplacement_aleatoire(Personnage Joueur2, Plateau Map)
	{
		
		//Generation d'un nombre entre [0;3]
		int deplacement = (int) (Math.random() * 4);
		
		int X_IA = Joueur2.getX();
		int Y_IA = Joueur2.getY();
		
		//Droite
		if (deplacement == 0 && Map.getMap()[Y_IA+1][X_IA] == 1)
		{
			Joueur2.setY(Y_IA+1);
		}
		
		//Gauche
		else if(deplacement == 1 && Map.getMap()[Y_IA-1][X_IA] == 1)
		{
			Joueur2.setY(Y_IA-1);
		}
		
		//Haut
		else if(deplacement == 2 && Map.getMap()[Y_IA][X_IA-1] == 1)
		{
			Joueur2.setX(X_IA-1);
		}
		
		//Bas
		else if(deplacement == 3 && Map.getMap()[Y_IA][X_IA+1] == 1)
		{
			Joueur2.setX(X_IA+1);
		}
	}
}
