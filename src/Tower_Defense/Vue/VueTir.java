package Tower_Defense.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTir extends ImageView {
    private final String[] URL = {"Sources/Tirs/TirVitamine.png", "Sources/Tirs/TirSeringue.png", "Sources/Tirs/TirVaccin.png", "Sources/Tirs/TirFiole.gif"};

    public VueTir(int url) {
        super();
        this.setImage(new Image(URL[url]));
    }
}