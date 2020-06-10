package TD.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTourelle extends ImageView {
    private final String[] URL = {"Sources/Tourelles/tourelleVitamineDragged.png", "Sources/Tourelles/tourelleSeringueDragged.png", "Sources/Tourelles/tourelleVaccinDragged.png", "Sources/Tourelles/tourelleCiel.png"};

    public VueTourelle(int url) {
        super();
        	this.setImage(new Image(URL[url]));
    }
}