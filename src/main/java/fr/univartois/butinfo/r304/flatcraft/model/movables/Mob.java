package fr.univartois.butinfo.r304.flatcraft.model.movables;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Mob extends AbstractMovable{

	private IntegerProperty pdv;
	public Mob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite,int pdv) {
		super(game, xPosition, yPosition, sprite);
		this.pdv = new SimpleIntegerProperty(pdv);
	}
	
	public boolean move(long delta) {
		setHorizontalSpeed(24);
		return super.move(delta);
    }
	
	

}
