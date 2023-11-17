package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.IContenuCell;

public interface BreakABlock {
	
	public void ajouterDansLinventaire(Joueur joueur, Cell cell); //normal que dans certaine class qui l'implement elle soit vide (elle est remplit que dans CompletementCasse)
	
	public BreakABlock prochainEtat();
	
	public IContenuCell etatActuel();
	
}
