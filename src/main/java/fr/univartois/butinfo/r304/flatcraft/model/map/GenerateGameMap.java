package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CaseFactory;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

public class GenerateGameMap implements IGenerateGameMap {

	private int hauteur,largeur;
	private CellFactory cell;
	private SimpleGameMap gameMap;
	private ISpriteStore sprite;

	public GenerateGameMap(int hauteur,int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.gameMap = new SimpleGameMap(hauteur, largeur, hauteur/2);
	}
	
	@Override
	public SimpleGameMap returnMapCreate(ISpriteStore sprite ) {
		this.sprite = sprite;
		this.cell = new CaseFactory(sprite);
		for(int i = 0; i<largeur; i++) {
			for(int y=0; y< hauteur; y++) {
				if(y>hauteur/2) {
					gameMap.setAt(y, i, cell.createSubSoil());
				}
				if(y==hauteur/2) {
					gameMap.setAt(y, i, cell.createSoilSurface());
				}
				if(y<hauteur/2) {
					gameMap.setAt(y, i, cell.createSky());
				}
			}
		}
		return gameMap;
	}
	
}
