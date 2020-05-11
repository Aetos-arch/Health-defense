package td.controleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import td.modele.Environnement;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    @FXML
    private TilePane tilePaneMap;

    private Environnement env;
    @Override


    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement();
        int tab[][] = this.env.getMap();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                switch(tab[i][j]) {
                    case 386:

                        ImageView test = new ImageView("C:/Users/33610/Downloads/tiles.png");
                        tilePaneMap.getChildren().add(test);

   /*               case 387:

                    case 388:

                    case 389:

                    case 410:

                    case 262:

                    case 263:

                    case 264:

                    case 265:

                    case 266:

                    case 267:

                    case 412:

                    case 411:

                    case 413: */

                }
            }
        }
    }


}