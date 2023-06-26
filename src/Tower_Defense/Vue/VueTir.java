package Tower_Defense.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTir extends ImageView {
    private final String[] URL = {"Resources/Tirs/TirVitamine.png", "Resources/Tirs/TirSeringue.png", "Resources/Tirs/TirVaccin.png", "Resources/Tirs/TirFiole.gif"};

    public VueTir(int url) {
        super();
        this.setImage(new Image(URL[url]));
    }
}