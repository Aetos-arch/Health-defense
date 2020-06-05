package TD.Vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VuePers extends ImageView {

	private final String[] Url = {"Sources/Males/M_07.png", "Sources/Females/F_07.png",
									"Sources/Males/M_10.png"};
	
	public VuePers(int url) {
		try {
			this.setImage(new Image(Url[url]));
			Rectangle2D rogne = new Rectangle2D(16, 1, 16, 16);
			this.setViewport(rogne);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("L'URL recherchée n'existe pas, le personnage n'est pas implenté ou la liste d'url n'est pas à jour");
		}	
	}

	public void changerSprite(int t) {
		if (t % 20 == 10) {
			Rectangle2D rogne = new Rectangle2D(16, 1, 16, 16);
			this.setViewport(rogne);
		} else if (t % 20 == 0) {
			Rectangle2D rogne = new Rectangle2D(16, 18, 16, 16);
			this.setViewport(rogne);
		}
	}
}
