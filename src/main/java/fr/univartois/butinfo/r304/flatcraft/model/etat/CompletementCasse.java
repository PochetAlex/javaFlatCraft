package fr.univartois.butinfo.r304.flatcraft.model.etat;

import fr.univartois.butinfo.r304.flatcraft.model.BreakABlock;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.IContenuCell;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.CelluleSansRessource;

public class CompletementCasse implements BreakABlock{
	
	@Override
	public void ajouterDansLinventaire(Joueur joueur, Cell cell) {
		joueur.ajouterElementInventaire(cell.getResource(), 1);
		
	}

	@Override
	public BreakABlock prochainEtat() {
		return this;
	}

	@Override
	public IContenuCell etatActuel() {
		return new CelluleSansRessource();
	}
	
}
