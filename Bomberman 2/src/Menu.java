import edu.princeton.cs.introcs.StdDraw;
import java.awt.event.KeyEvent;

public class Menu {

	public void Affiche_Menu(int [][] map,Plateau Plateau_1,Personnage Joueur1,Personnage Joueur2,long Time_seconde,long Time_minute){
		
		int choix = 0;
		int Affichage_ok = 0;
		boolean boucle = true;
		
		
		while(boucle == true){
			
			//Gestion souris
			if(StdDraw.mouseX() >= 707 && StdDraw.mouseX() < 750 && StdDraw.mouseY() < 200 && StdDraw.mouseY() >= 153){
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
					
					StdDraw.picture(500, 300, "Images/Menu/Menu.png");
					StdDraw.picture(500, 242, "Images/Menu/Survol Resume.png");
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
					
					StdDraw.picture(500, 300, "Images/Menu/Menu.png");
					StdDraw.picture(500, 299, "Images/Menu/Survol Restart.png");
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
					
					StdDraw.picture(500, 300, "Images/Menu/Menu.png");
					StdDraw.picture(500, 397, "Images/Menu/Survol Quit.png");
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
					StdDraw.picture(500, 242, "Images/Menu/Press Resume.png");
					StdDraw.show();
					StdDraw.pause(30);
					boucle = false;
					
				}
				
				//RESTART PRESS
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && choix == 1){
					StdDraw.picture(500, 299, "Images/Menu/Press Restart.png");
					StdDraw.show();
					StdDraw.pause(30);
					
					Jeu Partie_1 = new Jeu();
					Partie_1.Jouer(Joueur1, Joueur2, false);
					
				}
				
				//QUIT PRESS
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && choix == 2){
					StdDraw.picture(500, 397, "Images/Menu/Press Quit.png");
					StdDraw.show();
					StdDraw.pause(30);
					
					Ecran_Titre Ecran_titre_2 = new Ecran_Titre();
					Ecran_titre_2.Affiche_Ecran_Titre(Joueur1,Joueur2);
					
					//System.exit(1);
					
				}
				StdDraw.pause(5);
				
				StdDraw.picture(728, 173, "Images/Menu/Close.png");
				
				//QUIT MOUSE
				if (StdDraw.mousePressed()){
					boucle = false;
				}
			}
			
			
			//LA SOURIS N'EST PAS SUR LA CROIX
			else{
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
					
					StdDraw.picture(500, 300, "Images/Menu/Menu.png");
					StdDraw.picture(500, 242, "Images/Menu/Survol Resume.png");
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
					
					StdDraw.picture(500, 300, "Images/Menu/Menu.png");
					StdDraw.picture(500, 299, "Images/Menu/Survol Restart.png");
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
					
					StdDraw.picture(500, 300, "Images/Menu/Menu.png");
					StdDraw.picture(500, 397, "Images/Menu/Survol Quit.png");
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
					StdDraw.picture(500, 242, "Images/Menu/Press Resume.png");
					StdDraw.show();
					StdDraw.pause(30);
					boucle = false;
					
				}
				
				//RESTART PRESS
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && choix == 1){
					StdDraw.picture(500, 299, "Images/Menu/Press Restart.png");
					StdDraw.show();
					StdDraw.pause(30);
					
					Jeu Partie_1 = new Jeu();
					Partie_1.Jouer(Joueur1, Joueur2, false);
					
				}
				
				//QUIT PRESS
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && choix == 2){
					StdDraw.picture(500, 397, "Images/Menu/Press Quit.png");
					StdDraw.show();
					StdDraw.pause(30);
					
					Ecran_Titre Ecran_titre_2 = new Ecran_Titre();
					Ecran_titre_2.Affiche_Ecran_Titre(Joueur1,Joueur2);
					
				}
				StdDraw.pause(5);
			}
			
			StdDraw.show();
		}
		
	}

	//Constructeur
	public Menu() {
		
	}
	
}
