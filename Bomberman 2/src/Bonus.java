import java.lang.Math; 

public class Bonus {

	// Nombre entier aleatoire entre 0 et 12 deffinnissant le bonus 
	int Choix_bonus = (int) (Math.random() * 13 );
	// Un bonus a une probabilité de 1 chance sur 5 d'apparaitre 
	int Apparition_bonus = (int) (Math.random() * 6 );
	
	//Constructeur
	public Bonus() {

	}

	//Getter and setters
	public int getChoix_bonus() {
		return Choix_bonus;
	}



	public void setChoix_bonus(int choix_bonus) {
		Choix_bonus = choix_bonus;
	}



	public int getApparition_bonus() {
		return Apparition_bonus;
	}



	public void setApparition_bonus(int apparition_bonus) {
		Apparition_bonus = apparition_bonus;
	}


	//Fonction
	
	public boolean Bonus_Pop(int Apparition_bonus){
		
		if(Apparition_bonus == 1){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	public void Place_bonus(int x,int y, Plateau map){
		
		// Si le bonus apparait
		if(Bonus_Pop(Apparition_bonus) == true){
			
			//On change la valeur du plateau
			map.getMap()[x][y] = 6;
		}
		else{
			map.getMap()[x][y] = 1;
		}
		
	}
	
	public void Attribution_bonus(Personnage Joueur){
		
		// Flamme Jaune attribuee
		if (Choix_bonus == 0){
			Joueur.getListeBonus()[0] = 1;
		}
		
		// Flamme Bleue attribuee
		if (Choix_bonus == 1){
			Joueur.getListeBonus()[0] = 2;
		}
		
		// Flamme Verte attribuee
		if (Choix_bonus == 2){
			Joueur.getListeBonus()[0] = 3;
		}
		
		// Flamme Rouge attribuee
		if (Choix_bonus == 3){
			Joueur.getListeBonus()[0] = 4;
		}
		
		// Bombe rouge attribuee
		if (Choix_bonus == 4){
			Joueur.getListeBonus()[1] = 1;
		}
		
		// Speed Up attribuee
		if (Choix_bonus == 5){
			Joueur.getListeBonus()[2] = 1;
		}
		
		// Slow down attribuee
		if (Choix_bonus == 6){
			Joueur.getListeBonus()[3] = 1;
		}
		
		// Mine attribuee
		if (Choix_bonus == 7){
			Joueur.getListeBonus()[4] = 1;
		}
		
		// Rebond attribuee
		if (Choix_bonus == 8){
			Joueur.getListeBonus()[5] = 1;
		}
		
		// Line attribuee
		if (Choix_bonus == 9){
			Joueur.getListeBonus()[6] = 1;
		}
		
		// Shield attribuee
		if (Choix_bonus == 10){
			Joueur.getListeBonus()[7] = 1;
		}
		
		//Vie supplementaire attribuee
		if (Choix_bonus == 11){
			Joueur.setVie(Joueur.getVie() + 1);
		}
		
		//Bombe supplementaire attribuee
		if (Choix_bonus == 12){
			Joueur.setNbBombe(Joueur.getNbBombe() + 1);
		}
	}
}
