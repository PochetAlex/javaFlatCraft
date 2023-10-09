package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class Case extends AbstractCell{

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
		if (this.getResource()==null) {
			movable.setX(getRow()*this.getSprite().getWidth());
			movable.setY(getColumn()*this.getSprite().getHeight());
			return true;
		}
		return false;
	}

	@Override
	public boolean dig(Joueur player) {
		this.getResource().dig();
		if (this.getResource().getHardness()==0) {
			player.ajouterElementInventaire(this.getResource());
			return true;
		}
		return false;
	}

}
