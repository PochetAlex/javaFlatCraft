package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.model.BreakABlock;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CompletementCasse;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;

public class CelluleAvecRessource implements IContenuCell, BreakABlock{
	private BreakABlock block;
	public IContenuCell etatActuel() {
		return null;		
	}
	@Override
	public void ajouterDansLinventaire(Joueur joueur, Cell cell) {
		
	}
	@Override
	public BreakABlock prochainEtat() {
		return new CompletementCasse();
	}
	@Override
	public IContenuCell etatCellule() {
		return null;
	}
}
