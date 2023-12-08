package fr.univartois.butinfo.r304.flatcraft.model.resources.etat;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.IContenuCell;

public class CelluleSansRessource implements IContenuCell{

	public IContenuCell etatCellule() {
		return this;
	}

	@Override
	public void ajouterDansLinventaire(Joueur joueur, Cell cell) {
		//rien dans la methode
	}
}
