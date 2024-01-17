/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.r304.flatcraft.model;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import fr.univartois.butinfo.r304.flatcraft.controller.FlatcraftController;
import fr.univartois.butinfo.r304.flatcraft.model.craft.ComplicatedObject;
import fr.univartois.butinfo.r304.flatcraft.model.craft.ProductRule;
import fr.univartois.butinfo.r304.flatcraft.model.craft.RuleParser;
import fr.univartois.butinfo.r304.flatcraft.model.dimension.DimensionEnd;
import fr.univartois.butinfo.r304.flatcraft.model.dimension.DimensionNether;
import fr.univartois.butinfo.r304.flatcraft.model.etat.PresqueCasse;
import fr.univartois.butinfo.r304.flatcraft.model.map.Arbre;
import fr.univartois.butinfo.r304.flatcraft.model.map.GenerateGameMap;
import fr.univartois.butinfo.r304.flatcraft.model.map.SimpleGameMap;
import fr.univartois.butinfo.r304.flatcraft.model.map.Terril;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Joueur;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Mob;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Inventoriable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.ToolType;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.InInventarie;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.NonCombustible;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableMap;

/**
 * La classe {@link FlatcraftGame} permet de gérer une partie du jeu Flatcraft.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class FlatcraftGame {

	private IGenerateGameMap iMap;
	
    /**
     * La largeur de la carte du jeu affichée (en pixels).
     */
    private final int width;

    /**
     * La hauteur de la carte du jeu affichée (en pixels).
     */
    private final int height;

    /**
     * Le nombre de fois que la carte se "répète" horizontalement.
     */
    private final int mapRepeat;

    /**
     * Le contrôleur de l'application.
     */
    private IFlatcraftController controller;

    /**
     * L'instance e {@link ISpriteStore} utilisée pour créer les sprites du jeu.
     */
    private ISpriteStore spriteStore;

    /**
     * L'instance de {@link CellFactory} utilisée pour créer les cellules du jeu.
     */
    private CellFactory cellFactory;

    /**
     * La carte du jeu, sur laquelle le joueur évolue.
     */
    private GameMap map;

    /**
     * La position à gauche de la carte dans la fenêtre.
     * Celle-ci change lorsque l'utilisateur se déplace horizontalement.
     */
    private IntegerProperty leftAnchor = new SimpleIntegerProperty(0);

    /**
     * Le temps écoulé depuis le début de la partie.
     */
    private IntegerProperty time = new SimpleIntegerProperty(12);

    /**
     * Le niveau actuel de la partie.
     */
    private IntegerProperty level = new SimpleIntegerProperty(1);

    /**
     * La représentation du joueur.
     */
    private Joueur player;
    
    private Mob mob;
    
    private ComplicatedObject craftableObject;
    
    private ComplicatedObject furnaceObject;

    /**
     * La dernière direction suivie par le joueur.
     * Elle est stockée sous la forme d'un entier, afin d'indiquer s'il avance ou s'il
     * recule.
     */
    private int lastDirection = 1;

    /**
     * L'iterateur permettant de parcourir les ressources contenues dans l'inventaire du
     * joueur.
     */
    private Iterator<Inventoriable> inventoryIterator;

    /**
     * La liste des objets mobiles du jeu.
     */
    private List<IMovable> movableObjects = new CopyOnWriteArrayList<>();

    /**
     * L'animation simulant le temps qui passe dans le jeu.
     */
    private FlatcraftAnimation animation = new FlatcraftAnimation(this, movableObjects);

    /**
     * Crée une nouvelle instance de FlatcraftGame.
     *
     * @param width La largeur de la carte du jeu (en pixels).
     * @param height La hauteur de la carte du jeu (en pixels).
     * @param mapRepeat Le nombre de fois que la carte se "répète" horizontalement.
     * @param spriteStore L'instance de {@link ISpriteStore} permettant de créer les
     *        {@link Sprite} du jeu.
     * @param factory La fabrique permettant de créer les cellules du jeux.
     */
    public FlatcraftGame(int width, int height, int mapRepeat, ISpriteStore spriteStore,
            CellFactory factory) {
        this.width = width;
        this.height = height;
        this.mapRepeat = mapRepeat;
        this.spriteStore = spriteStore;
        this.cellFactory = factory;
        this.cellFactory.setSpriteStore(spriteStore);
    }


    /**
     * Donne la largeur de la carte du jeu affichée (en pixels).
     *
     * @return La largeur de la carte du jeu affichée (en pixels).
     */
    public int getWidth() {
        return width * mapRepeat;
    }
    
    

	public Joueur getPlayer() {
		return player;
	}

	public void setiMap(IGenerateGameMap iMap) {
		this.iMap = iMap;
	}

	/**
     * Donne la hauteur de la carte du jeu affichée (en pixels).
     *
     * @return La hauteur de la carte du jeu affichée (en pixels).
     */
    public int getHeight() {
        return height;
    }

    /**
     * Associe à cette partie le contrôleur gérant l'affichage du jeu.
     *
     * @param controller Le contrôleur gérant l'affichage.
     */
    public void setController(IFlatcraftController controller) {
        this.controller = controller;
    }

    /**
     * Prépare la partie de Flatcraft avant qu'elle ne démarre.
     * @throws IOException 
     */
    public void prepare() throws IOException {
        // On crée la carte du jeu.
        map = createMap();
        controller.prepare(map);
        
        player = new Joueur(this, 0, map.getSoilHeight()*SpriteStore.getInstance().getSpriteSize()-SpriteStore.getInstance().getSpriteSize(), spriteStore.getSprite("player"));
        movableObjects.add(player);
        controller.addMovable(player);
        
        mob = new Mob(this, 50, map.getSoilHeight()*SpriteStore.getInstance().getSpriteSize()-SpriteStore.getInstance().getSpriteSize(), spriteStore.getSprite("marjo"), 50, 0);
        movableObjects.add(mob);
        controller.addMovable(mob);
        
        mob = new Mob(this, 150, map.getSoilHeight()*SpriteStore.getInstance().getSpriteSize()-SpriteStore.getInstance().getSpriteSize(), spriteStore.getSprite("hugo2"), 50, 1);
        movableObjects.add(mob);
        controller.addMovable(mob);
        
        mob = new Mob(this, 300, map.getSoilHeight()*SpriteStore.getInstance().getSpriteSize()-SpriteStore.getInstance().getSpriteSize(), spriteStore.getSprite("caro"), 50, 2);
        movableObjects.add(mob);
        controller.addMovable(mob);
        
        controller.bindTime(time);
        controller.bindLevel(level);
        controller.bindXP(player.expProperty());
        controller.bindHealth(player.pdvProperty());
        controller.bindLeftAnchor(leftAnchor);
        
        controller.bindInventory(player.getInventaire());
 
        RuleParser craftable = new RuleParser("craftrules.txt");
        craftable.parse();
        craftableObject = craftable.getObject();
        RuleParser furnace = new RuleParser("furnacerules.txt");
        furnace.parse();
        furnaceObject = furnace.getObject();
        
        
        animation.start();
        Resource pickaxe = new Resource("pioche", new InInventarie(spriteStore.getSprite("default_tool_woodpick"),null), ToolType.MEDIUM_TOOL, null, null);
        player.ajouterElementInventaire(pickaxe, 1);
        player.setItemInHand(pickaxe);
    }

	/**
     * Crée la carte du jeu.
     *
     * @return La carte du jeu créée.
     */
    private GameMap createMap() {
    	setiMap(new GenerateGameMap(getHeight()/14,getWidth()/30));
    	GameMap maps = iMap.returnMapCreate(spriteStore);
    	Arbre arbre = new Arbre(1000, 5, iMap);
    	arbre.returnMapCreate(spriteStore);
        return maps;
    }

    /**
     * Indique à cette partie de Flatcraft qu'une nouvelle heure s'est écoulée
     * (dans le jeu).
     */
    void oneHour() {
        time.set((time.get() + 1) % 24);
    }

    /**
     * Fait se déplacer le joueur vers le haut.
     */
    public void moveUp() {
        // TODO Implémentez cette méthode.
    }

    /**
     * Fait se déplacer le joueur vers le bas.
     */
    public void moveDown() {
        // TODO Implémentez cette méthode.
    }

    /**
     * Fait se déplacer le joueur vers la gauche.
     */
    public void moveLeft() {

        player.setHorizontalSpeed(-60);
        move(player);

        // TODO Implémentez cette méthode.
        lastDirection = -1;

    }

    /**
     * Fait se déplacer le joueur vers la droite.
     */
    public void moveRight() {

    	player.setHorizontalSpeed(+60);
    	move(player);

        // TODO Implémentez cette méthode.
        lastDirection = 1;
    }

    /**
     * Déplace un objet mobile en tenant compte de la gravité.
     *
     * @param movable L'objet à déplacer.
     */
    private void move(IMovable movable) {
        // On applique la gravité.
        Cell currentCell = getCellOf(movable);
        for (int row = currentCell.getRow() + 1; row < map.getHeight(); row++) {
            Cell below = map.getAt(row, currentCell.getColumn());
            if (!below.move(movable)) {
                break;
            }
        }

        // On positionne la carte pour afficher la section où se trouve le joueur.
        int middlePosition = player.getX() + player.getWidth() / 2;
        int mapSection = middlePosition / width;
        leftAnchor.set(-mapSection * width);
    }

    /**
     * Interrompt le déplacement du joueur.
     */
    public void stopMoving() {
        player.setHorizontalSpeed(0);
        move(player);
    }

    /**
     * Fait sauter le joueur.
     */
    public void jump() {
        // TODO Cette méthode vous sera fournie ultérieurement.
    }

    /**
     * Fait creuser le joueur vers le haut.
     */
    public void digUp() {
        // TODO Nous reviendrons plus tard sur cette méthode.
    }

    /**
     * Fait creuser le joueur vers le bas.
     */
    public void digDown() {
        Cell cellule = getCellOf(player);
        if (cellule.getRow() < map.getHeight()) {
        	Cell vise = map.getAt(cellule.getRow()+1,cellule.getColumn());
        	dig(vise);
        	move(player);
        }
        
    }

    /**
     * Fait creuser le joueur vers la gauche.
     */
    public void digLeft() {
    	Cell cellule = getCellOf(player);
        if (cellule.getColumn() > 0) {
        	Cell vise = map.getAt(cellule.getRow(),cellule.getColumn()-1);
        	dig(vise);
        	move(player);
        }
    }

    /**
     * Fait creuser le joueur vers la droite.
     */
    public void digRight() {
    	Cell cellule = getCellOf(player);
        if (cellule.getColumn() < map.getWidth()) {
        	Cell vise = map.getAt(cellule.getRow(),cellule.getColumn()+1);
        	dig(vise);
        	move(player);
        }
    }

    /**
     * Creuse la cellule donnée pour en extraire une ressource.
     *
     * @param toDig La cellule sur laquelle creuser.
     */
    private void dig(Cell toDig) {
        if(!toDig.dig(player)) {
        	toDig.replaceBy(cellFactory.createSky(0, 0));
        }
    }
    

    /**
     * Récupére la cellule correspondant à la position d'un objet mobile.
     * Il s'agit de la cellule sur laquelle l'objet en question occupe le plus de place.
     *
     * @param movable L'objet mobile dont la cellule doit être récupérée.
     *
     * @return La cellule occupée par l'objet mobile.
     */
    private Cell getCellOf(IMovable movable) {
        // On commence par récupérer la position du centre de l'objet.
        int midX = movable.getX() + (movable.getWidth() / 2);
        int midY = movable.getY() + (movable.getHeight() / 2);
        return getCellAt(midX, midY);
    }

    /**
     * Donne la cellule à la position donnée sur la carte.
     *
     * @param x La position en x de la cellule.
     * @param y La position en y de la cellule.
     *
     * @return La cellule à la position donnée.
     */
    public Cell getCellAt(int x, int y) {
        // On traduit cette position en position dans la carte.
        int row = y / spriteStore.getSpriteSize();
        int column = x / spriteStore.getSpriteSize();

        // On récupère enfin la cellule à cette position dans la carte.
        return map.getAt(row, column);
    }

    /**
     * Récupére la cellule correspondant à la prochaine position d'un objet mobile.
     * Il s'agit de la cellule voisine de celle sur laquelle l'objet en question occupe le
     * plus de place, en suivant la dernière direction suivie par joueur.
     *
     * @param movable L'objet mobile dont la prochaine cellule doit être récupérée.
     *
     * @return La prochaine cellule occupée par l'objet mobile.
     */
    private Optional<Cell> getNextCellOf(IMovable movable) {
        // On commence par récupérer la position du centre de l'objet.
        int midX = movable.getX() + (movable.getWidth() / 2);
        int midY = movable.getY() + (movable.getHeight() / 2);

        // On traduit cette position en position dans la carte.
        int row = midY / spriteStore.getSpriteSize();
        int column = midX / spriteStore.getSpriteSize() + lastDirection;

        // On récupère enfin la cellule à cette position dans la carte.
        if (column < map.getWidth()) {
            return Optional.of(map.getAt(row, column));
        }

        return Optional.empty();
    }

    /**
     * Crée une nouvelle ressource à l'aide d'un ensemble de ressources, en suivant les
     * règles de la table de craft.
     *
     * @param inputResources Les ressources déposées sur la table de craft.
     *
     * @return La ressource produite.
     */


    
	public Inventoriable craft(Inventoriable[][] inputResources) {
    	String rule = "";
    	for (int i = 0;i < inputResources.length ;i++) {
    		for (int y = 0; y < inputResources[i].length; y++) {
    			if (i == 0 && y == 0 && inputResources[i][y] == null) {
    				rule = rule+"empty";
    				continue;
    			}
    			if (i == 0 && y == 0 && inputResources[i][y] != null) {
    				rule = rule+inputResources[i][y].getName();
    				continue;
    			}
    			if (i == 2 && y == 2) {
    				rule = rule+"_empty";
    				continue;
    			}
    			if (inputResources[i][y] != null) {
    				rule = rule+"_"+inputResources[i][y].getName();
    			}
    			if (inputResources[i][y] == null) {
    				rule = rule+"_empty";
    			}
    			
    		}
    	}
    	Resource newResource = null;
    	ProductRule temp = new ProductRule();
    	temp.setRule(rule);

    	if (craftableObject.produitOuExiste(temp) != null) {
    		newResource = new Resource(craftableObject.produitOuExiste(temp), new InInventarie(spriteStore.getSprite("default_tool_steelpick"), null), null, null, new NonCombustible());
    		player.ajouterElementInventaire(newResource, 1);
    		
    	}
    	else {
    		FlatcraftController flatcraftController = new FlatcraftController();
			flatcraftController.displayError(rule);
    	}
		
		return newResource;
}


	/**
     * Crée une nouvelle ressource à l'aide d'un combustible et d'une ressource, en suivant les
     * règles du fourneau.
=======
    /**
     * Crée une nouvelle ressource à l'aide d'un combustible et d'une ressource, en
     * suivant les règles du fourneau.
>>>>>>> 5da6b6e8cbd7d3adc6c1d522907d64255d054cc3
     *
     * @param fuel Le matériau combustible utilisé dans le fourneau.
     * @param resource La ressource à transformer.
     *
     * @return La ressource produite.
     */
    public Inventoriable cook(Inventoriable fuel, Inventoriable resource) {
    	if (!((Resource) fuel).isCombustible()) {
    		FlatcraftController flatcraftController = new FlatcraftController();
			flatcraftController.displayError("pas combustible");
    	}
    	
    	Resource newResource = null;
    	ProductRule temp = null;
    	temp.setRule(resource+"");

    	if (furnaceObject.produitOuExiste(temp) != null) {
    		newResource = new Resource(furnaceObject.produitOuExiste(temp), null, null, null, new NonCombustible());
    	}
    	else {
    		FlatcraftController flatcraftController = new FlatcraftController();
			flatcraftController.displayError("Error");
    	}
		
		return newResource;

    }

    /**
     * Dépose sur la carte la ressource que le joueur a actuellement en main.
     */
    public void dropResource() {
        // On commence par rechercher la cellule voisine de celle du joueur, si elle
        // existe.
        Optional<Cell> next = getNextCellOf(player);
        if (next.isEmpty()) {
            return;
        }

        // Le dépôt ne peut fonctionner que si la cellule ne contient pas de ressource.
        Cell target = next.get();
        // TODO Récupérer la ressource que le joueur a actuellement en main.
        Inventoriable inHand = player.getItemInHand();
        if (target.setResource(inHand)) {
            // TODO Retirer la ressource de l'inventaire du joueur.
        	player.supprimerElementInventaire((Resource) inHand);
            switchResource();
        }
    }

    /**
     * Modifie la ressource que l'utilisateur a actuellement en main.
     * C'est la prochaine ressource dans l'inventaire qui est choisie.
     */
    public void switchResource() {
        if ((inventoryIterator == null) || (!inventoryIterator.hasNext())) {
            // TODO Récupérer l'inventaire du joueur.
            ObservableMap<Inventoriable, Integer> inventory = player.getInventaire();
            inventoryIterator = inventory.keySet().iterator();
        }

        Inventoriable inHand = inventoryIterator.next();
        // TODO Remplacer l'objet dans la main du joueur par inHand.
        player.setItemInHand(inHand);
    }

    /**
     * Exécute l'action associée à la ressource située sur la cellule voisine de celle du
     * joueur.
     */
    public void executeResource() {
        Optional<Cell> next = getNextCellOf(player);
        if (next.isPresent()) {
            Cell cell = next.get();
            cell.execute();
        }
    }

}
