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
				int Portee = Joueur1.getPortee() + 1;
				
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
				int Portee = Joueur2.getPortee() + 1;
				
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
		int X_IA = Math.round(Joueur2.getX());
		int Y_IA = Math.round(Joueur2.getY());
		
		//Si le joueur est en danger ( defensif )
		if (Matrice_Danger[Y_IA][X_IA] == 1)
		{
			Deplacement_aleatoire_Defensif(Joueur2, Map);
		}
		//Si le joueur n'est en danger ( offensif )
		else{
			if(Joueur2.getListeBombe()[1] == null){
				if(Cherche_Cul_De_Sac(Joueur2,Map) == true || Cherche_Zone_De_Securite_1(Joueur2,Map, Matrice_Danger) == true){
					Joueur2.PoserBombe(Map);
				}
				// L'IA n'est pas dans un bon emplacement pour poser une bombe
				else{
					Deplacement_aleatoire_Offensif(Joueur2, Map, Matrice_Danger);
				}
			}
		}
		Joueur2.CompteARebourd(Map, Joueur1, Joueur2); //renommer plus tard //
		Joueur2.EnleverFlamme(Map);
	}
	
	public void Deplacement_aleatoire_Defensif(Personnage Joueur2, Plateau Map)
	{
		
		//Generation d'un nombre entre [0;3]
		int deplacement = (int) (Math.random() * 4);
		
		int X_IA = Math.round(Joueur2.getX());
		int Y_IA = Math.round(Joueur2.getY());
		
		//Droite
		if (deplacement == 0 && (Map.getMap()[Y_IA+1][X_IA] == 1 || Map.getMap()[Y_IA+1][X_IA] == 6))
		{
			Joueur2.setY(Y_IA+1);
		}
		
		//Gauche
		else if(deplacement == 1 && (Map.getMap()[Y_IA-1][X_IA] == 1 || Map.getMap()[Y_IA-1][X_IA] == 6))
		{
			Joueur2.setY(Y_IA-1);
		}
		
		//Haut
		else if(deplacement == 2 && (Map.getMap()[Y_IA][X_IA-1] == 1 || Map.getMap()[Y_IA][X_IA-1] == 6))
		{
			Joueur2.setX(X_IA-1);
		}
		
		//Bas
		else if(deplacement == 3 && (Map.getMap()[Y_IA][X_IA+1] == 1 || Map.getMap()[Y_IA][X_IA+1] == 6))
		{
			Joueur2.setX(X_IA+1);
		}
	}
	
	public void Deplacement_aleatoire_Offensif(Personnage Joueur2, Plateau Map, int [][] Matrice_Danger)
	{
		
		//Generation d'un nombre entre [0;3]
		int deplacement = (int) (Math.random() * 4);
		
		int X_IA = Math.round(Joueur2.getX());
		int Y_IA = Math.round(Joueur2.getY());
		
		//Droite
		if (deplacement == 0 && (Map.getMap()[Y_IA+1][X_IA] == 1 || Map.getMap()[Y_IA+1][X_IA] == 6) && Matrice_Danger[Y_IA+1][X_IA] != 1)
		{
			Joueur2.setY(Y_IA+1);
		}
		
		//Gauche
		else if(deplacement == 1 && (Map.getMap()[Y_IA-1][X_IA] == 1 || Map.getMap()[Y_IA-1][X_IA] == 6) && Matrice_Danger[Y_IA-1][X_IA] != 1)
		{
			Joueur2.setY(Y_IA-1);
		}
		
		//Haut
		else if(deplacement == 2 && (Map.getMap()[Y_IA][X_IA-1] == 1 || Map.getMap()[Y_IA][X_IA-1] == 6) && Matrice_Danger[Y_IA][X_IA-1] != 1)
		{
			Joueur2.setX(X_IA-1);
		}
		
		//Bas
		else if(deplacement == 3 && (Map.getMap()[Y_IA][X_IA+1] == 1 || Map.getMap()[Y_IA][X_IA+1] == 6) && Matrice_Danger[Y_IA][X_IA+1] != 1)
		{
			Joueur2.setX(X_IA+1);
		}
	}
	
	public boolean Cherche_Cul_De_Sac(Personnage Joueur2, Plateau Map){
		
		/* CETTE FONCTION A POUR BUT DE DETECTER SI L'IA SE TROUVE DANS UN CUL DE SAC */
		
		int X = Math.round(Joueur2.getX());
		int Y = Math.round(Joueur2.getY());
		
		//Premier cas "cul de sac dirige vers le haut"
		if((Map.getMap()[Y][X+1] == 0 || Map.getMap()[Y][X+1] == 4 || Map.getMap()[Y][X+1] == 2) // droite
				&& (Map.getMap()[Y-1][X] == 0 || Map.getMap()[Y-1][X] == 4 || Map.getMap()[Y-1][X] == 2) // haut
				&& (Map.getMap()[Y][X-1] == 0 || Map.getMap()[Y][X-1] == 4 || Map.getMap()[Y][X-1] == 2) //gauche
				){
			return true;
		}
		//Deuxieme cas "cul de sac dirige vers la gauche"
		else if((Map.getMap()[Y-1][X] == 0 || Map.getMap()[Y-1][X] == 4 || Map.getMap()[Y-1][X] == 2) //haut
				&& (Map.getMap()[Y][X-1] == 0 || Map.getMap()[Y][X-1] == 4 || Map.getMap()[Y][X-1] == 2) //gauche
				&& (Map.getMap()[Y+1][X] == 0 || Map.getMap()[Y+1][X] == 4 || Map.getMap()[Y+1][X] == 2) //bas
				){
			return true;
		}
		//Troisieme cas "cul de sac dirige vers la droite"
		else if((Map.getMap()[Y-1][X] == 0 || Map.getMap()[Y-1][X] == 4 || Map.getMap()[Y-1][X] == 2) // haut
				&& (Map.getMap()[Y][X+1] == 0 || Map.getMap()[Y][X+1] == 4 || Map.getMap()[Y][X+1] == 2) // droite
				&& (Map.getMap()[Y+1][X] == 0 || Map.getMap()[Y+1][X] == 4 || Map.getMap()[Y+1][X] == 2) // bas
				){
			return true;
		}
		//Quatrieme et dernier cas "cul de sac dirige vers le bas"
		else if((Map.getMap()[Y][X-1] == 0 || Map.getMap()[Y][X-1] == 4 || Map.getMap()[Y][X-1] == 2) // gauche
				&& (Map.getMap()[Y+1][X] == 0 || Map.getMap()[Y+1][X] == 4 || Map.getMap()[Y+1][X] == 2) // bas
				&& (Map.getMap()[Y][X+1] == 0 || Map.getMap()[Y][X+1] == 4 || Map.getMap()[Y][X+1] == 2) // droite
				){
			return true;
		}
		//Si l'IA n'est pas dans un cul de sac
		else{
			return false;
		}
		
	}
	
	public boolean Cherche_Zone_De_Securite_1(Personnage Joueur2, Plateau Map, int [][] Matrice_Danger){
		
		/* CETTE FONCTION A POUR BUT DE DETECTER SI L'IA SE TROUVE DANS UNE ZONE DE SECURITE DE TYPE 1
		 *  x x			J : IA
		 *  x J O O		x : bloc infranchissable
		 *    O	  O		O : bloc franchissable
		 *    O O
		 *  
		 *  */
		
		int X = Math.round(Joueur2.getX());
		int Y = Math.round(Joueur2.getY());
		
		//Premier cas "haut gauche"
		if((Map.getMap()[Y-1][X] == 0 || Map.getMap()[Y-1][X] == 4 || Map.getMap()[Y-1][X] == 2)
				&& (Map.getMap()[Y][X-1] == 0 || Map.getMap()[Y][X-1] == 4 || Map.getMap()[Y][X-1] == 2)
				&& (Map.getMap()[Y][X+1] == 1 || Map.getMap()[Y][X+1] == 6 && Matrice_Danger[Y][X+1] != 1)
				&& (Map.getMap()[Y][X+2] == 1 || Map.getMap()[Y][X+2] == 6 && Matrice_Danger[Y][X+2] != 1)
				&& (Map.getMap()[Y+1][X+2] == 1 || Map.getMap()[Y+1][X+2] == 6 && Matrice_Danger[Y+1][X+2] != 1)
				&& (Map.getMap()[Y+1][X] == 1 || Map.getMap()[Y+1][X] == 6 && Matrice_Danger[Y+1][X] != 1)
				&& (Map.getMap()[Y+2][X] == 1 || Map.getMap()[Y+2][X] == 6 && Matrice_Danger[Y+2][X] != 1)
				&& (Map.getMap()[Y+2][X+1] == 1 || Map.getMap()[Y+2][X+1] == 6 && Matrice_Danger[Y+2][X+1] != 1)
				){
			return true;
		}
		// Deuxieme cas "bas gauche"
		else if((Map.getMap()[Y][X-1] == 0 || Map.getMap()[Y][X-1] == 4 || Map.getMap()[Y][X-1] == 2)
				&& (Map.getMap()[Y+1][X] == 0 || Map.getMap()[Y+1][X] == 4 || Map.getMap()[Y+1][X] == 2)
				&& (Map.getMap()[Y][X+1] == 1 || Map.getMap()[Y][X+1] == 6 && Matrice_Danger[Y][X+1] != 1)
				&& (Map.getMap()[Y][X+2] == 1 || Map.getMap()[Y][X+2] == 6 && Matrice_Danger[Y][X+2] != 1)
				&& (Map.getMap()[Y-1][X+2] == 1 || Map.getMap()[Y-1][X+2] == 6 && Matrice_Danger[Y-1][X+2] != 1)
				&& (Map.getMap()[Y-1][X] == 1 || Map.getMap()[Y-1][X] == 6 && Matrice_Danger[Y-1][X] != 1)
				&& (Map.getMap()[Y-2][X] == 1 || Map.getMap()[Y-2][X] == 6 && Matrice_Danger[Y-2][X] != 1)
				&& (Map.getMap()[Y-2][X+1] == 1 || Map.getMap()[Y-2][X+1] == 6 && Matrice_Danger[Y-2][X+1] != 1)
				){
			return true;
		}
		// Troisieme cas "bas droite"
		else if((Map.getMap()[Y][X+1] == 0 || Map.getMap()[Y][X+1] == 4 || Map.getMap()[Y][X+1] == 2)
				&& (Map.getMap()[Y+1][X] == 0 || Map.getMap()[Y+1][X] == 4 || Map.getMap()[Y+1][X] == 2)
				&& (Map.getMap()[Y][X-1] == 1 || Map.getMap()[Y][X-1] == 6 && Matrice_Danger[Y][X-1] != 1)
				&& (Map.getMap()[Y][X-2] == 1 || Map.getMap()[Y][X-2] == 6 && Matrice_Danger[Y][X-2] != 1)
				&& (Map.getMap()[Y-1][X-2] == 1 || Map.getMap()[Y-1][X-2] == 6 && Matrice_Danger[Y-1][X-2] != 1)
				&& (Map.getMap()[Y-1][X] == 1 || Map.getMap()[Y-1][X] == 6 && Matrice_Danger[Y-1][X] != 1)
				&& (Map.getMap()[Y-2][X] == 1 || Map.getMap()[Y-2][X] == 6 && Matrice_Danger[Y-2][X] != 1)
				&& (Map.getMap()[Y-2][X-1] == 1 || Map.getMap()[Y-2][X-1] == 6 && Matrice_Danger[Y-2][X-1] != 1)
				){
			return true;
		}
		else{
			return false;
		}
	}
}
