package fr.univartois.butinfo.r304.flatcraft.model;

import java.util.Random;

import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;

public class DimensionNether implements CellFactory {
	private ISpriteStore spriteStore;
    private static final DimensionNether INSTANCE = new DimensionNether(SpriteStore.getInstance()); 

    private DimensionNether(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public static synchronized DimensionNether getInstance() {
        return INSTANCE;
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
        	cel = new Case(spriteStore.getSprite("default_lava"));
        }
        else {
        	cel = new Case(spriteStore.getSprite("default_lava"));
        }
		return cel;
	}

	public Cell createSoilSurface() {
        Case cel;
        Resource re = new Resource("a",spriteStore.getSprite("default_obsidian_brick"),null,1);
        cel = new Case(re);
		return cel;
	}

	@Override
	public Cell createSubSoil() {
		// TODO Auto-generated method stub
        Case cel = new Case(new Resource("a",spriteStore.getSprite("default_obsidian"),null,1));
		return cel;
	}

	@Override
	public Cell createTrunk() {
		Case cel = new Case(new Resource("a",spriteStore.getSprite("default_acacia_tree"),null,1));
		return cel;
	}

	@Override
	public Cell createLeaves() {
		Case cel = new Case(new Resource("a",spriteStore.getSprite("default_acacia_leaves"),null,1));
		return cel;
	}


}
