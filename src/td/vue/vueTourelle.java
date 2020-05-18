package td.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import td.modele.Environnement;

public class vueTourelle {

    private Environnement env;
    private Pane PaneTourelle; // tile avec id

    public vueTourelle(Pane p, Environnement e) {
        this.PaneTourelle = p;
        this.env = e;
    }
    public void afficherTourelle() {
        ImageView c = new ImageView("PersSprint1.png");
        //c.translateXProperty().bind(this.env.getPersos().get(0).getX());
        //c.translateYProperty().bind(this.env.getPersos().get(0).getY());
        this.PaneTourelle.getChildren().add(c);
    }
}