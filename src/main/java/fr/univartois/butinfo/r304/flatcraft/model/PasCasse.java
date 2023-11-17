package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.CelluleAvecRessource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.IContenuCell;

public class PasCasse implements BreakABlock{

	@Override
	public void ajouterDansLinventaire(Joueur joueur, Cell cell) {
		// je ne met rien volontairement
		
	}

	@Override
	public BreakABlock prochainEtat() {
		return new PeuCasse();
	}

	@Override
	public IContenuCell etatActuel() {
		return new CelluleAvecRessource();
	}
	
}
