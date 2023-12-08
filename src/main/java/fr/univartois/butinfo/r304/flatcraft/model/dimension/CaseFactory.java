package fr.univartois.butinfo.r304.flatcraft.model.dimension;

import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.etat.PresqueCasse;
import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.InInventarie;

import java.util.Random;

public class CaseFactory implements CellFactory{
	
	private ISpriteStore spriteStore;
	private InInventarie invent;
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
    public Cell createSky(int y, int i) {
    	// TODO Auto-generated method stub

        
        Case cel;
        if (y < 11 && i != 0 && i != 40 && y > 1 && i!=79) {
        	Random r = new Random();
            int n = r.nextInt(10);
        	if (n < 1) {
                cel = new Case(spriteStore.getSprite("default_cloud"));
            } else {
                cel = new Case(spriteStore.getSprite("default_ice"));
            }
        } else {
        	cel = new Case(spriteStore.getSprite("default_ice"));
        }
        
        return cel;
    }

	@Override
	public Cell createSoilSurface() {
		// TODO Auto-generated method stub
        Case cel;
        Resource re = new Resource("dirt",new InInventarie(spriteStore.getSprite("default_grass"),null),null,new PresqueCasse());
        cel = new Case(re);
		return cel;
	}

	@Override
	public Cell createSubSoil() {
		Case cel;
		Random r = new Random();
        int n = r.nextInt(200);
        if (n < 190) {
        	cel = new Case(new Resource("cobble",new InInventarie(spriteStore.getSprite("default_cobble"),null),null,new PresqueCasse()));
        } else if (n == 190) {
        	cel = new Case(new Resource("diamond_mineral",new InInventarie(spriteStore.getSprite("default_mineral_diamond"),null),null,new PresqueCasse()));
        } else if (n == 191){
        	cel = new Case(new Resource("gold_mineral",new InInventarie(spriteStore.getSprite("default_mineral_gold"),null),null,new PresqueCasse()));
        } else if (n == 192){
        	cel = new Case(new Resource("copper_mineral",new InInventarie(spriteStore.getSprite("default_mineral_copper"),null),null,new PresqueCasse()));
        } else if (n == 193){
        	cel = new Case(new Resource("mese_mineral",new InInventarie(spriteStore.getSprite("default_mineral_mese"),null),null,new PresqueCasse()));
        } else if (n == 194){
        	cel = new Case(new Resource("coal_mineral",new InInventarie(spriteStore.getSprite("default_mineral_coal"),null),null,new PresqueCasse()));
        } else if (n == 195){
        	cel = new Case(new Resource("iron_mineral",new InInventarie(spriteStore.getSprite("default_mineral_iron"),null),null,new PresqueCasse()));
        } else if (n == 196){
        	cel = new Case(new Resource("gravel",new InInventarie(spriteStore.getSprite("default_gravel"),null),null,new PresqueCasse()));
        } else {
        	cel = new Case(new Resource("cobble",new InInventarie(spriteStore.getSprite("default_cobble"),null),null,new PresqueCasse()));
        }
        
		return cel;
	}

	@Override
	public Cell createTrunk() {
		Case cel = new Case(new Resource("acacia wood",new InInventarie(spriteStore.getSprite("default_acacia_tree"),null),null,new PresqueCasse()));
		return cel;
	}

	@Override
	public Cell createLeaves() {
		Case cel = new Case(new Resource("acacia_leave",new InInventarie(spriteStore.getSprite("default_acacia_leaves"),null),null,new PresqueCasse()));
		return cel;
	}

}
