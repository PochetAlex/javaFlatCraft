package fr.univartois.butinfo.r304.flatcraft.model.craft;

import java.util.Objects;

public class ProductRule {
	
	private String rule;
	private int quantite;
	private String resultat;
	
	@Override
	public int hashCode() {
		return Objects.hash(rule);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductRule other = (ProductRule) obj;
		return Objects.equals(rule, other.rule);
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	
	
}
