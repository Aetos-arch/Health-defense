package TD.Controleur;

import TD.Modele.Tir.*;
import TD.Vue.VueTir;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class ListenerTirs implements ListChangeListener<Tir> { 
    Pane map;
    Map <Tir, VueTir> modelToView;

    public ListenerTirs(Pane map) {
        this.map = map;
        this.modelToView = new HashMap<Tir, VueTir>();
    }

    @Override
    public void onChanged(Change<? extends Tir> change) {
    	while(change.next()) {
	        if (change.wasAdded()) {
	        	for(Tir tir :change.getAddedSubList()) {
                    VueTir vT = null;
                    if (tir instanceof TirVitamine) {
                        vT = new VueTir(0);
                    } else if (tir instanceof TirSeringue) {
                        vT = new VueTir(1);
                    } else if (tir instanceof TirVaccin) {
                        vT = new VueTir(2);
                    } else if (tir instanceof TirCiel) {
                        vT = new VueTir(3);
                    }

                    vT.translateXProperty().bind(tir.xProperty());
                    vT.translateYProperty().bind(tir.yProperty());

                    if (tir instanceof TirCiel) {
                        vT.setX(vT.getX() - 24);
                        vT.setY(vT.getY() - 24);
                    }

                    // garder en memoire association du tir avec son image
                    modelToView.put(tir, vT);
                    map.getChildren().add(vT);
                }
	        }
	        if (change.wasRemoved()) {
                for (Tir tir : change.getRemoved()) {
                    map.getChildren().remove(modelToView.get(tir));
                    modelToView.remove(tir);
                }
            }
    	}
    }

}