package TD.Vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class VueMap {

	private int [][] map;
	private TilePane tilePaneMap;
	
	public VueMap(int [][] m, TilePane t) {
		this.map=m;
		this.tilePaneMap=t;
		this.affichMap();
	}
	
	public void affichMap() {
		for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
            	ImageView tile = new ImageView("Sources/tilesetFinal.png");
                Rectangle2D rogne = new Rectangle2D((map[i][j])%20*16,(map[i][j]/20)*16,16,16);
                tile.setViewport(rogne);
                tilePaneMap.getChildren().add(tile);
            }
        }
	}
}
