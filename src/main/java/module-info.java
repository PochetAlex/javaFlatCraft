module fr.univartois.butinfo.r304.flatcraft {
	
  exports fr.univartois.butinfo.r304.flatcraft;
  exports fr.univartois.butinfo.r304.flatcraft.controller;
  exports fr.univartois.butinfo.r304.flatcraft.model;
  exports fr.univartois.butinfo.r304.flatcraft.model.craft;
  exports fr.univartois.butinfo.r304.flatcraft.model.movables;
  exports fr.univartois.butinfo.r304.flatcraft.model.resources;
  exports fr.univartois.butinfo.r304.flatcraft.view;
  exports fr.univartois.butinfo.r304.flatcraft.model.etat;
  exports fr.univartois.butinfo.r304.flatcraft.model.movables.deplacement;
  exports fr.univartois.butinfo.r304.flatcraft.model.dimension;
  exports fr.univartois.butinfo.r304.flatcraft.model.resources.etat;
  exports fr.univartois.butinfo.r304.flatcraft.model.map;

  opens fr.univartois.butinfo.r304.flatcraft.controller to javafx.fxml;

  requires javafx.fxml;
  requires javafx.graphics;
  requires transitive javafx.controls;
}
