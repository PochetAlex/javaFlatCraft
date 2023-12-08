package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CaseFactory;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

import java.util.Random;

public class Arbre implements IGenerateGameMap {
    private IGenerateGameMap mapBase;
    private CellFactory cell;
    private int nombreArbres;
    private int hauteurMaxTronc;

    public Arbre(int nombreArbres, int hauteurMaxTronc, IGenerateGameMap mapBase) {
        this.mapBase = mapBase;
        this.nombreArbres = nombreArbres;
        this.hauteurMaxTronc = hauteurMaxTronc;
    }

    @Override
    public SimpleGameMap returnMapCreate(ISpriteStore sprite) {
        SimpleGameMap gameMap = mapBase.returnMapCreate(sprite);
        this.cell = CaseFactory.getInstance();

        for (int arbre = 0; arbre < nombreArbres; arbre++) {
            Random r = new Random();
            int hauteurSol = gameMap.getSoilHeight() - 1;
            int position = r.nextInt(5, gameMap.getWidth() - 15);
            int hauteurTronc = r.nextInt(1, hauteurMaxTronc);

            for (int i = position; i < position + 1; i++) {
                for (int y = hauteurSol; y > hauteurSol - hauteurTronc; y--) {
                    gameMap.setAt(y, i, cell.createTrunk());
                }
                addLeavesPyramid(gameMap, i, hauteurSol - hauteurTronc, 3);
            }
        }

        return gameMap;
    }

    private void addLeavesPyramid(SimpleGameMap gameMap, int x, int startY, int height) {
        for (int y = startY; y > startY - height; y--) {
            int radius = height - (startY - y);
            for (int offsetX = -radius; offsetX <= radius; offsetX++) {
                for (int offsetY = -radius; offsetY <= radius; offsetY++) {
                    if (Math.abs(offsetX) + Math.abs(offsetY) <= radius) {
                        gameMap.setAt(y, x + offsetX, cell.createLeaves());
                    }
                }
            }
        }
    }
}
