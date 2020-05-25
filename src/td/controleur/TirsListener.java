package td.controleur;

import javafx.collections.SetChangeListener;
import javafx.scene.layout.Pane;
import td.modele.tir.Tir;
import td.modele.tir.TirVitamine;
import td.vue.VueTir;
import td.vue.VueTirVitamine;

import java.util.HashMap;

import java.util.Map;


public class TirsListener implements SetChangeListener<Tir> {
    Pane map;
    Map <Tir, VueTir> modelToView;

    public TirsListener(Pane map) {
        this.modelToView = new HashMap<>();
        this.map = map;
    }

    // Liste de changement de tir en para, ? = nmptqll
    @Override
    public void onChanged(SetChangeListener.Change<? extends Tir> change) {
        // Si ajout
        if (change.wasAdded()) {
            Tir tir = change.getElementAdded();
            VueTir vT;
            if (tir instanceof TirVitamine) {
                vT = new VueTirVitamine(tir);
            }
            // else autres tir
            else {
                throw new IllegalArgumentException();
            }
            // garder en memoire association du tir avec son image
            modelToView.put(tir, vT);
            map.getChildren().add(vT);
        }

        if (change.wasRemoved()) {
            map.getChildren().remove(modelToView.get(change.getElementRemoved()));
        }
    }
}