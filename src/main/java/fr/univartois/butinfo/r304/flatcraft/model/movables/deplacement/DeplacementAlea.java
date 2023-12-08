package fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement;
import java.util.concurrent.ThreadLocalRandom;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Mob;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Strategie;


public class DeplacementAlea implements Strategie {

	public static  int faconMove(double d, Mob mob, long delta) {
        int rand_int1 = ThreadLocalRandom.current().nextInt();
		
		if (rand_int1 > 0) {
			return -50;
		}
		if (rand_int1 < 0) {
			return (50);
		}
		return rand_int1;
		
	}

}
