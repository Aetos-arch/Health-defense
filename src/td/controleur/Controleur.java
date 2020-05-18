package td.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import td.modele.Environnement;
import td.modele.Map;
import td.modele.Partie;
import td.vue.VueMap;
import td.vue.VuePers;

import java.net.URL;
import java.util.ResourceBundle;


public class Controleur implements Initializable {

    @FXML
    private TilePane tilePaneMap;
    @FXML
    private Pane panePers;

    private Environnement env;
    private Partie partie;

    private VueMap vM;
    private VuePers vP;
    
    private Timeline gameLoop;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement();
        this.partie = new Partie(env);
        Map m = new Map("src/Sources/map.csv");
        vM = new VueMap(m.getMap(), tilePaneMap);
        initGame();
    }
    
    private void initGame() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(Duration.seconds(0.2),(ev ->{
			if(this.partie.estPerdu()){
				System.out.println("game over");
				gameLoop.stop();
			}
			else if(this.partie.niveauFini()) {
				gameLoop.stop();
			}
			else {
				this.partie.unTour();
			}
		}));
		gameLoop.getKeyFrames().add(kf);
	}
    
	@FXML
    void CreePers(ActionEvent event) {
    	vP = new VuePers(panePers, env);
    	vP.affichPers();
    }
    @FXML
    void action(ActionEvent event) {
    	gameLoop.play();
    }

}