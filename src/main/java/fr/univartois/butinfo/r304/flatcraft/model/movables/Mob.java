package fr.univartois.butinfo.r304.flatcraft.model.movables;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement.DeplacementAlea;
import fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement.DeplacementAleatoireParSequence;
import fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement.DeplacementLineaire;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Mob extends AbstractMovable {

	private IntegerProperty pdv;
	
	private int faconMouv;

	public Mob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite, int pdv, int faconMouv) {
		super(game, xPosition, yPosition, sprite);
		this.pdv = new SimpleIntegerProperty(pdv);
		this.faconMouv = faconMouv;
		setHorizontalSpeed(24);
	}

	@Override
	public boolean move(long delta) {
		if (!super.move(delta)) {
			setHorizontalSpeed(DeplacementLineaire.faconMove(this.getHorizontalSpeed(), this, delta));
			return super.move(delta);
		}
		if (faconMouv == 0) {
			setHorizontalSpeed(DeplacementAleatoireParSequence.faconMove(this.getHorizontalSpeed(), this, delta));
			return super.move(delta);
		}
		if (faconMouv == 1 && !super.move(delta)) {
			setHorizontalSpeed(DeplacementLineaire.faconMove(this.getHorizontalSpeed(), this, delta));
			return super.move(delta);
		}
		if (faconMouv == 2) {
			setHorizontalSpeed(DeplacementAlea.faconMove(this.getHorizontalSpeed(), this, delta));
			return super.move(delta);
		}
		
		return super.move(delta);
	}

}
