package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class UnProduit implements Inventoriable {
	private String name;
	private Sprite sprite;
	private ToolType type;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public ToolType getToolType() {
		return type;
	}

	@Override
	public void addToInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}



}
