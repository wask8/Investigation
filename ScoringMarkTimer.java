package mjkl.investigation.running;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoringMarkTime{

	private int level = 0;
	private int vie = 3;
	private int mark[];
	private int reponse = 0;
	private int score = 0;
	private int duree = 0;
	
	private boolean verifmark;
	
	
	/**
	 * Base de calcul du score, à compléter...
	 */
	
	
	
	//CALCUL DU SCORE 
	
	public void calculScore(){
		
	if(verifmark == true){
		if(reponse == 0){
				score = score + ( /*temps restant */ * 0.1)
			}else if(reponse != 0 ){
				score = score + 0;
			}
		}
	
		DisplayScore(); /*Actualiser le score affiché à l'écran, au départ score = 0*/
	
	}
	
	
	//VERIFICATION DU MARQUAGE
	public boolean verifMark(){
		int mark[];
		int réponse;
		
		réponse = 0;
		
		if(level == 1){
			if(/*clik = reponse*/){
				
				/*stoper chrono et passer à la question suivante*/
				
				calculScore();
				
				return true;
				
			}else if(/*click != reponse*/){
				
				vie -= 1;
				
			}
		}
		
		if(vie == 0){
			
			return false;
			
			// retourner au menu //
			
		}else if(/*chrono*/ == 0){
			return false;
		}
		return false;
		
	}



}
