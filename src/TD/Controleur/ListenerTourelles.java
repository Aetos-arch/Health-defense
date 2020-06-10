package TD.Controleur;


import TD.Modele.Tourelle.*;
import TD.Vue.VueTourelle;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class ListenerTourelles implements ListChangeListener<Tourelle> {
    Pane map;
    Map<Tourelle, VueTourelle> modelToView;

    public ListenerTourelles(Pane map) {
        this.map = map;
        this.modelToView = new HashMap<Tourelle, VueTourelle>();
    }

    @Override
    public void onChanged(ListChangeListener.Change<? extends Tourelle> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Tourelle tourelle : change.getAddedSubList()) {
                    VueTourelle vT = null;
                    if (tourelle instanceof TourelleVitamine) {
                        vT = new VueTourelle(0);
                    } else if (tourelle instanceof TourelleSeringue) {
                        vT = new VueTourelle(1);
                    } else if (tourelle instanceof TourelleVaccin) {
                        vT = new VueTourelle(2);
                    } else if (tourelle instanceof TourelleDuCiel) {
                        vT = new VueTourelle(3);
                    }
                    vT.setX(tourelle.getX());
                    vT.setY(tourelle.getY());

                    // garder en memoire association du tir avec son image
                    modelToView.put(tourelle, vT);
                    map.getChildren().add(vT);
                }
            }
            if (change.wasRemoved()) {
                for (Tourelle tourelle : change.getRemoved()) {
                    map.getChildren().remove(modelToView.get(tourelle));
                    modelToView.remove(tourelle);
                }
            }
        }
    }
}
