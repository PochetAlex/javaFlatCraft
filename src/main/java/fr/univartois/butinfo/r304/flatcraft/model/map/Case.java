package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class Case extends AbstractCell {

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
			System.out.println(this.getResource().getHardness());
			this.getResource().dig((Joueur) player, this);
		}

		return false;
	}


}
