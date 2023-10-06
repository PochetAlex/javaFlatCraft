package fr.univartois.butinfo.r304.flatcraft.model.movables;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Joueur extends AbstractMovable {
	private IntegerProperty exp;
	private IntegerProperty pdv;
	private ObservableMap<Resource, Integer> inventaire;
	public Joueur(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite, IntegerProperty exp, IntegerProperty pdv, ObservableMap<Resource, Integer> inventaire) {
		super(game, xPosition, yPosition, sprite);
		this.exp = exp;
		this.pdv = pdv;
		inventaire = FXCollections.observableHashMap();
	}
}