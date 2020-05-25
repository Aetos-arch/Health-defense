package td.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import td.modele.tourelle.Tourelle;

public class vueTourelle extends ImageView {

    public vueTourelle(Pane panePers, int x, int y) {
        super();
        this.setImage(new Image("Sources/rsz_1wh.png"));
        this.setX(x);
        this.setY(y);
        panePers.getChildren().add(this);
    }
}