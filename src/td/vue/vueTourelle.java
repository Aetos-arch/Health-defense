package td.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import td.modele.tourelle.Tourelle;

public class vueTourelle extends ImageView {

    public vueTourelle(Tourelle t) {
        super();
        this.setImage(new Image("Sources/rsz_1wh.png"));
        this.setX(t.getX());
        this.setY(t.getY());
    }
}