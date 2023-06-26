package Tower_Defense.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTourelle extends ImageView {
    private final String[] URL = {"Resources/Tourelles/tourelleVitamineDragged.png", "Resources/Tourelles/tourelleSeringueDragged.png", "Resources/Tourelles/tourelleVaccinDragged.png", "Resources/Tourelles/tourelleFioleDragged.png"};

    public VueTourelle(int url) {
        super();
        	this.setImage(new Image(URL[url]));
    }
}