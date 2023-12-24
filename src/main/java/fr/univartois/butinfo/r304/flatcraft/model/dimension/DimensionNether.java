package fr.univartois.butinfo.r304.flatcraft.model.dimension;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.etat.PasCasse;
import fr.univartois.butinfo.r304.flatcraft.model.etat.PresqueCasse;
import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.Combustible;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.InInventarie;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.NonCombustible;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;

public class DimensionNether implements CellFactory {
	private ISpriteStore spriteStore;
    private static final DimensionNether INSTANCE = new DimensionNether(SpriteStore.getInstance()); 

    public DimensionNether(ISpriteStore spriteStore) {
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
	public Cell createSky(int y, int i) {
		return new Case(spriteStore.getSprite("default_lava"));
	}

	public Cell createSoilSurface() {
		return new Case(new Resource("obsidian_brick",new InInventarie(spriteStore.getSprite("default_obsidian_brick"), null) ,null,new PasCasse(), new NonCombustible()));
	}

	@Override
	public Cell createSubSoil() {
		return new Case(new Resource("obsidian",new InInventarie(spriteStore.getSprite("default_obsidian"),null),null,new PasCasse(), new NonCombustible()));
	}

	@Override
	public Cell createTrunk() {
		return new Case(new Resource("acacia_tree",new InInventarie(spriteStore.getSprite("default_acacia_tree"),null),null,new PresqueCasse(), new Combustible()));
	}

	@Override
	public Cell createLeaves() {
		return new Case(new Resource("acacia_leave",new InInventarie(spriteStore.getSprite("default_acacia_leaves"),null),null,new PresqueCasse(), new NonCombustible()));
	}


}
