import edu.princeton.cs.introcs.StdDraw;
import java.awt.event.KeyEvent;

public class Ecran_Titre {

	// Constructeur
	public Ecran_Titre() {
		
	}

	public void Affiche_Ecran_Titre(){
		
		// Attributs 
		int choix = 0;
		boolean boucle = true;
		boolean boucle2 = false;
		int choix_skins_cursor_player_1 = 0;
		int choix_skins_cursor_player_2 = 0;
		
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
				
				if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
					
					boucle2 = true;
					
					while(boucle2 == true){
						StdDraw.picture(625, 345, "Ecran Skins.png");
						StdDraw.pause(50);
						
						//Condition de selection
						if(choix_skins_cursor_player_1 == 0 ){
							StdDraw.picture(136, 389, "Cadre Selection.png");
							
						}
						
						if(choix_skins_cursor_player_1 == 1 ){
							StdDraw.picture(326, 389, "Cadre Selection.png");
							
						}
						
						if(choix_skins_cursor_player_1 == 2 ){
							StdDraw.picture(511, 389, "Cadre Selection.png");
							
						}
						
						if(choix_skins_cursor_player_1 == -1 ){
							StdDraw.picture(625, 565, "Retour.png");
						}
						
						if(choix_skins_cursor_player_2 == 0 ){
							StdDraw.picture(738, 389, "Cadre Selection.png");
							
						}
						
						if(choix_skins_cursor_player_2 == 1 ){
							StdDraw.picture(928, 389, "Cadre Selection.png");
							
						}
						
						if(choix_skins_cursor_player_2 == 2 ){
							StdDraw.picture(1112, 389, "Cadre Selection.png");
							
						}
						
						if(choix_skins_cursor_player_2 == -1 ){
							StdDraw.picture(625, 565, "Retour.png");
						}
						
						//Gestion clavier
						//Joueur 1
						if(StdDraw.isKeyPressed(39) && choix_skins_cursor_player_1 < 2){
							choix_skins_cursor_player_1 = choix_skins_cursor_player_1 + 1;
							StdDraw.pause(50);
						}
						
						if(StdDraw.isKeyPressed(37) && choix_skins_cursor_player_1 > 0){
							choix_skins_cursor_player_1 = choix_skins_cursor_player_1 - 1;
							StdDraw.pause(50);
						}
						
						if(StdDraw.isKeyPressed(38)){
							choix_skins_cursor_player_1 = 0;
							StdDraw.pause(50);
						}
						
						if(StdDraw.isKeyPressed(40)){
							choix_skins_cursor_player_1 = -1;
							StdDraw.pause(50);
						}
						//Joueur 2
						if(StdDraw.isKeyPressed(68) && choix_skins_cursor_player_2 < 2){
							choix_skins_cursor_player_2 = choix_skins_cursor_player_2 + 1;
							StdDraw.pause(50);
						}
						
						if(StdDraw.isKeyPressed(81) && choix_skins_cursor_player_2 > 0){
							choix_skins_cursor_player_2 = choix_skins_cursor_player_2 - 1;
							StdDraw.pause(50);
						}
						
						if(StdDraw.isKeyPressed(90)){
							choix_skins_cursor_player_2 = 0;
							StdDraw.pause(50);
						}
						
						if(StdDraw.isKeyPressed(83)){
							choix_skins_cursor_player_2 = -1;
							StdDraw.pause(50);
						}
						
						
						if (StdDraw.isKeyPressed(27) || StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
							boucle2 = false;
						}
					
						
						StdDraw.show();
					
					}
				}

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
