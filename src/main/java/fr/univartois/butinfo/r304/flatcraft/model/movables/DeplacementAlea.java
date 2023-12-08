package fr.univartois.butinfo.r304.flatcraft.model.movables;
import java.util.concurrent.ThreadLocalRandom;


public class DeplacementAlea implements Strategie {

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
