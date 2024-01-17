package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.etat.CompletementCasse;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Inventoriable;
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
			this.getResource().dig((Joueur) player, this);
		}

		return false;
	}

	@Override
	public void setContenuCell(CompletementCasse completementCasse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setResource(Inventoriable resource) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}


}
