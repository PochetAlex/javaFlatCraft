package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;

public interface IContenuCell {
	public IContenuCell etatCellule();

	void ajouterDansLinventaire(Joueur joueur, Cell cell);
}
