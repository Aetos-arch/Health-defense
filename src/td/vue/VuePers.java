package td.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import td.modele.Environnement;

public class VuePers {
	
	private Environnement env;
	private Pane PanePers;
	
	public VuePers(Pane t, Environnement e) {
		this.PanePers=t;
		this.env = e;
	}
	public void affichPers() {
		/*ImageView c = new ImageView("PersSprint1.png");
    	c.translateXProperty().bind(this.env.getPersos().get(0).getX());
    	c.translateYProperty().bind(this.env.getPersos().get(0).getY());
    	this.PanePers.getChildren().add(c);*/
	}
}
