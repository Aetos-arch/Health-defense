package td.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import td.modele.Environnement;
import td.modele.Map;
import td.modele.Personnage;
import td.vue.VueMap;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    @FXML
    private TilePane tilePaneMap;
    @FXML
    private Pane panePers;

    private Environnement env;

    private VueMap vM;
    private VuePers vP;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(Map.map1);
        this.env.ajouterPers(new Personnage());
        int tab[][] = this.env.getMap();
        tilePaneMap.setMaxWidth(20*16);
        tilePaneMap.setMaxHeight(20*16);
        vM = new VueMap(tab, tilePaneMap);
        vM.affichMap();
    }
    @FXML
    void CreePers(ActionEvent event) {
    	vP = new VuePers(panePers, env);
    	vP.affichPers();
    }
    @FXML
    void action(ActionEvent event) {
    	GameLoop g = new GameLoop(env);
    	g.run();
    }


}