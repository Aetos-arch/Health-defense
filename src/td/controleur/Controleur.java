package td.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import td.modele.*;
import td.vue.VueMap;
import td.vue.VuePers;
import td.vue.vueTourelle;

import java.net.URL;
import java.util.ResourceBundle;


public class Controleur implements Initializable {

    @FXML
    private TilePane tilePaneMap;
    @FXML
    private Pane panePers;

    private Partie partie;
    private VueMap vM;
    private VuePers vP;
    private vueTourelle vT;
    private Timeline gameLoop;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.partie = new Partie();
        vM = new VueMap(partie.getEnv().getMap(), tilePaneMap);
        this.partie.getEnv().getTirs().addListener(new TirsListener(panePers));
        initGame();
    }
    
    private void initGame() {
		System.out.println("keyframe");
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(Duration.seconds(0.05),(ev ->{
			System.out.println("dans keyframe");
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
				System.out.println("Un tour");
				this.partie.unTour();
			}
		}));
		gameLoop.getKeyFrames().add(kf);
	}
    
	@FXML
    void CreePers(ActionEvent event) {
		System.out.println("creer pers 1");
    	vP = new VuePers(panePers, this.partie.getEnv());
    	vP.affichPers();
    	creerTourelle();
    }

	void creerTourelle () {
    	Tourelle t = new TourelleVitamine(0, 0, partie.getEnv());
		new TirVitamine(t.getX(), t.getY(), 20,  555, partie.getEnv());
	}

	void creerTir () {

	}

    @FXML
    void action(ActionEvent event) {
    	gameLoop.play();
    }
}