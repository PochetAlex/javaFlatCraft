package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CaseFactory;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
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
        this.cell = new CaseFactory(sprite);

        for (int arbre = 0; arbre < nombreArbres; arbre++) {
            Random r = new Random();
            int hauteurSol = gameMap.getSoilHeight()-1;
            int position = r.nextInt(5, gameMap.getWidth() - 15);
            int hauteurTronc = r.nextInt(1,hauteurMaxTronc);

            for (int i = position; i < position + 1; i++) {
                for (int y = hauteurSol; y > hauteurSol - hauteurTronc; y--) {
                    gameMap.setAt(y, i, cell.createTrunk());
                }
                for (int y = hauteurSol - hauteurTronc; y > hauteurSol - hauteurTronc - 3; y--) {
                    gameMap.setAt(y, i, cell.createLeaves());
                }
            }
        }

        return gameMap;
    }
}
