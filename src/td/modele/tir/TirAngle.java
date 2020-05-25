package td.modele.tir;

import td.modele.Environnement;

public abstract class TirAngle extends Tir {

    public TirAngle(int x, int y, int pointAttaque, int xCible, int yCible, int v, Environnement env, double portee) {
        super(x, y, pointAttaque, xCible, yCible, v, env, portee);
        this.calculerDirection(xCible, yCible);
    }

    public void calculerDirection (double xCible, double yCible) {
        Position projectile = new Position(this.getX(), this.getY());
        Position cible = new Position(xCible, yCible);
        Vecteur v = new Vecteur(projectile, cible);
        System.out.println("NORME VECTEUR : " + v.normeVecteur());
        System.out.println(projectile.toString());
        System.out.println(cible.toString());
        v.multiplier(3 / v.normeVecteur());
        this.dx = v.getX();
        this.dy = v.getY();
        System.out.println("valeurs dx : " + dx + "valeurs dy :  " + dy);
    }
}