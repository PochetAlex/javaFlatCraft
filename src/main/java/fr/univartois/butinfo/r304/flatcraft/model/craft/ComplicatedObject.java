package fr.univartois.butinfo.r304.flatcraft.model.craft;

import java.util.List;

public class ComplicatedObject {

	private List<ProductRule> listeObjets;

	public ComplicatedObject(List<ProductRule> listeObjets) {
		this.listeObjets = listeObjets;
	}
	
	public String produitOuExiste(ProductRule product) {
        if (listeObjets.contains(product)) {
            return product.getResultat();
        } else {
            return null;
        }
    }

	
}
