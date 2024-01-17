package fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Strategie;

public class DeplacementLineaire implements Strategie {
	
	private DeplacementLineaire() {
		
	}
	public static  int faconMove(double d) {
		if (d == 24) {
			return -24;
		}
		if (d == -24) {
			return (24);
		}
		return 24;
		
	}

}
