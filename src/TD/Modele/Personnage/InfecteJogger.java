package TD.Modele.Personnage;

import TD.Modele.Environnement;

public class InfecteJogger extends Personnage {
	public InfecteJogger(int x, int y, Environnement e) {
        super(2, 150, x, y, e);
    }
	
	@Override
	public void seFaireSoigner(int d) {
		this.soin(d);
		this.setVit(8);
	}
}
