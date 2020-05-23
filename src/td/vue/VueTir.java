package td.vue;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import td.modele.Tir;
import javafx.scene.image.ImageView;

public abstract class VueTir extends ImageView {

    public VueTir (Tir tir, String urlImage) {
        super();
        this.setImage(new Image(urlImage));
        this.xProperty().bind(tir.xProperty());
        this.yProperty().bind(tir.yProperty());
    }
}