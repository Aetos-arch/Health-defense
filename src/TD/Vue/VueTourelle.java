package TD.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTourelle extends ImageView {
    private final String[] URL = {"Sources/Tourelles/TourelleVitamine.png", "Sources/Tourelles/TourelleSeringue.png",};

    public VueTourelle(int url) {
        super();
        	this.setImage(new Image(URL[url]));
    }
}