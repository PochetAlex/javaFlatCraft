package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;

public class GenerateGameMap {

	private int hauteur,largeur;
	private CellFactory cell;
	private SimpleGameMap gameMap;

	public SimpleGameMap createCarte(int hauteur,int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		gameMap = new SimpleGameMap(hauteur, largeur, hauteur/3);
		for(int i = 0; i<=largeur; i++) {
			for(int y=0; y<= hauteur; y++) {
				if(y>hauteur/3) {
					gameMap.setAt(i, y, cell.createSky());
				}
				if(y==hauteur/3) {
					gameMap.setAt(i, y, cell.createSoilSurface());
				}
				if(y<hauteur/3) {
					gameMap.setAt(i, y, cell.createSubSoil());
				}
			}
		}
		return this.gameMap;
	}
	
	
}
