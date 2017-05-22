import edu.princeton.cs.introcs.StdDraw;
import java.awt.event.KeyEvent;

public class Ecran_Titre {

	
	public Ecran_Titre() {
		
	}

	public void Affiche_Ecran_Titre(){
		
		int choix = 0;
		boolean boucle = true;
		
		while(boucle == true){
			
			if(choix == 0){
				StdDraw.picture(625, 345, "Ecran Titre.png");
				StdDraw.picture(623, 305, "2 Joueurs Selection.png");
				
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
					boucle = false;
				}

			}
			
			if(choix == 1){
				StdDraw.picture(625, 345, "Ecran Titre.png");
				StdDraw.picture(623, 411, "1 Joueur Selection.png");

			}
			
			if(choix == 2){
				StdDraw.picture(625, 345, "Ecran Titre.png");
				StdDraw.picture(623, 517, "Skins Selection.png");

			}
			
			if(StdDraw.isKeyPressed(40) && choix < 2){
				choix = choix + 1;
				StdDraw.pause(100);
				
			}
			
			if(StdDraw.isKeyPressed(38) && choix >= 1){
				choix = choix - 1;
				StdDraw.pause(100);
				
			}
			
			StdDraw.pause(50);
			StdDraw.show();
		}
	}
}
