package TD.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTourelle extends ImageView {
    private final String[] URL = {"Sources/Tourelles/tourelle1.png", "Sources/Tourelles/TourelleSeringue.png"};

    public VueTourelle(int url) {
        super();
        try {
        	this.setImage(new Image(URL[url]));
        }
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("L'URL recherchée n'existe pas, la tourelle n'est pas implémentée ou la liste d'url n'est pas à jour");
		}
    }
}