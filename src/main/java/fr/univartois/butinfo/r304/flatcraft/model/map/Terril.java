package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CaseFactory;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

import java.util.Random;

public class Terril implements IGenerateGameMap {
    private IGenerateGameMap mapBase;
    private int tailleLimite;
    private static final Random RANDOM = new Random();

    public Terril(int tailleLimite, IGenerateGameMap mapBase) {
        this.mapBase = mapBase;
        this.tailleLimite = tailleLimite;
    }

    @Override
    public SimpleGameMap returnMapCreate(ISpriteStore sprite) {
        CellFactory cell;
        SimpleGameMap gameMap = mapBase.returnMapCreate(sprite);
        cell = CaseFactory.getInstance();

        int hauteurSol = gameMap.getSoilHeight();
        int hauteurCourante = hauteurSol - 1;
        int largeurCourante = RANDOM.nextInt(5, gameMap.getWidth() - 15);
        

        for (int taille = tailleLimite; taille >= 1; taille -= 2) {
            for (int i = 0; i < taille; i++) {
                gameMap.setAt(hauteurCourante, largeurCourante + i, cell.createSoilSurface());
            }
            hauteurCourante--;
            largeurCourante++;
        }

        return gameMap;
    }
}
