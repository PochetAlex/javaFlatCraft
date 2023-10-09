package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import java.util.Random;

public class CaseFactory implements CellFactory{
	
	private ISpriteStore spriteStore;

	public CaseFactory(ISpriteStore spriteStore) {
		this.spriteStore = spriteStore;
	}

	@Override
	public void setSpriteStore(ISpriteStore spriteStore) {
		this.spriteStore = spriteStore;
		
	}

	@Override
	public Cell createSky() {
		// TODO Auto-generated method stub
		Random r = new Random();
        int n = r.nextInt(5);
        Case cel;
        if (n < 2) {
        	cel = new Case(spriteStore.getSprite("default_cloud"));
        }
        else {
        	cel = new Case(spriteStore.getSprite("air"));
        }
		return cel;
	}

	@Override
	public Cell createSoilSurface() {
		// TODO Auto-generated method stub
		Random r = new Random();
        int n = r.nextInt(5);
        Case cel;
        if (n == 1) cel = new Case(spriteStore.getSprite("default_brick"));
        else if (n == 2) cel = new Case(spriteStore.getSprite("default_dirt"));
        else if (n == 3) cel = new Case(spriteStore.getSprite("default_grass"));
        else if (n == 4) cel = new Case(spriteStore.getSprite("default_sand"));
        else cel = new Case(spriteStore.getSprite("default_water"));
		return cel;
	}

	@Override
	public Cell createSubSoil() {
		// TODO Auto-generated method stub
        Case cel = new Case(spriteStore.getSprite("defaut_cobble"));
		return cel;
	}

	@Override
	public Cell createTrunk() {
		Case cel = new Case(spriteStore.getSprite("defaut_acacia_tree"));
		return cel;
	}

	@Override
	public Cell createLeaves() {
		Case cel = new Case(spriteStore.getSprite("defaut_acacia_leaves"));
		return cel;
	}

}
