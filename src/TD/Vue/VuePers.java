package TD.Vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VuePers extends ImageView{
	
	
	public VuePers() {
		this.setImage(new Image("Sources/Males/M_07.png"));
		Rectangle2D rogne = new Rectangle2D(16, 19,16,16);
		this.setViewport(rogne);
	}

	public void changerSprite(int t) {
		if(t%20 == 10) {
			Rectangle2D rogne = new Rectangle2D(16, 3 ,16,16);
			this.setViewport(rogne);
		}
		else if(t%20 == 0){
			Rectangle2D rogne = new Rectangle2D(16, 19,16,16);
			this.setViewport(rogne);
		}
			
		
	}
	
}