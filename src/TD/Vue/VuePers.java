package TD.Vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class VuePers extends ImageView {

	private final String[] Url = {"Sources/Personnages/infecteSansSymptomeMove.png", "Sources/Personnages/infecteJoggerMove.png",
			"Sources/Personnages/infecteGraveMove.png", "Sources/Personnages/infecteQuiTousseMove.png", "Sources/Personnages/personnageSainMove.png"};

	private ArrayList<VueHoT> listeHoT;
	private VueProtect vueProt;

	public VuePers(int url) {
		this.setImage(new Image(Url[url]));
		Rectangle2D rogne = new Rectangle2D(0, 0, 16, 16);
		this.setViewport(rogne);
		this.listeHoT = new ArrayList<VueHoT>();
	}

	public void changerSprite(int t) {
		if (t % 20 == 10) {
			Rectangle2D rogne = new Rectangle2D(0, 0, 16, 16);
			this.setViewport(rogne);
		} else if (t % 20 == 0) {
			Rectangle2D rogne = new Rectangle2D(16, 0, 16, 16);
			this.setViewport(rogne);
		}
	}

	public void changerSpriteSain(Pane p) {
		this.setImage(new Image(Url[4]));
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
	
	public void protectionPers(Integer v, Pane p) {
		if(v == 1) {
			this.vueProt = new VueProtect();
			this.vueProt.translateXProperty().bind(this.translateXProperty());
			this.vueProt.translateYProperty().bind(this.translateYProperty());
			this.vueProt.setY(this.vueProt.getY()-8);
			this.vueProt.setX(this.vueProt.getX()+4);
			p.getChildren().add(vueProt);
		}
		else
			p.getChildren().remove(vueProt);
		
	}
}