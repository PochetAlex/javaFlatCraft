package fr.univartois.butinfo.r304.flatcraft.model;

import java.util.Random;

import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import fr.univartois.butinfo.r304.flatcraft.model.resources.InInventarie;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;

public class DimensionEnd implements CellFactory {
	private ISpriteStore spriteStore;
	private InInventarie invent;
    private static final DimensionEnd INSTANCE = new DimensionEnd(SpriteStore.getInstance()); 

    private DimensionEnd(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public static DimensionEnd getInstance() {
        return INSTANCE;
    }
    
    @Override
	public void setSpriteStore(ISpriteStore spriteStore) {
		this.spriteStore = spriteStore;	
	}
    
	@Override
	public Cell createSky(int y, int i) {
		Random r = new Random();
        int n = r.nextInt(5);
        Case cel;
        if (n < 2) {
        	cel = new Case(spriteStore.getSprite("default_coal_block"));
        }
        else {
        	cel = new Case(spriteStore.getSprite("default_coal_block"));
        }
		return cel;
	}

	@Override
	public Cell createSoilSurface() {
		// TODO Auto-generated method stub
        Case cel;
        Resource re = new Resource("a",invent = new InInventarie(spriteStore.getSprite("default_sandstone_brick"),null),null, new PasCasse());
        cel = new Case(re);
		return cel;
	}

	@Override
	public Cell createSubSoil() {
		// TODO Auto-generated method stub
        Case cel = new Case(new Resource("a",invent = new InInventarie(spriteStore.getSprite("default_sandstone"),null),null,new PasCasse()));
		return cel;
	}

	@Override
	public Cell createTrunk() {
		Case cel = new Case(new Resource("a",invent = new InInventarie(spriteStore.getSprite("default_acacia_tree"),null),null,new PresqueCasse()));
		return cel;
	}

	@Override
	public Cell createLeaves() {
		Case cel = new Case(new Resource("a",invent = new InInventarie(spriteStore.getSprite("default_acacia_leaves"),null),null,new PresqueCasse()));
		return cel;
	}


}
