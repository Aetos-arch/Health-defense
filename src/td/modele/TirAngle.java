package td.modele;

public abstract class TirAngle extends Tir {

    public TirAngle(int x, int y, int pointAttaque, int xCible, int yCible, int v, Environnement env, double portee) {
        super(x, y, pointAttaque, xCible, yCible, v, env, portee);
        calculerDirection(xCible, yCible);
    }

    public void calculerDirection (int xCible, int yCible) {
        int tempX = this.xProperty.getValue() - xCible;
        int tempY = this.yProperty.getValue() - yCible;

        if (tempX < 0)
            this.dx = 1;
        else if (tempX == 0)
            this.dx = 0;
        else
            this.dx = -1;

        if (tempY < 0)
            this.dy = 1;
        else if (tempX == 0)
            this.dy = 0;
        else
            this.dy = -1;
    }
}