package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CaseFactory;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

public class Terril implements IGenerateGameMap {

	private int taille;
	private IGenerateGameMap mapBase;
	private CellFactory cell;

	public Terril(int taille,IGenerateGameMap mapBase) {
		this.taille = taille;
		this.mapBase = mapBase;
		
	}
	
	@Override
	public SimpleGameMap returnMapCreate(ISpriteStore sprite ) {
		
		SimpleGameMap gameMap = mapBase.returnMapCreate(sprite);
		this.cell = new CaseFactory(sprite);
		int hauteurSol = gameMap.getSoilHeight();
		
		for(int i = 0; i<gameMap.getWidth(); i++) {
			if (i==16) {
				for(int y=0; y< gameMap.getHeight(); y++) {
					if(y==hauteurSol-1) {
						gameMap.setAt(y, i, cell.createSoilSurface());
					}
				}
			}
			
		}
		return gameMap;
	}

}
