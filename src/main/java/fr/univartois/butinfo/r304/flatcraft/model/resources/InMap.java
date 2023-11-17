package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class InMap implements IEtatRessource{
	
	Sprite sprite;
	
	InInventarie inInvent;
	
	
	

	public InMap(Sprite sprite, InInventarie inInvent) {
		super();
		this.sprite = sprite;
		this.inInvent = inInvent;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public IEtatRessource nextState() {
		return inInvent;
	}

}
