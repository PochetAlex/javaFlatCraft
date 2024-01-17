package fr.univartois.butinfo.r304.flatcraft.model.resources.etat;

import fr.univartois.butinfo.r304.flatcraft.model.resources.ICombustible;

public class NonCombustible implements ICombustible{

	@Override
	public boolean isCombustible() {
		return false;
	}

}
