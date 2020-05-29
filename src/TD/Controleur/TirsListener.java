package TD.Controleur;

import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVitamine;
import TD.Vue.VueTir;
import TD.Vue.VueTirVitamine;
import javafx.collections.SetChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;


public class TirsListener implements ListChangeListener<Tir> { // pourquoi Set
    Pane map;
    Map <Tir, VueTir> modelToView;

    public TirsListener(Pane map) {
        this.map = map;
        this.modelToView = new HashMap<>();
    }

    @Override
    public void onChanged(Change<? extends Tir> change) {
        // Si ajout
    	while(change.next()) {
	        if (change.wasAdded()) {
	        	for(Tir tir :change.getAddedSubList()) {
		            VueTir vT;
		            if (tir instanceof TirVitamine) {
		                vT = new VueTirVitamine(tir);
			            // garder en memoire association du tir avec son image
			            modelToView.put(tir, vT);
			            map.getChildren().add(vT);
		            }
	        	}
	        }
	        if (change.wasRemoved()) {
	        	for(Tir tir :change.getRemoved()) {
	        		map.getChildren().remove(modelToView.get(tir));
	        		System.out.println("Supprimer");
	        	}
	        }
	        	
    	}
    }
}