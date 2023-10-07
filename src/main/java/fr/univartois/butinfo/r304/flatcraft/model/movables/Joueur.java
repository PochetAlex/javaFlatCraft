package fr.univartois.butinfo.r304.flatcraft.model.movables;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Joueur extends AbstractMovable {
	private IntegerProperty exp;
	private IntegerProperty pdv;
	private ObservableMap<Resource, Integer> inventaire;
	public Joueur(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite) {
		super(game, xPosition, yPosition, sprite);
		exp = new SimpleIntegerProperty(0);
		pdv = new SimpleIntegerProperty(100);
		inventaire = FXCollections.observableHashMap();
	}
	public IntegerProperty getExp() {
		return exp;
	}
	
	public IntegerProperty getPdv() {
		return pdv;
	}
	
	public IntegerProperty expProperty() {
		return exp;
	}
	
	public IntegerProperty pdvProperty() {
		return pdv;
	}
	
	public ObservableMap<Resource, Integer> getInventaire(){
		return inventaire;
	}
	
	public void setExp(IntegerProperty exp) {
		this.exp = exp;
	}
	
	public void setPdv(IntegerProperty pdv) {
		this.pdv = pdv;
	}
	public void setInventaire(ObservableMap<Resource, Integer> inventaire) {
		this.inventaire = inventaire;
	}
	public void ajouterElementInventaire(Resource ressource, int quantite) {
        if (inventaire.get(ressource) == 0) {
            inventaire.put(ressource, quantite);
        }
	}
	public void supprimerElementInventaire(Resource ressource) {
		        if (inventaire.get(ressource) == null || inventaire.get(ressource) <= 0) {
		        	inventaire.remove(ressource);
        }
	}
}