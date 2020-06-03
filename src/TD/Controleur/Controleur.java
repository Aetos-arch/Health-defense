package TD.Controleur;

import TD.Modele.Partie;
import TD.Modele.Tourelle.Tourelle;
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
    private ImageView dragTourelle;
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
        this.partie.getEnv().getPersos().addListener(new ListenerPers(paneEntite, this));
        initGame();
        this.partie.getEnv().creerArbre();
        this.nbTour = new SimpleIntegerProperty();
        this.nbTour.set(0);
        this.labelMoney.textProperty().bind(this.partie.moneyProperty().asString());
        this.labelScore.textProperty().bind(this.partie.scoreProperty().asString());
        this.labelVague.textProperty().bind(this.partie.vagueProperty().asString());
        this.labelPV.textProperty().bind(this.partie.pvProperty().asString());

        this.dragTourelle.setImage(new Image("Sources/Tourelles/tourelle1.png"));
        
    }
    
    private void initGame() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(Duration.seconds(0.02),(ev ->{

			if(this.partie.estPerdu()){
				System.out.println("perdu");
				System.out.println("game over");
				gameLoop.stop();
			}
			else if(this.partie.niveauFini()) {
				System.out.println("Niveau fini");
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
    void dragDetected(MouseEvent event) {
        Dragboard db = dragTourelle.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        Image image = (dragTourelle.getImage());
        db.setDragView(image,8,8);
        cb.putImage(image);
        db.setContent(cb);
        event.consume();
    }

    @FXML
    void dragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    
    @FXML
    void dragDropped(DragEvent event) {
    	if(this.partie.getMoney() < 500)
    		this.labelInfo.textProperty().setValue("fond insuffisant");
    	if(event.getX() != 800 && event.getY() != 480) {
	        Tourelle t = new TourelleVitamine((int) Math.floor(event.getX()/16)*16, (int) Math.floor(event.getY()/16)*16, partie.getEnv());
	        this.partie.ajouterTour(t);
	        this.partie.diminuerMoney(500);
	        paneEntite.getChildren().add(new VueTourelle(t));
    	}
    }

    @FXML
    void action(ActionEvent event) {
        gameLoop.play();
        this.partie.lancerNiveau();
    }

    public int getTour() {
        return this.nbTour.get();
    }
    
    public Partie getPartie() {
    	return this.partie;
    }
}