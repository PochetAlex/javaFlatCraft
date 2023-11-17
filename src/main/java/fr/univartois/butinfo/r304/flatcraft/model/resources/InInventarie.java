package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class InInventarie implements IEtatRessource {

	Sprite sprite;

	InInventarie inInvent;
	
	

	public InInventarie(Sprite sprite, InInventarie inInvent) {
		super();
		this.sprite = sprite;
		this.inInvent = inInvent;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public IEtatRessource nextState() {
		return this;
	}

}
