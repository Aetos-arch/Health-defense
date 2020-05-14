package td.modele;

import javafx.beans.property.IntegerProperty;

public class Tir {
    private IntegerProperty x;
    private IntegerProperty y;
    private int pointAttaque;
    private int v; // vitesse de deplacement
    private int dx,dy ;// direction

    public Tir(IntegerProperty x, IntegerProperty y, int pointAttaque, int v) {
        this.x = x;
        this.y = y;
        this.pointAttaque = pointAttaque;
        this.v = v;
    }

    public void Viser (int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
