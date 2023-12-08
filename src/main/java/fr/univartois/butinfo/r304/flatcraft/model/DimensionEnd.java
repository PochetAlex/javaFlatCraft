package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import fr.univartois.butinfo.r304.flatcraft.model.resources.InInventarie;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;

public class DimensionEnd implements CellFactory {
	private ISpriteStore spriteStore;
    private static final DimensionEnd INSTANCE = new DimensionEnd(SpriteStore.getInstance()); 

    DimensionEnd(ISpriteStore spriteStore) {
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
		return new Case(spriteStore.getSprite("default_coal_block"));
	}

	@Override
	public Cell createSoilSurface() {
		return new Case(new Resource("a",new InInventarie(spriteStore.getSprite("default_sandstone_brick"),null),null, new PasCasse()));
	}

	@Override
	public Cell createSubSoil() {
		return new Case(new Resource("a",new InInventarie(spriteStore.getSprite("default_sandstone"),null),null,new PasCasse()));
	}

	@Override
	public Cell createTrunk() {
		return new Case(new Resource("a",new InInventarie(spriteStore.getSprite("default_acacia_tree"),null),null,new PresqueCasse()));
	}

	@Override
	public Cell createLeaves() {
		return new Case(new Resource("a",new InInventarie(spriteStore.getSprite("default_acacia_leaves"),null),null,new PresqueCasse()));
	}


}
