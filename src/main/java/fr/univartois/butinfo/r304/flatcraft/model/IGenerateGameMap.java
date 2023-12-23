package fr.univartois.butinfo.r304.flatcraft.model;

import fr.univartois.butinfo.r304.flatcraft.model.map.SimpleGameMap;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

public interface IGenerateGameMap {

	SimpleGameMap returnMapCreate(ISpriteStore sprite );

}