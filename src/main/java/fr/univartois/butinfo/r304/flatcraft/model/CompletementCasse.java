package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;

public class CompletementCasse implements BreakABlock{
	
	@Override
	public void AjouterDansLinventaire(Joueur joueur, Cell cell) {
		joueur.ajouterElementInventaire(cell.getResource(), 1);
		
	}

	@Override
	public BreakABlock ProchainEtat() {
		return this;
	}
	
}
