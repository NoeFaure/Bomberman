import java.lang.Math; 

public class Bonus {

	// Nombre entier aleatoire entre 0 et 8 deffinnissant le bonus 
	int Choix_bonus = (int) (Math.random() * 9 );
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
	}
}
