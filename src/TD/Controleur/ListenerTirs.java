package TD.Controleur;

import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVitamine;
import TD.Vue.VueTir;
import TD.Vue.VueTirVitamine;
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
		            VueTir vT;
		            if (tir instanceof TirVitamine) {
		                vT = new VueTirVitamine(tir);
		            }else {
		                throw new IllegalArgumentException();
		            }
		            // garder en memoire association du tir avec son image
		            modelToView.put(tir, vT);
		            map.getChildren().add(vT);
	        	}
	        }
	        if (change.wasRemoved()) {
	        	for(Tir tir : change.getRemoved()) {
	        		map.getChildren().remove(modelToView.get(tir));
	        		modelToView.remove(tir);

	        	}
	        }  	
    	}
    }

}