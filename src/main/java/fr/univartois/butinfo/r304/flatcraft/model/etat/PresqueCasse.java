package fr.univartois.butinfo.r304.flatcraft.model.etat;

import fr.univartois.butinfo.r304.flatcraft.model.BreakABlock;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.IContenuCell;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.CelluleAvecRessource;

public class PresqueCasse implements BreakABlock{

	@Override
	public void ajouterDansLinventaire(Joueur joueur, Cell cell) {
		//je met rien volontairement
	}

	@Override
	public BreakABlock prochainEtat() {
		return new CompletementCasse();
	}

	@Override
	public IContenuCell etatActuel() {
		return new CelluleAvecRessource();
	}
	
}
