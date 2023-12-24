package fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement;
import java.util.concurrent.ThreadLocalRandom;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Mob;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Strategie;


public class DeplacementAlea implements Strategie {
	private DeplacementAlea(){
		
	}

	public static  int faconMove(double d, Mob mob, long delta) {
        int randInt1 = ThreadLocalRandom.current().nextInt();
		
		if (randInt1 > 0) {
			return -50;
		}
		if (randInt1 < 0) {
			return (50);
		}
		return randInt1;
		
	}

}
