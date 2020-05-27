package TD.Vue;

import TD.Modele.Tourelle.Tourelle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTourelle extends ImageView {

    public VueTourelle(Tourelle t) {
        super();
        this.setImage(new Image("Sources/Tourelles/rsz_1wh.png"));
        this.setX(t.getX());
        this.setY(t.getY());
    }
}