package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;
import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;

import java.util.Random;

public class CaseFactory implements CellFactory{
	
	private ISpriteStore spriteStore;
    private static final CaseFactory INSTANCE = new CaseFactory(SpriteStore.getInstance());

    private CaseFactory(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public static CaseFactory getInstance() {
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
            cel = new Case(spriteStore.getSprite("default_obsidian_glass_detail"));
        } else {
            cel = new Case(spriteStore.getSprite("default_obsidian_glass_detail"));
        }
        return cel;
    }

	@Override
	public Cell createSoilSurface() {
		// TODO Auto-generated method stub
        Case cel;
        Resource re = new Resource("a",spriteStore.getSprite("default_grass"),null,new PresqueCasse());
        cel = new Case(re);
		return cel;
	}

	@Override
	public Cell createSubSoil() {
		// TODO Auto-generated method stub
        Case cel = new Case(new Resource("a",spriteStore.getSprite("default_dirt"),null,new PresqueCasse()));
		return cel;
	}

	@Override
	public Cell createTrunk() {
		Case cel = new Case(new Resource("a",spriteStore.getSprite("default_acacia_tree"),null,new PresqueCasse()));
		return cel;
	}

	@Override
	public Cell createLeaves() {
		Case cel = new Case(new Resource("a",spriteStore.getSprite("default_acacia_leaves"),null,new PresqueCasse()));
		return cel;
	}

}
