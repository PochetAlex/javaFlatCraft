package fr.univartois.butinfo.r304.flatcraft.model.craft;

import java.util.ArrayList;
import java.util.List;

public class ComplicatedObjectBuilder {

	private List<ProductRule> listeObjets;
	
	public ComplicatedObjectBuilder withField(ProductRule rule) {
		listeObjets.add(rule);
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
