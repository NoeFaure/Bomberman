import edu.princeton.cs.introcs.StdDraw;
import java.awt.event.KeyEvent;

public class Menu {

	public void Affiche_Menu(int [][] map,Plateau Plateau_1,Personnage Joueur1,Personnage Joueur2,long Time_seconde,long Time_minute){
		
		int choix = 0;
		int Affichage_ok = 0;
		boolean boucle = true;
		
		while(boucle == true){
			
			StdDraw.show();
			if (choix == 0 && Affichage_ok == 0){
				Plateau_1.Afficher_map(map,Joueur1,Joueur2);
				
				StdDraw.text(1213, 249, Integer.toString((Joueur1.getVie())));
				StdDraw.text(1213, 454, Integer.toString((Joueur2.getVie())));
				StdDraw.text(1125, 249, Integer.toString((Joueur1.getNbBombe())));
				StdDraw.text(1125, 454, Integer.toString((Joueur2.getNbBombe())));
				
				//Timer
				if (Time_seconde < 10 && Time_minute < 10){
					StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
				}
				else if(Time_seconde >= 10 && Time_minute < 10){
					StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
				}
				else if(Time_seconde < 10 && Time_minute >= 10){
					StdDraw.text(1150, 116,Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
				}
				else if(Time_seconde >= 10 && Time_minute >= 10){
					StdDraw.text(1150, 116,Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
				}
				
				StdDraw.picture(500, 300, "Menu.png");
				StdDraw.picture(500, 242, "Survol Resume.png");
				Affichage_ok = 1;
				StdDraw.pause(80);
			}
			
			if (choix == 1 && Affichage_ok == 0){
				Plateau_1.Afficher_map(map,Joueur1,Joueur2);
				
				StdDraw.text(1213, 249, Integer.toString((Joueur1.getVie())));
				StdDraw.text(1213, 454, Integer.toString((Joueur2.getVie())));
				StdDraw.text(1125, 249, Integer.toString((Joueur1.getNbBombe())));
				StdDraw.text(1125, 454, Integer.toString((Joueur2.getNbBombe())));
				
				//Timer
				if (Time_seconde < 10 && Time_minute < 10){
					StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
				}
				else if(Time_seconde >= 10 && Time_minute < 10){
					StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
				}
				else if(Time_seconde < 10 && Time_minute >= 10){
					StdDraw.text(1150, 116,Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
				}
				else if(Time_seconde >= 10 && Time_minute >= 10){
					StdDraw.text(1150, 116,Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
				}
				
				StdDraw.picture(500, 300, "Menu.png");
				StdDraw.picture(500, 299, "Survol Restart.png");
				Affichage_ok = 1;
				StdDraw.pause(80);
			}
			
			if (choix == 2 && Affichage_ok == 0){
				Plateau_1.Afficher_map(map,Joueur1,Joueur2);
				
				StdDraw.text(1213, 249, Integer.toString((Joueur1.getVie())));
				StdDraw.text(1213, 454, Integer.toString((Joueur2.getVie())));
				StdDraw.text(1125, 249, Integer.toString((Joueur1.getNbBombe())));
				StdDraw.text(1125, 454, Integer.toString((Joueur2.getNbBombe())));
				
				//Timer
				if (Time_seconde < 10 && Time_minute < 10){
					StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
				}
				else if(Time_seconde >= 10 && Time_minute < 10){
					StdDraw.text(1150, 116,"0" + Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
				}
				else if(Time_seconde < 10 && Time_minute >= 10){
					StdDraw.text(1150, 116,Long.toString(Time_minute) + " : 0" + Long.toString(Time_seconde));
				}
				else if(Time_seconde >= 10 && Time_minute >= 10){
					StdDraw.text(1150, 116,Long.toString(Time_minute) + " : " + Long.toString(Time_seconde));
				}
				
				StdDraw.picture(500, 300, "Menu.png");
				StdDraw.picture(500, 397, "Survol Quit.png");
				Affichage_ok = 1;
				StdDraw.pause(80);
			}
			
			if(StdDraw.isKeyPressed(40) && choix < 2){
				choix = choix + 1;
				Affichage_ok = 0;
				
			}
			
			if(StdDraw.isKeyPressed(38) && choix >= 1){
				choix = choix - 1;
				Affichage_ok = 0;
				
			}
			
			//RESUME PRESS
			if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && choix == 0){
				boucle = false;
				
			}
			
			//RESTART PRESS
			if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && choix == 1){
				
			}
			
			//QUIT PRESS
			if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && choix == 2){
				
				
			}
			
		}
		
	}

	//Constructeur
	public Menu() {
		
	}
	
}