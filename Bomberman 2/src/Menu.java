import edu.princeton.cs.introcs.StdDraw;

public class Menu {

	public void Affiche_Menu(int [][] map,Plateau Plateau_1,Personnage Joueur1,Personnage Joueur2){
		
		int choix = 0;
		int Affichage_ok = 0;
		boolean boucle = true;
		
		while(boucle == true){
			
			StdDraw.show();
			if (choix == 0 && Affichage_ok == 0){
				Plateau_1.Afficher_map(map,Joueur1,Joueur2);
				StdDraw.picture(500, 300, "Menu.png");
				StdDraw.picture(500, 242, "Survol Resume.png");
				Affichage_ok = 1;
				StdDraw.pause(50);
			}
			
			if (choix == 1 && Affichage_ok == 0){
				Plateau_1.Afficher_map(map,Joueur1,Joueur2);
				StdDraw.picture(500, 300, "Menu.png");
				StdDraw.picture(500, 299, "Survol Restart.png");
				Affichage_ok = 1;
				StdDraw.pause(50);
			}
			
			if (choix == 2 && Affichage_ok == 0){
				Plateau_1.Afficher_map(map,Joueur1,Joueur2);
				StdDraw.picture(500, 300, "Menu.png");
				StdDraw.picture(500, 397, "Survol Quit.png");
				Affichage_ok = 1;
				StdDraw.pause(50);
			}
			
			if(StdDraw.isKeyPressed(40) && choix < 2){
				choix = choix + 1;
				Affichage_ok = 0;
				
			}
			
			if(StdDraw.isKeyPressed(38) && choix >= 1){
				choix = choix - 1;
				Affichage_ok = 0;
				
			}
			
			if(StdDraw.isKeyPressed(13) && choix == 0){
				boucle = false;
				System.out.println("ok");
				
			}
			
			
		}
		
	}

	//Constructeur
	public Menu() {
		
	}
	
}
