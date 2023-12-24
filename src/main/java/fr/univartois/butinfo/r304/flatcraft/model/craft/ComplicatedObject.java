package fr.univartois.butinfo.r304.flatcraft.model.craft;

import java.util.List;

public class ComplicatedObject {

	private List<ProductRule> listeObjets;

	public ComplicatedObject(List<ProductRule> listeObjets) {
		this.listeObjets = listeObjets;
	}
	
	public String produitOuExiste(ProductRule product) {
        if (listeObjets.contains(product)) {
            for (int i = 0; i<listeObjets.size(); i++) {
            	if (listeObjets.get(i).getRule().equals(product.getRule())) {
            		return listeObjets.get(i).getResultat();
            	}
            }
        } else {
            return null;
        }
		return null;
    }

	public List<ProductRule> getListeObjets() {
		return listeObjets;
	}
	
	

	
}
