package fr.univartois.butinfo.r304.flatcraft.model.resources.etat;

import fr.univartois.butinfo.r304.flatcraft.model.BreakABlock;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.etat.CompletementCasse;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.IContenuCell;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;

public class CelluleAvecRessource implements IContenuCell, BreakABlock{
	private Resource ressource;
	public IContenuCell etatActuel() {
		return this;		
	}
	@Override
	public void ajouterDansLinventaire(Joueur joueur, Cell cell) {
		joueur.ajouterElementInventaire(ressource, 1);
		cell.setContenuCell(new CompletementCasse());
	}
	@Override
	public BreakABlock prochainEtat() {
		return new CompletementCasse();
	}
	@Override
	public IContenuCell etatCellule() {
		return this;
	}
}
