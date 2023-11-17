package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public interface IEtatRessource {
	
	public Sprite getSprite();
	
	public IEtatRessource nextState();
}
