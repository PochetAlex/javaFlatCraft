package fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement;

import java.util.Random;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Mob;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Strategie;

public class DeplacementAleatoireParSequence implements Strategie {
	private static final Random RANDOM = new Random();
	

	private DeplacementAleatoireParSequence() {
	}


	public static int faconMove(Mob mob) {
	    int currentX = mob.getX();

	    // Check if currentX is one of the specific values
	    for (int x = 100; x <= 900; x += 100) {
	        if (currentX == x) {
	            int randInt1 = RANDOM.nextInt(2);
	            return (randInt1 == 1) ? 24 : -24;
	        }
	    }

	    // If none of the specific values match, return the current horizontal speed
	    return (int) mob.getHorizontalSpeed();
	}


}
