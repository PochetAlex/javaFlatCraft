package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;

public class PasCasse implements BreakABlock{

	@Override
	public void AjouterDansLinventaire(Joueur joueur, Cell cell) {
		// je ne met rien volontairement
		
	}

	@Override
	public BreakABlock ProchainEtat() {
		return new PeuCasse();
	}
	
}
