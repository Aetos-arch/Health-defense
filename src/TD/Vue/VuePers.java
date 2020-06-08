package TD.Vue;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VuePers extends ImageView {

	private final String[] Url = {"Sources/Males/M_07.png", "Sources/Females/F_07.png",
									"Sources/Males/M_10.png", "Sources/Males/M_01.png"};
	
	private ArrayList<VueHoT> listeHoT;

	public VuePers(int url) {
			this.setImage(new Image(Url[url]));
			Rectangle2D rogne = new Rectangle2D(16, 1, 16, 16);
			this.setViewport(rogne);
			this.listeHoT = new ArrayList<VueHoT>();
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

	public void changerSpriteSain(Pane p) {
		this.setImage(new Image(Url[3]));
		p.getChildren().removeAll(listeHoT);
	}

	public void afficherHoT(Integer value, Pane p) {
		VueHoT h = new VueHoT();
		h.translateXProperty().bind(this.translateXProperty());
		h.translateYProperty().bind(this.translateYProperty());
		p.getChildren().add(h);
		this.listeHoT.add(h);
		if(value == 0)
			p.getChildren().removeAll(listeHoT);
	}
	
	public void enleverHoT(Pane p) {
		p.getChildren().removeAll(listeHoT);		
	}
}