package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.model.CompletementCasse;

public class CelluleSansRessource implements IContenuCell{

	public IContenuCell etatCellule() {
		return (IContenuCell) new CompletementCasse();
	}
}
