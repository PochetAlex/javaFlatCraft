package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.dimension.DimensionNether;
import fr.univartois.butinfo.r304.flatcraft.model.etat.CompletementCasse;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Inventoriable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class Case extends AbstractCell {
	private DimensionNether dimensionNether;

	protected Case(int row, int column) {
		super(row, column);
	}

	public Case(Resource resource) {
		super(resource);
	}

	public Case(Sprite sprite) {
		super(sprite);
	}

	@Override
	public boolean move(IMovable movable) {
		if (this.getResource() == null) {
			movable.setY(getRow() * this.getSprite().getHeight());
			movable.setX(getColumn() * this.getSprite().getHeight());
			return true;
		}
		return false;
	}

	@Override
	public boolean dig(IMovable player) {
	    if (this.getResource() != null) {
	        // Récupérer le nom de la ressource sur cette cellule
	        String resourceName = this.getResource().getName();
	        System.out.println("Digging resource: " + resourceName); // Ajout de message de débogage

	        // Si la ressource est "default_mese_block", alors changer de dimension
	        if ("default_mese_block".equals(resourceName)) {
	            System.out.println("Teleporting to Nether!"); // Ajout de message de débogage

	            // Récupérer la dimension Nether depuis FlatcraftGame
	            DimensionNether dimensionNether = FlatcraftGame.getNetherDimension();
	            
	        } else {
	            // Si ce n'est pas "default_mese_block", traiter normalement
	            this.getResource().dig((Joueur) player, this);
	        }
	    }

	    return false;
	}
	@Override
	public boolean setResource(Inventoriable resource) {
		Object map;
		if ("default_mese_block".equals(resource.getName())) {
	        Object player = null;
			FlatcraftGame game = null;
			// Transition vers la dimension Nether
	        game.teleportToNether((Joueur) player);
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean accepts(IMovable movable) {
		if (this.getResource() != null) {
			return false;
		}else return true;
	}

	@Override
	public void execute() {
		if (getResource() != null) {
	        getResource().execute();
	    }
	}

	@Override
	public void setContenuCell(CompletementCasse completementCasse) {
		// TODO Auto-generated method stub
		
	}
}
