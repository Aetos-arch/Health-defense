package TD.Controleur;

import TD.Modele.Partie;
import TD.Modele.Personnage.InfecteSansSymp;
import TD.Modele.Tir.Position;
import TD.Modele.Tir.TirVitamine;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    @FXML
    private TilePane tilePaneMap;
    @FXML
    private Pane panePers;
    @FXML
    private Label labelPV;
    @FXML
    private Label labelVague;
    @FXML
    private Label labelScore;
    @FXML
    private Label labelMoney;

    private Partie partie;
    private VueMap vM;
    private VuePers vP;
    private VueTourelle vT;
    private Timeline gameLoop;
    
    IntegerProperty nbTour;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.partie = new Partie();
        vM = new VueMap(partie.getEnv().getMap(), tilePaneMap);
        this.partie.getEnv().getTirs().addListener(new TirsListener(panePers));
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
    void CreePers(ActionEvent event) {
		this.partie.getEnv().ajouterPers(new InfecteSansSymp(0, 22, this.partie.getEnv()));
    	vP = new VuePers();
    	vP.translateXProperty().bind(this.partie.getEnv().getPersos().get(0).getXProperty());
    	vP.translateYProperty().bind(this.partie.getEnv().getPersos().get(0).getYProperty());
    	this.nbTour.addListener(e -> vP.changerSprite(nbTour.getValue()));
    	this.panePers.getChildren().add(vP);
    }

	@FXML
    void creerTourelle(ActionEvent event) {
        Tourelle t = new TourelleVitamine(0, 0, partie.getEnv());
        Position cible = new Position(1000, 229);
        new TirVitamine(t.getX(), t.getY(), cible, partie.getEnv());
        panePers.getChildren().add(new VueTourelle(t));
    }

    @FXML
    void action(ActionEvent event) {
    	gameLoop.play();
    }
}