package fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement;

import java.util.Random;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Mob;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Strategie;

public class DeplacementAleatoireParSequence implements Strategie {

	public static  int faconMove(double d, Mob mob, long delta) {
		
		Random rand = new Random();
		   
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(2);
        
		if (mob.getX() == 100) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		if (mob.getX() == 200) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		if (mob.getX() == 300) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		if (mob.getX() == 400) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		if (mob.getX() == 500) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		if (mob.getX() == 600) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		if (mob.getX() == 700) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		if (mob.getX() == 800) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}
		
		if (mob.getX() == 900) {
			if (rand_int1 == 1) {
				return 24;
			}
			else {
				return -24;
			}
		}

		if (mob.getHorizontalSpeed() == 24) {
			return 24;
		}
		else {
			return -24;
		}
		
	}

}
