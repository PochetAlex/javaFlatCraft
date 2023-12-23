package fr.univartois.butinfo.r304.flatcraft.model.movables;

import java.util.Optional;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Inventoriable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Joueur extends AbstractMovable {
	private IntegerProperty exp;
	private IntegerProperty pdv;
	private ObservableMap<Inventoriable, Integer> inventaire;
	public Joueur(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite) {
		super(game, xPosition, yPosition, sprite);
		exp = new SimpleIntegerProperty(0);
		pdv = new SimpleIntegerProperty(100);
		inventaire = FXCollections.observableHashMap();
	}
	public int getExp() {
		return exp.get();
	}
	
	public int getPdv() {
		return pdv.get();
	}
	
	public IntegerProperty expProperty() {
		return exp;
	}
	
	public IntegerProperty pdvProperty() {
		return pdv;
	}
	
	public ObservableMap<Inventoriable, Integer> getInventaire(){
		return inventaire;
	}
	
	
	public void setExp(int v) {
		exp.set(v);
	}
	
	public void setPdv(int v) {
		pdv.set(v);
	}
	public void setInventaire(ObservableMap<Inventoriable, Integer> inventaire) {
		this.inventaire = inventaire;
	}
	public void ajouterElementInventaire(Inventoriable ressource, int quantite) {
		if (inventaire.get(ressource) == null) {
			inventaire.put(ressource, quantite);
		}
		else {
            inventaire.put(ressource, quantite+inventaire.get(ressource));
        }
	}
	public void supprimerElementInventaire(Inventoriable ressource) {
		if (inventaire.get(ressource) == null || inventaire.get(ressource) <= 0) {
			inventaire.remove(ressource);
        }
	}
	
	public Optional<Inventoriable> getRessourceParNom(String nomRessource) {
        for (Inventoriable ressource : inventaire.keySet()) {
            if (ressource.getName().equals(nomRessource)) {
                return Optional.of(ressource);
            }
        }
        return Optional.empty();
    }
}