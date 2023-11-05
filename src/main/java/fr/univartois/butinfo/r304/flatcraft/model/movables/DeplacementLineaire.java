package fr.univartois.butinfo.r304.flatcraft.model.movables;

public class DeplacementLineaire implements Strategie {

	public static  int faconMove(double d, Mob mob, long delta) {
		
		if (d == 24) {
			return -24;
		}
		if (d == -24) {
			return (24);
		}
		return 0;
		
	}

}
