package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;

public class Portail implements Inventoriable {

    private final String name;
    private final ToolType toolType;

    public Portail(String name, ToolType toolType) {
        this.name = name;
        this.toolType = toolType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Sprite getSprite() {
        // Retourne le sprite du portail
        return SpriteStore.getInstance().getSprite("portal_sprite");
    }

    @Override
    public ToolType getToolType() {
        return toolType;
    }

    @Override
    public void addToInventory() {
        // Logique pour ajouter le portail à l'inventaire
    }

    @Override
    public void execute() {
        // Logique pour changer de carte (dimension) ici
        // Vous pouvez appeler la méthode appropriée pour réaliser le changement
        // (par exemple, changerMap() si elle existe dans votre modèle)
    }
}
