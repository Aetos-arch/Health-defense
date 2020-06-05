package TD.Controleur;

import TD.Exception.MoneyException;
import TD.Exception.PlacementException;
import TD.Modele.Partie;
import TD.Modele.Tourelle.TourelleSeringue;
import TD.Modele.Tourelle.TourelleVaccin;
import TD.Modele.Tourelle.TourelleVitamine;
import TD.Vue.VueMap;
import TD.Vue.VuePers;
import TD.Vue.VueTourelle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    @FXML
    private TilePane tilePaneMap;
    @FXML
    private Pane paneEntite;
    @FXML
    private Label labelPV;
    @FXML
    private Label labelVague;
    @FXML
    private Label labelScore;
    @FXML
    private Label labelMoney;
    @FXML
    private Label labelInfo;

    private Partie partie;
    private VueMap vM;
    private VuePers vP;
    private VueTourelle vT;
    private Timeline gameLoop;

    public IntegerProperty nbTour;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.partie = new Partie();
        vM = new VueMap(partie.getEnv().getMap(), tilePaneMap);
        this.partie.getEnv().getTirs().addListener(new ListenerTirs(paneEntite));
        this.partie.getEnv().getTours().addListener(new ListenerTourelles(paneEntite));
        this.partie.getEnv().getPersos().addListener(new ListenerPers(paneEntite, this));
        initGame();
        this.partie.getEnv().creerArbre();
        this.nbTour = new SimpleIntegerProperty();
        this.nbTour.set(0);
        this.labelMoney.textProperty().bind(this.partie.moneyProperty().asString());
        this.labelScore.textProperty().bind(this.partie.scoreProperty().asString());
        this.labelVague.textProperty().bind(this.partie.vagueProperty().asString());
        this.labelPV.textProperty().bind(this.partie.pvProperty().asString());
        
    }
    
    private void initGame() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(Duration.seconds(0.02),(ev ->{

			if(this.partie.estPerdu()){
				this.labelInfo.textProperty().setValue("game over");
				gameLoop.stop();
			}
			else if(this.partie.niveauFini()) {
				gameLoop.stop();
			}
			else {
				this.partie.unTour();
				this.nbTour.set(this.nbTour.getValue() + 1);
			}
        }));
        gameLoop.getKeyFrames().add(kf);
    }
    
    @FXML
    void onDragDetected(MouseEvent event) {
    	ImageView imageview = (ImageView) event.getTarget();
        Dragboard db = imageview.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        Image image = new Image("Sources/Tourelles/" + imageview.getId() + "Dragged.png");
        db.setDragView(image,8,8);
        cb.putString(imageview.getId());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    void onDragOver(DragEvent event) {
        if (event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    
    @FXML
    void onDragDropped(DragEvent event) {
    	if(event.getX() != 800 && event.getY() != 480) {
    		try {
    			switch (event.getDragboard().getString()) {
			          case "tourelleVitamine":
			        	  this.partie.ajouterTour(new TourelleVitamine((int) Math.floor(event.getX() / 16) * 16, (int) Math.floor(event.getY() / 16) * 16, partie.getEnv()));
			        	  break;

			          case "tourelleSeringue":
			        	  this.partie.ajouterTour(new TourelleSeringue((int) Math.floor(event.getX() / 16) * 16, (int) Math.floor(event.getY() / 16) * 16, partie.getEnv()));
			        	  break;
			            
			          case "tourelleVaccin":
			        	  this.partie.ajouterTour(new TourelleVaccin((int) Math.floor(event.getX() / 16) * 16, (int) Math.floor(event.getY() / 16) * 16, partie.getEnv()));
			        	  break;
			        	  
			          default:
			        	  break;
		        }
    		}
    		catch (MoneyException e) {
    			this.labelInfo.textProperty().setValue("Pas assez d'argent!");
    		}
    		catch (PlacementException e) {
    			this.labelInfo.textProperty().setValue("Placement impossible");
    		}
    	}
    }


    @FXML
    void action(ActionEvent event) {
        gameLoop.play();
        if(this.partie.getVague() == 0)
        	this.partie.lancerNiveau();
        if(this.partie.niveauFini())
        	this.partie.lancerNiveau();
    }

    public int getTour() {
        return this.nbTour.get();
    }
    
    public Partie getPartie() {
    	return this.partie;
    }
}