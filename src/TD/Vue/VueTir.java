package TD.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTir extends ImageView {
    private final String[] URL = {"Sources/Tirs/ball.png", "Sources/Tirs/TirSeringue.png"};

    public VueTir(int url) {
        super();
        this.setImage(new Image(URL[url]));
    }
}