package fr.univartois.butinfo.r304.flatcraft.model.craft;

import java.util.ArrayList;
import java.util.List;

public class ComplicatedObjectBuilder {

	private List<ProductRule> listeObjets;
	
	public ComplicatedObjectBuilder withField(String rule, String produit, int quantite) {
		ProductRule product = new ProductRule();
		product.setRule(rule);
		product.setQuantite(quantite);
		product.setResultat(produit);
		listeObjets.add(product);
		return this;
	}

	public List<ProductRule> getListeObjets() {
		return listeObjets;
	}

	public ComplicatedObjectBuilder() {
		this.listeObjets = new ArrayList<>();
	}
	
	public ComplicatedObject build() {
		return new ComplicatedObject(listeObjets);
	}
}
