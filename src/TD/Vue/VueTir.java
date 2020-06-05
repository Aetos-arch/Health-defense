package TD.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTir extends ImageView {
    private final String[] URL = {"Sources/Tirs/ball.png",};

    public VueTir(int url) {
        super();
        try {
        	this.setImage(new Image(URL[url]));
        }
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("L'URL recherchée n'existe pas, le tir n'est pas implémenté ou la liste d'url n'est pas à jour");
		}
    }
}