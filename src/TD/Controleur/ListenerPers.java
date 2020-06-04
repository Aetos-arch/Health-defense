package TD.Controleur;

import TD.Modele.Personnage.InfecteSansSymp;
import TD.Modele.Personnage.Personnage;
import TD.Vue.VuePers;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ListenerPers implements ListChangeListener<Personnage> {

	Pane panePers;
	HashMap<Personnage, VuePers> correspondance;
	Controleur c;

	public ListenerPers(Pane p, Controleur c) {
		this.panePers = p;
		this.correspondance = new HashMap<Personnage, VuePers>();
		this.c = c;
	}

	@Override
	public void onChanged(Change<? extends Personnage> change) {
		while(change.next()) {
			if(change.wasAdded()) {
				for(Personnage p: change.getAddedSubList()) {

					VuePers vP;
					if (p instanceof InfecteSansSymp) {
						vP = new VuePers();
						vP.translateXProperty().bind(p.getXProperty());
						vP.translateYProperty().bind(p.getYProperty());
						this.c.nbTour.addListener(e -> vP.changerSprite(this.c.nbTour.getValue()));
						this.panePers.getChildren().add(vP);
						this.correspondance.put(p, vP);
					}
				}	
			}
			else if(change.wasRemoved()) {
				for(Personnage p: change.getRemoved()) {
					if(p instanceof InfecteSansSymp && !p.estArrive()) {
						this.c.getPartie().augmenterMoney(100);
						this.c.getPartie().augmenterScore(50);
					}
					else {
						this.c.getPartie().perdrePV(1);
					}
					this.panePers.getChildren().remove(this.correspondance.get(p));
				}

			}
		}
	}

}
