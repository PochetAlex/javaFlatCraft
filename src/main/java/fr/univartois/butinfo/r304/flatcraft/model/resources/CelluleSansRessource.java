package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;

public class CelluleSansRessource implements IContenuCell{

	public IContenuCell etatCellule() {
		return this;
	}

	@Override
	public void ajouterDansLinventaire(Joueur joueur, Cell cell) {
		//rien dans la methode
	}
}
