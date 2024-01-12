package fr.univartois.butinfo.r304.flatcraft.model.resources;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class PlusieursProduit implements Inventoriable{
	private List<Inventoriable> composants = new ArrayList<>();

    // Ajoute un composant � la composition
    public void addComponent(Inventoriable composant) {
        composants.add(composant);
    }

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolType getToolType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void addToInventory() {
        // Ajoute chaque composant � l'inventaire
        composants.forEach(Inventoriable::addToInventory);
    }

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
